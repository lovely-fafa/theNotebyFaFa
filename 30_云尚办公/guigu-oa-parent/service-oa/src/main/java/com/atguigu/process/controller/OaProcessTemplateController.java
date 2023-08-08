package com.atguigu.process.controller;

import com.atguigu.common.result.Result;
import com.atguigu.model.process.ProcessTemplate;
import com.atguigu.process.service.impl.OaProcessTemplateServiceImpl;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.netty.util.internal.ResourcesUtil;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RequestMapping("/admin/process/processTemplate")
@RestController
@Slf4j
public class OaProcessTemplateController {
    @Autowired
    private OaProcessTemplateServiceImpl processTemplateService;

    @PreAuthorize("hasAnyAuthority('btn.processTemplate.list')")
    @ApiOperation(value = "分页查询")
    @GetMapping("/{page}/{limit}")
    public Result<IPage<ProcessTemplate>> page(@PathVariable Long page,
                                               @PathVariable Long limit) {
        log.info("分页查询 | page={} limit={}", page, limit);
        IPage<ProcessTemplate> iPage = processTemplateService.selectPageProcessTemplate(page, limit);
        return Result.success(iPage);
    }

    //@PreAuthorize("hasAuthority('btn.processTemplate.list')")
    @ApiOperation(value = "获取")
    @GetMapping("get/{id}")
    public Result<ProcessTemplate> get(@PathVariable Long id) {
        ProcessTemplate processTemplate = processTemplateService.getById(id);
        return Result.success(processTemplate);
    }

    //@PreAuthorize("hasAuthority('btn.processTemplate.templateSet')")
    @ApiOperation(value = "新增")
    @PostMapping("/save")
    public Result<String> save(@RequestBody ProcessTemplate processTemplate) {

        Pattern compile = Pattern.compile("process/(.*?)\\.zip");
        System.out.println(processTemplate.getProcessDefinitionPath());  // process/jiabantest.zip
        Matcher matcher = compile.matcher(processTemplate.getProcessDefinitionPath());
        if (matcher.find()) {
            processTemplate.setProcessDefinitionKey(matcher.group(1));
            processTemplateService.save(processTemplate);
            return Result.success();
        }
        return Result.error("正则表达式匹配失败");
    }

    //@PreAuthorize("hasAuthority('btn.processTemplate.templateSet')")
    @ApiOperation(value = "修改")
    @PutMapping("update")
    public Result<String> updateById(@RequestBody ProcessTemplate processTemplate) {
        processTemplateService.updateById(processTemplate);
        return Result.success();
    }

    //@PreAuthorize("hasAuthority('btn.processTemplate.remove')")
    @ApiOperation(value = "删除")
    @DeleteMapping("remove/{id}")
    public Result<String> remove(@PathVariable Long id) {
        processTemplateService.removeById(id);
        return Result.success();
    }

    @PreAuthorize("hasAnyAuthority('btn.processTemplate.templateSet')")
    @ApiOperation(value = "上传流程定义")
    @PostMapping("/uploadProcessDefinition")
    public Result<Object> uploadProcessDefinition(MultipartFile uploadFile) throws IOException {
        String uploadFilename = uploadFile.getOriginalFilename();
        // 获取 class 的绝对路径
        String path = new File(ResourceUtils.getURL("classpath:").getPath()).getAbsolutePath();
        // 上传文件夹
        File process = new File(path, "process");
        if (!process.exists()) {
            process.mkdirs();
        }

        // 写文件
        File zipFile = new File(URLDecoder.decode(process.getPath()) + File.separator + uploadFilename);
        uploadFile.transferTo(zipFile);
        System.out.println(zipFile.getAbsolutePath());

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("processDefinitionPath", "process/" + uploadFilename);
        hashMap.put("processDefinitionKey", uploadFilename.substring(0, uploadFilename.lastIndexOf(".")));

        return Result.success(hashMap);
    }

    /**
     * 部署流程定义 发布
     */
    @ApiOperation(value = "发布")
    @GetMapping("/publish/{id}")
    public Result<String> publish(@PathVariable Long id) {
        // 修改模板
        processTemplateService.publish(id);
        return Result.success();
    }

    public static void main(String[] args) {
        Pattern compile = Pattern.compile("process.(.*?).zip");
        System.out.println("process/jiabantest.zip");
        Matcher matcher = compile.matcher("process/jiabantest.zip");
        if (matcher.find()) {
            System.out.println(matcher.group(1));
        }
    }
}
