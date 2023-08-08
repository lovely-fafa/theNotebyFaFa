package com.atguigu.auth.activiti;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestProcess {

    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;
    @Autowired
    public HistoryService historyService;

    // 单个文件的部署
    @Test
    public void testDeployProcess() {
        Deployment deploy = repositoryService.createDeployment()
                .addClasspathResource("process/process.bpmn20.xml")
                .addClasspathResource("process/myfilename-20230712200313524.png")
                .name("请假申请流程")
                .deploy();
        System.out.println(deploy.getName());
        System.out.println(deploy.getId());
    }

    // 流程示例
    @Test
    public void testStartProcess() {
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("qingjia");
        System.out.println("流程的定义的 id 为：" + processInstance.getProcessDefinitionId());
        System.out.println("流程的示例 id 为：" + processInstance.getId());
        System.out.println("流程的活动 id 为：" + processInstance.getActivityId());
    }

    // 查询个人的待办任务
    @Test
    public void testTaskList() {
        String assign = "jack";
        List<Task> tasks = taskService.createTaskQuery().taskAssignee(assign).list();
        for (Task task : tasks) {
            System.out.println("流程示例 id " + task.getProcessInstanceId());
            System.out.println("任务 id " + task.getId());
            System.out.println("任务负责人 " + task.getAssignee());
            System.out.println("任务名称 " + task.getName());
        }
    }

    // 处理当前任务
    @Test
    public void completeTask() {
        String assign = "张三";
        Task task = taskService.createTaskQuery().taskAssignee(assign).singleResult();
        // 完成
        taskService.complete(task.getId());
    }

    @Test
    public void finishedTaskList() {
        List<HistoricTaskInstance> tasks = historyService
                .createHistoricTaskInstanceQuery()
                .taskAssignee("zhangsan")
                .finished()
                .list();
        for (HistoricTaskInstance historicTaskInstance : tasks) {
            System.out.println("流程实例id：" + historicTaskInstance.getProcessInstanceId());
            System.out.println("任务id：" + historicTaskInstance.getId());
            System.out.println("任务负责人：" + historicTaskInstance.getAssignee());
            System.out.println("任务名称：" + historicTaskInstance.getName());
        }
    }

    // 创建流程实例 指定 BusinessKey
    @Test
    public void startUpProcessAddBusinessKey() {
        ProcessInstance instance = runtimeService.startProcessInstanceByKey("qingjia", "1001");
        System.out.println(instance.getBusinessKey());
    }

    // 全部流程示例挂起
    @Test
    public void suspendProcessInstanceAll() {
        // 获取流程定义的对象
        ProcessDefinition qingjia = repositoryService.createProcessDefinitionQuery()
                .processDefinitionKey("qingjia")
                .singleResult();

        // 判断当前状态
        boolean suspended = qingjia.isSuspended();

        if (suspended) {
            // 当前挂起状态 使其激活
            // 参数一：id
            // 参数二：将其激活
            // 参数三：时间点 此时填 null
            repositoryService.activateProcessDefinitionById(qingjia.getId(), true, null);
            System.out.println(qingjia.getId() + " 激活了");
        } else {
            // 当前激活状态 使其挂起
            repositoryService.suspendProcessDefinitionById(qingjia.getId(), true, null);
            System.out.println(qingjia.getId() + " 挂起了");
        }
    }

    // 单个流程示例的挂起
    @Test
    public void SingleSuspendProcessInstance() {
        ProcessInstance instance = runtimeService.createProcessInstanceQuery()
                .processInstanceId("xx")
                .singleResult();
        boolean suspended = instance.isSuspended();

        if (suspended) {
            runtimeService.activateProcessInstanceById(instance.getId());
        } else {
            runtimeService.suspendProcessInstanceById(instance.getId());
        }
    }
}
