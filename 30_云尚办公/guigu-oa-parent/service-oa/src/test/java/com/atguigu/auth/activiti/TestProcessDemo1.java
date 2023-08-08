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
public class TestProcessDemo1 {

    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private RuntimeService runtimeService;

    //////////////////////////////////////////////////
    // UEL-value

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

    ////////////////////////////////////////////
    // uel- method
    @Test
    public void deployProcess01() {
        Deployment deploy = repositoryService.createDeployment()
                .addClasspathResource("process/jiaban2.bpmn20.xml")
                .key("jiaban01")
                .name("加班申请流程01").deploy();
        log.info("id={} name={} key={}", deploy.getId(), deploy.getName(), deploy.getKey());
    }

    @Test
    public void startProcessInstance01() {
        ProcessInstance instance = runtimeService.startProcessInstanceByKey("jiaban01");
        log.info("instanceId={}", instance.getProcessInstanceId());
        log.info("id={}", instance.getId());
    }

    //////////////////////////////////////////////////
    // 监听器
    @Test
    public void deployProcess02() {
        Deployment deploy = repositoryService.createDeployment()
                .addClasspathResource("process/jiaban02.bpmn20.xml")
                .name("加班申请02").deploy();
        log.info("id={} name={} key={}", deploy.getId(), deploy.getName(), deploy.getKey());
    }

    @Test
    public void startProcessInstance02() {
        ProcessInstance instance = runtimeService.startProcessInstanceByKey("jiaban02");
        log.info("instanceId={}", instance.getProcessInstanceId());
        log.info("id={}", instance.getId());
    }


}
