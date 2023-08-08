package com.atguigu.process.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.atguigu.auth.service.Impl.SysUserServiceImpl;
import com.atguigu.auth.service.utils.OaProcessRecordServiceImpl;
import com.atguigu.model.process.*;
import com.atguigu.model.process.Process;
import com.atguigu.model.system.ProcessQueryVo;
import com.atguigu.model.system.ProcessVo;
import com.atguigu.model.system.SysUser;
import com.atguigu.process.mapper.OaProcessMapper;
import com.atguigu.process.service.OaProcessService;
import com.atguigu.security.custom.LoginUserInfoHelper;
import com.atguigu.wechat.service.MessageService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.activiti.bpmn.model.*;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricTaskInstanceQuery;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.beans.BeanUtils;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.zip.ZipInputStream;

@Slf4j
@Service
public class OaProcessServiceImpl extends ServiceImpl<OaProcessMapper, Process> implements OaProcessService {

    @Resource
    private RepositoryService repositoryService;
    @Resource
    private RuntimeService runtimeService;
    @Resource
    private SysUserServiceImpl sysUserService;
    @Resource
    private OaProcessTemplateServiceImpl processTemplateService;
    @Resource
    private TaskService taskService;
    @Resource
    private OaProcessRecordServiceImpl processRecordService;
    @Resource
    private HistoryService historyService;
    @Resource
    private MessageService messageService;

    @Override
    public IPage<ProcessVo> selectPage(Page<ProcessVo> pageParam, ProcessQueryVo processQueryVo) {
        return baseMapper.selectPage(pageParam, processQueryVo);
    }

    @Override
    public void deployByZip(String zipPath) {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(zipPath);
        ZipInputStream zipInputStream = new ZipInputStream(inputStream);

        try {
            Deployment deployment = repositoryService.createDeployment().addZipInputStream(zipInputStream).deploy();
            log.info("id={} name={}", deployment.getId(), deployment.getName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void startUp(ProcessFormVo processFormVo) {
        // 1 根据 用户id 获取
        SysUser sysUser = sysUserService.getById(LoginUserInfoHelper.getUserId());

        // 2 根据模板 id 查模板信息
        ProcessTemplate processTemplate = processTemplateService.getById(processFormVo.getProcessTemplateId());

        // 3 记录提交的审批信息
        Process process = new Process();
        BeanUtils.copyProperties(processFormVo, process);
        process.setStatus(1);
        process.setProcessCode(System.currentTimeMillis() + "");
        process.setUserId(sysUser.getId());
        process.setTitle(sysUser.getName() + " 发起 " + processTemplate.getName() + " 申请");
        baseMapper.insert(process);

        // 4 启动流程示例
        // 4.1 流程定义的key
        String processDefinitionKey = processTemplate.getProcessDefinitionKey();
        // 4.2 业务 key processId
        Long processId = process.getId();
        // 4.3 流程参数
        JSONObject jsonObject = JSON.parseObject(processFormVo.getFormValues());
        JSONObject fromData = jsonObject.getJSONObject("formData");
        HashMap<String, Object> hashMap = new HashMap<>();
        for (Map.Entry<String, Object> entry : fromData.entrySet()) {
            hashMap.put(entry.getKey(), entry.getValue());
        }
        HashMap<String, Object> data = new HashMap<>();
        data.put("fromData", hashMap);
        // 开启
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey,
                String.valueOf(processId),
                data);

        // 5 下一个审批人 (可能有多个)
        List<Task> taskList = this.getCurrentTaskList(processInstance.getId());
        List<SysUser> userList = taskList.stream().map(task -> {
            return sysUserService.getUserByUsername(task.getAssignee());
        }).collect(Collectors.toList());

        // 6 推送消息给审批人
        for (Task task : taskList) {
            messageService.pushPendingMessage(processId, sysUser.getId(), task.getId());
        }

        // 7 更新状态 oa_process
        process.setProcessInstanceId(processInstance.getId());
        process.setDescription("等待 " + StringUtils.join(userList, "，") + " 进行审批...");
        baseMapper.updateById(process);

        processRecordService.record(processId, 1, "发起申请");
    }

    /**
     * 查询待处理任务
     *
     * @param pageParam
     * @return
     */
    @Override
    public IPage<ProcessVo> findPending(IPage<Process> pageParam) {
        // 1 拿到当前登录用户 封装查询对象
        TaskQuery query = taskService
                .createTaskQuery()
                .taskAssignee(LoginUserInfoHelper.getUsername())
                .orderByTaskCreateTime()
                .desc();

        // 2 分页条件查询 得到待办任务列表
        List<Task> taskList = query.listPage((int) ((pageParam.getCurrent() - 1) * pageParam.getSize()), (int) pageParam.getSize());

        // 3 数据中枚举数据转换为具体文字
        List<ProcessVo> processVoList = new ArrayList<>();
        for (Task task : taskList) {
            // 流程实例 id
            String processInstanceId = task.getProcessInstanceId();

            // 根据流程实例 id 查对象
            ProcessInstance processInstance = runtimeService
                    .createProcessInstanceQuery()
                    .processInstanceId(processInstanceId)
                    .singleResult();

            // 从流程示例拿业务 key （就是 process 的 id 这个值是我们自己自定义的，就是为了通过这个值拿到 process）
            String businessKey = processInstance.getBusinessKey();
            if (!org.springframework.util.StringUtils.hasText(businessKey)) {
                continue;
            }

            // 根据 流程示例 key 拿到 process
            Process process = baseMapper.selectById(businessKey);

            ProcessVo processVo = new ProcessVo();
            BeanUtils.copyProperties(process, processVo);
            processVoList.add(processVo);
        }

        // 4 封装返回对象
        IPage<ProcessVo> page = new Page<>(pageParam.getCurrent(), pageParam.getSize(), query.count());
        page.setRecords(processVoList);
        return page;
    }

    /**
     * 查询代办任务
     *
     */
    @Override
    public HashMap<String, Object> show(Long id) {
        // 根据流程 id 获得 process
        Process process = baseMapper.selectById(id);

        // 根据流程 id 获得流程记录消息
        LambdaQueryWrapper<ProcessRecord> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(ProcessRecord::getProcessId, id);
        List<ProcessRecord> processRecordList = processRecordService.list(lambdaQueryWrapper);

        // 根据模板 id 查询模板信息
        ProcessTemplate processTemplate = processTemplateService.getById(process.getProcessTemplateId());

        // 判断当前用户能否审批 有权限看到的不一定能审批
        boolean isApprove = false;
        List<Task> currentTaskList = this.getCurrentTaskList(String.valueOf(id));
        for (Task task : currentTaskList) {
            // 审批人是否是当前人
            if (task.getAssignee().equals(LoginUserInfoHelper.getUsername())) {
                isApprove = true;
            }
        }

        // 返回数据
        HashMap<String, Object> map = new HashMap<>();
        map.put("process", process);
        map.put("processRecordList", processRecordList);
        map.put("processTemplate", processTemplate);
        map.put("isApprove", isApprove);
        return map;
    }

    /**
     * 审批
     *
     * @param approvalVo:
     */
    @Override
    public void approve(ApprovalVo approvalVo) {
        // 1 从approvalVo取任务id，根据任务id获取流程变量
        String taskId = approvalVo.getTaskId();
        Map<String, Object> variables = taskService.getVariables(taskId);
        for (Map.Entry<String, Object> entry : variables.entrySet()) {
            log.info(entry.getKey() + " = " + entry.getValue());
        }

        // 2 判断审批状态值
        if (approvalVo.getStatus() == 1) {
            // 2.1 状态值 = 1 审批通过
            taskService.complete(taskId);
        } else {
            // 2.2 状态值 = -1 驳回，流程直按结束
            this.endTask(taskId);
        }

        // 3 记录审批和相关过程信息 oa_process_record
        String description = approvalVo.getStatus() == 1 ? "已通过" : "驳回";
        processRecordService.record(approvalVo.getProcessId(), approvalVo.getStatus(), description);

        // 4 查询下一个中批人，更新流程衣记 process衣记
        Process process = baseMapper.selectById(approvalVo.getProcessId());
        List<Task> currentTaskList = this.getCurrentTaskList(process.getProcessInstanceId());
        if (!CollectionUtils.isEmpty(currentTaskList)) {
            // 有后续的审批人
            ArrayList<String> list = new ArrayList<>();
            for (Task task : currentTaskList) {
                String assignee = task.getAssignee();
                SysUser user = sysUserService.getUserByUsername(assignee);
                list.add(user.getName());

                messageService.pushPendingMessage(process.getId(), user.getId(), task.getId());
            }
            process.setDescription("等待 " + StringUtils.join(list, "，") + " 审批...");
            process.setStatus(1);
        } else {
            // 没有有后续的审批人
            if (approvalVo.getStatus() == 1) {
                process.setDescription("审批完成（通过）");
                process.setStatus(2);
            } else {
                process.setDescription("审批完成（驳回）");
                process.setStatus(-1);
            }
        }
        baseMapper.updateById(process);
    }

    /**
     * 已处理
     * @param pageParam
     * @return
     */
    @Override
    public IPage<ProcessVo> findProcessed(Page<Process> pageParam) {
        HistoricTaskInstanceQuery query = historyService.createHistoricTaskInstanceQuery()
                .taskAssignee(LoginUserInfoHelper.getUsername())
                .finished().orderByTaskCreateTime().desc();
        int begin = (int) ((pageParam.getCurrent() - 1) * pageParam.getSize());
        int end = (int) (pageParam.getSize());
        List<HistoricTaskInstance> list = query.listPage(begin, end);

        // 封装 list<ProcessVo>
        ArrayList<ProcessVo> processVoList = new ArrayList<>();
        for (HistoricTaskInstance item : list) {
            // 获取流程实例id
            String processInstanceId = item.getProcessInstanceId();
            // 根据流程实例 id 查询 process
            LambdaQueryWrapper<Process> lambdaQueryWrapper = new LambdaQueryWrapper<>();
            lambdaQueryWrapper.eq(Process::getProcessInstanceId, processInstanceId);
            Process process = baseMapper.selectOne(lambdaQueryWrapper);

            ProcessVo processVo = new ProcessVo();
            BeanUtils.copyProperties(process, processVo);
            processVoList.add(processVo);
        }

        // 封装返回对象
        Page<ProcessVo> page = new Page<>(pageParam.getCurrent(), pageParam.getSize(), processVoList.size());
        page.setRecords(processVoList);
        return page;
    }

    /**
     * 查询已发起
     * @param pageParam
     * @return
     */
    @Override
    public IPage<ProcessVo> findStarted(Page<ProcessVo> pageParam) {
        ProcessQueryVo processQueryVo = new ProcessQueryVo();
        processQueryVo.setUserId(LoginUserInfoHelper.getUserId());
        return baseMapper.selectPage(pageParam, processQueryVo);
    }

    // 结束流程（被驳回了）
    private void endTask(String taskId) {
        // 1 根任务id获取任务对象 Task
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();

        // 2 获取流程足义型 BpmnModel (用流程定义id取)
        BpmnModel bpmnModel = repositoryService.getBpmnModel(task.getProcessDefinitionId());

        // 3 获取结束流向节点
        List<EndEvent> endEventList = bpmnModel.getMainProcess().findFlowElementsOfType(EndEvent.class);
        if (CollectionUtils.isEmpty(endEventList)) {
            return;
        }
        FlowNode endFlowNode = (FlowNode) endEventList.get(0);

        // 4 当前流问节点
        FlowNode currentFlowNode = (FlowNode) bpmnModel.getMainProcess().getFlowElement(task.getTaskDefinitionKey());

        // 5 清理当前流动方向
        currentFlowNode.getOutgoingFlows().clear();

        // 6 创建新流向
        SequenceFlow sequenceFlow = new SequenceFlow();
        sequenceFlow.setId("sequenceFlow");
        sequenceFlow.setSourceFlowElement(currentFlowNode);
        sequenceFlow.setTargetFlowElement(endFlowNode);

        // 7 当前节点指向新方向
        ArrayList<SequenceFlow> newSequenceFlow = new ArrayList<>();
        newSequenceFlow.add(sequenceFlow);
        currentFlowNode.setOutgoingFlows(newSequenceFlow);

        // 8 完成当前任务
        taskService.complete(taskId);
    }

    // 根据流程id获取当前审批人
    private List<Task> getCurrentTaskList(String id) {
        return taskService.createTaskQuery().processInstanceId(id).list();
    }
}
