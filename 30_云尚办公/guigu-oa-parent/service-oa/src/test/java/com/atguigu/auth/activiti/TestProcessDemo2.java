package com.atguigu.auth.activiti;

import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

@SpringBootTest
@Slf4j
public class TestProcessDemo2 {
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private RuntimeService runtimeService;


    // 部署流程定义
    @Test
    public void deployProcess() {
        Deployment deploy = repositoryService.createDeployment()
                .addClasspathResource("process/jiaban.bpmn20.xml")
                .key("jiaban")
                .name("加班申请流程").deploy();
        log.info("id={} name={} key={}", deploy.getId(), deploy.getName(), deploy.getKey());
    }

    // 启动流程示例
    @Test
    public void startProcessInstance() {
        HashMap<String, Object> map = new HashMap<>();
        // 设置任务人
        map.put("assign1", "fafa");
        map.put("assign2", "afa");
        ProcessInstance instance = runtimeService.startProcessInstanceByKey("jiaban", map);
        log.info("instanceId={}", instance.getProcessInstanceId());
        log.info("id={}", instance.getId());
    }



}
