package com.atguigu.auth.activiti;

import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;

@Slf4j
@SpringBootTest
public class TestProcessDemo3 {
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private TaskService taskService;

    // 部署流程定义
    @Test
    public void deployProcess() {
        Deployment deploy = repositoryService.createDeployment()
                .addClasspathResource("process/jiaban04.bpmn20.xml")
                .name("加班申请流程").deploy();
        log.info("id={} name={} key={}", deploy.getId(), deploy.getName(), deploy.getKey());
    }

    // 启动流程示例
    @Test
    public void startProcessInstance() {
        ProcessInstance instance = runtimeService.startProcessInstanceByKey("jiaban04");
        log.info("instanceId={}", instance.getProcessInstanceId());
        log.info("id={}", instance.getId());
    }

    // 查询组任务
    @Test
    public void findGroupTaskList() {
        List<Task> tasks = taskService.createTaskQuery()
                .taskCandidateUser("tom01")
                .list();
        for (Task task : tasks) {
            log.info("{}", task.getName());
        }
    }


    // 拾取
    @Test
    public void claimTask() {
        Task task = taskService.createTaskQuery()
                .taskCandidateUser("tom01")
                .singleResult();
        if (task != null) {
            taskService.claim(task.getId(), "tom01");
            log.info("任务拾取完成 | taskId={}", task.getId());
        }
    }

    // 查询个人的待办任务
    @Test
    public void testTaskList() {
        String assign = "tom01";
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
        String assign = "tom01";
        Task task = taskService.createTaskQuery().taskAssignee(assign).singleResult();
        // 完成
        taskService.complete(task.getId());
    }
}
