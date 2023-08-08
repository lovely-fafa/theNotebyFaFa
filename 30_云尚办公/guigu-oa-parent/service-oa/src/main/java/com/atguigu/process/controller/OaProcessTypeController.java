package com.atguigu.process.controller;

import com.atguigu.common.result.Result;
import com.atguigu.model.process.ProcessType;
import com.atguigu.process.service.impl.OaProcessTypeServiceImpl;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/admin/process/processType")
@RestController
@Api(tags = "审批类型")
@Slf4j
public class OaProcessTypeController {

    @Autowired
    private OaProcessTypeServiceImpl processTypeService;

    @PreAuthorize("hasAnyAuthority('btn.processType.list')")
    @ApiOperation(value = "分页查询")
    @GetMapping("/{page}/{limit}")
    public Result<IPage<ProcessType>> index(@PathVariable Long page,
                        @PathVariable Long limit) {
        log.info("分页查询 | page={} limit={}", page, limit);
        Page<ProcessType> pageParam = new Page<>(page, limit);
        IPage<ProcessType> iPage = processTypeService.page(pageParam);
        return Result.success(iPage);
    }

    @PreAuthorize("hasAnyAuthority('btn.processType.list')")
    @ApiOperation(value = "获取")
    @GetMapping("/get/{id}")
    public Result<ProcessType> getById(@PathVariable Long id) {
        ProcessType processType = processTypeService.getById(id);
        return Result.success(processType);
    }

    @PreAuthorize("hasAnyAuthority('btn.processType.add')")
    @ApiOperation(value = "新增")
    @PostMapping("/save")
    public Result<String> save(@RequestBody ProcessType processType) {
        processTypeService.save(processType);
        return Result.success();
    }

    @PreAuthorize("hasAnyAuthority('btn.processType.update')")
    @ApiOperation(value = "修改")
    @PutMapping("/update")
    public Result<String> updateById(@RequestBody ProcessType processType) {
        processTypeService.updateById(processType);
        return Result.success();
    }

    @PreAuthorize("hasAnyAuthority('btn.processType.remove')")
    @ApiOperation(value = "删除")
    @DeleteMapping("/remove/{id}")
    public Result<String> removeById(@PathVariable Long id) {
        processTypeService.removeById(id);
        return Result.success();
    }

    @PreAuthorize("hasAnyAuthority('btn.processType.list')")
    @ApiOperation(value = "获取所有审批类别")
    @GetMapping("/findAll")
    public Result<List<ProcessType>> findAll() {
        log.info("获取所有审批类别");
        return Result.success(processTypeService.list());
    }
}
