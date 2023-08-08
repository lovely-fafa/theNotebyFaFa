package com.atguigu.auth.controller.api;

import com.atguigu.common.result.Result;
import com.atguigu.model.process.ProcessFormVo;
import com.atguigu.model.process.ProcessTemplate;
import com.atguigu.model.process.ProcessType;
import com.atguigu.process.service.OaProcessService;
import com.atguigu.process.service.OaProcessTypeService;
import com.atguigu.process.service.impl.OaProcessServiceImpl;
import com.atguigu.process.service.impl.OaProcessTemplateServiceImpl;
import com.atguigu.process.service.impl.OaProcessTypeServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "审批流管理")
@RestController
@RequestMapping(value = "/admin/process")
@CrossOrigin
public class ProcessController {

    @Autowired
    private OaProcessTemplateServiceImpl processTemplateService;
    @Autowired
    private OaProcessTypeServiceImpl processTypeService;
    @Autowired
    private OaProcessServiceImpl processService;

    // 查询所有的审批分类和模板
    @GetMapping("/findProcessType")
    public Result<List<ProcessType>> findProcessType() {
        List<ProcessType> process = processTypeService.findProcessType();
        return Result.success(process);
    }

    @GetMapping("/getProcessTemplate/{processTemplateId}")
    public Result<ProcessTemplate> getProcessTemplate(@PathVariable Long processTemplateId) {
        ProcessTemplate ProcessTemplate = processTemplateService.getById(processTemplateId);
        return Result.success(ProcessTemplate);
    }

    // 启动流程
    @PostMapping("/startUp")
    public Result startUp(@RequestBody ProcessFormVo processFormVo) {
        processService.startUp(processFormVo);
        return Result.success();
    }
}
