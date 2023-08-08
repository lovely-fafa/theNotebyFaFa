package com.atguigu.auth.controller;

import com.atguigu.auth.service.Impl.SysRoleServiceImpl;
import com.atguigu.common.result.Result;
import com.atguigu.model.system.SysRole;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Api(tags = "角色管理")
@RestController
@RequestMapping("/admin/system/sysRole")
public class SysRoleController {

    @Autowired
    private SysRoleServiceImpl sysRoleService;

    /**
     * 查询所有角色
     */
    @ApiOperation("查询所有角色")
    @GetMapping("/findAll")
    public Result<List<SysRole>> findAll() {
        log.info("查询所有...");
        List<SysRole> list = sysRoleService.list();
        return Result.success(list);
    }

    /**
     * 分页查询
     */
    @ApiOperation("条件分页查询")
    @GetMapping("{pageNum}/{limit}")
    @PreAuthorize("hasAnyAuthority('btn.sysRole.list')")
    public Result<IPage<SysRole>> pageQueryRole(@PathVariable Long pageNum,
                                                @PathVariable Long limit,
                                                SysRole sysRole) {

        log.info("分页查询 page={} limit={} sysRole={}", pageNum, limit, sysRole);

        Page<SysRole> page = new Page<>(pageNum, limit);
        LambdaQueryWrapper<SysRole> queryWrapper = new LambdaQueryWrapper<>();

        String roleName = sysRole.getRoleName();
        if (StringUtils.hasText(roleName)) {
            queryWrapper.like(SysRole::getRoleName, roleName);
        }

        IPage<SysRole> iPage = sysRoleService.page(page, queryWrapper);
        return Result.success(iPage);
    }

    /**
     * 添加角色
     * @param sysRole
     * @return
     */
    @ApiOperation("添加角色")
    @PostMapping("/save")
    @PreAuthorize("hasAnyAuthority('btn.sysRole.add')")
    public Result<String> save(@RequestBody SysRole sysRole) {
        log.info("添加角色 sysRole={} ...", sysRole);
        if (sysRoleService.save(sysRole)) {
            log.info("添加角色成功 sysRole={}", sysRole);
            return Result.success();
        } else {
            log.info("添加角色失败 sysRole={}", sysRole);
            return Result.error();
        }
    }

    @ApiOperation("根据 id 查询")
    @GetMapping("/get/{id}")
    @PreAuthorize("hasAnyAuthority('btn.sysRole.list')")
    public Result<SysRole> select(@PathVariable Long id) {
        SysRole sysRole = sysRoleService.getById(id);
        return Result.success(sysRole);
    }

    @ApiOperation("根据 id 更新")
    @PutMapping("/update")
    @PreAuthorize("hasAnyAuthority('btn.sysRole.update')")
    public Result<String> update(@RequestBody SysRole sysRole) {
        if (sysRoleService.updateById(sysRole)) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @ApiOperation("删除")
    @DeleteMapping("/remove/{id}")
    @PreAuthorize("hasAnyAuthority('btn.sysRole.remove')")
    public Result<String> removeById (@PathVariable Long id) {
        log.info("删除用户 id={} ...", id);
        if (sysRoleService.removeById(id)) {
            log.info("删除用户成功 id={}", id);
            return Result.success();
        } else {
            log.warn("删除用户失败 id={}", id);
            return Result.error();
        }
    }

    @ApiOperation("批量删除")
    @DeleteMapping("/removes")
    @PreAuthorize("hasAnyAuthority('btn.sysRole.removes')")
    public Result<String> removeByIds (@RequestBody List<Long> ids) {
        log.info("批量删除 ids={} ...", ids);
        if (sysRoleService.removeByIds(ids)) {
            log.info("批量删除成功 ids={}", ids);
            return Result.success();
        } else {
            log.warn("批量删除失败 ids={}", ids);
            return Result.error();
        }
    }
}
