package com.atguigu.process.controller;

import com.atguigu.auth.service.Impl.SysUserServiceImpl;
import com.atguigu.auth.service.SysUserService;
import com.atguigu.common.result.Result;
import com.atguigu.model.process.ApprovalVo;
import com.atguigu.model.process.Process;
import com.atguigu.model.system.ProcessQueryVo;
import com.atguigu.model.system.ProcessVo;
import com.atguigu.process.service.impl.OaProcessServiceImpl;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;


@CrossOrigin
@Slf4j
@RestController
@RequestMapping("/admin/process")
public class OaProcessController {

    @Resource
    private OaProcessServiceImpl processService;
    @Resource
    private SysUserServiceImpl sysUserService;


    @ApiOperation(value = "分页查询")
    @GetMapping("/{page}/{limit}")
    public Result<IPage<ProcessVo>> page(@PathVariable Long page,
                       @PathVariable Long limit,
                       ProcessQueryVo processQueryVo) {
        log.info("分页查询 | page={} limit={}", page, limit);
        Page<ProcessVo> pageParam = new Page<>(page, limit);
        IPage<ProcessVo> selectPage = processService.selectPage(pageParam, processQueryVo);
        return Result.success(selectPage);
    }

    /**
     * 分页查询待处理
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/findPending/{page}/{limit}")
    public Result findPending(@PathVariable Long page,
                              @PathVariable Long limit) {
        IPage<Process> pageParam = new Page<>(page, limit);
        IPage<ProcessVo> pageModel = processService.findPending(pageParam);
        return Result.success(pageModel);
    }

    /**
     * 查看审批详情信息
     */
    @GetMapping("/show/{id}")
    public Result show(@PathVariable Long id) {
        HashMap<String, Object> map = processService.show(id);
        return Result.success(map);
    }

    /**
     * 审批接口
     */
    @PostMapping("/approve")
    public Result approve(@RequestBody ApprovalVo approvalVo) {
        processService.approve(approvalVo);
        return Result.success();
    }

    /**
     * 已处理
     */
    @GetMapping("/findProcessed/{page}/{limit}")
    public Result findProcessed(@PathVariable Long page,
                                @PathVariable Long limit) {
        Page<Process> pageParam = new Page<>(page, limit);
        IPage<ProcessVo> pageModel = processService.findProcessed(pageParam);
        return Result.success(pageModel);
    }

    /**
     * 已发起
     */
    @GetMapping("/findStarted/{page}/{limit}")
    public Result findStarted(@PathVariable Long page,
                              @PathVariable Long limit) {
        Page<ProcessVo> pageParam = new Page<>(page, limit);
        IPage<ProcessVo> pageModel = processService.findStarted(pageParam);
        return Result.success(pageModel);
    }

    /**
     * 获取用户信息
     */
    @GetMapping("/getCurrentUser")
    public Result getCurrentUser() {
        HashMap<String, Object> user = sysUserService.getCurrentUser();
        return Result.success(user);
    }

}
