package com.atguigu.auth.controller;

import com.atguigu.auth.service.Impl.SysUserServiceImpl;
import com.atguigu.common.result.Result;
import com.atguigu.model.system.SysRole;
import com.atguigu.model.system.SysUser;
import com.atguigu.model.system.SysUserQueryVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Api(tags = "用户")
@Slf4j
@RestController
@RequestMapping("/admin/system/sysUser")
public class SysUserController {

    @Autowired
    private SysUserServiceImpl sysUserService;

    /**
     * 用户分页查询
     * @param pageNum
     * @param limit
     * @return
     */
    @GetMapping("/{pageNum}/{limit}")
    @ApiOperation("用户分页查询")
    public Result<IPage<SysUser>> selectPage(@PathVariable Long pageNum,
                                             @PathVariable Long limit,
                                             SysUserQueryVo sysUserQueryVo) {

        log.info("分页查询 pageNum={} limit={}", pageNum, limit);

        Page<SysUser> page = new Page<>(pageNum, limit);
        LambdaQueryWrapper<SysUser> lambdaQueryWrapper = new LambdaQueryWrapper<>();

        String keyword = sysUserQueryVo.getKeyword();
        String createTimeBegin = sysUserQueryVo.getCreateTimeBegin();
        String createTimeEnd = sysUserQueryVo.getCreateTimeEnd();

        lambdaQueryWrapper.like(StringUtils.hasText(keyword), SysUser:: getName, keyword)
                .ge(StringUtils.hasText(createTimeBegin), SysUser:: getCreateTime, createTimeBegin)
                .le(StringUtils.hasText(createTimeEnd), SysUser::getCreateTime, createTimeEnd);

        IPage<SysUser> ipage = sysUserService.page(page, lambdaQueryWrapper);
        return Result.success(ipage);
    }

    /**
     * 添加用户
     *
     * @param sysUser
     * @return
     */
    @ApiOperation("添加用户")
    @PostMapping("/save")
    public Result<String> save(@RequestBody SysUser sysUser) {
        log.info("添加用户 sysRole={} ...", sysUser);
        if (sysUserService.save(sysUser)) {
            log.info("添加用户成功 sysUser={}", sysUser);
            return Result.success();
        } else {
            log.info("添加用户失败 sysUser={}", sysUser);
            return Result.error();
        }
    }

    @ApiOperation("根据 id 查询")
    @GetMapping("/get/{id}")
    public Result<SysUser> select(@PathVariable Long id) {
        SysUser sysUser = sysUserService.getById(id);
        return Result.success(sysUser);
    }

    @ApiOperation("根据 id 更新")
    @PutMapping("/update")
    public Result<String> update(@RequestBody SysUser sysUser) {
        if (sysUserService.updateById(sysUser)) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @ApiOperation("删除")
    @DeleteMapping("/remove/{id}")
    public Result<String> removeById (@PathVariable Long id) {
        log.info("删除用户 id={} ...", id);
        if (sysUserService.removeById(id)) {
            log.info("删除用户成功 id={}", id);
            return Result.success();
        } else {
            log.warn("删除用户失败 id={}", id);
            return Result.error();
        }
    }

    @ApiOperation("批量删除")
    @DeleteMapping("/removes")
    public Result<String> removeByIds (@RequestBody List<Long> ids) {
        log.info("批量删除 ids={} ...", ids);
        if (sysUserService.removeByIds(ids)) {
            log.info("批量删除成功 ids={}", ids);
            return Result.success();
        } else {
            log.warn("批量删除失败 ids={}", ids);
            return Result.error();
        }
    }

    @ApiOperation("更改状态")
    @PutMapping("/status")
    public Result<String> changeStatus(@RequestBody SysUser sysUser) {
        log.info("更改状态 sysUser={}", sysUser);

        if (sysUser.getStatus() == 1) {
            sysUser.setStatus(0);
        } else {
            sysUser.setStatus(1);
        }

        sysUserService.updateById(sysUser);
        return Result.success();
    }
}
