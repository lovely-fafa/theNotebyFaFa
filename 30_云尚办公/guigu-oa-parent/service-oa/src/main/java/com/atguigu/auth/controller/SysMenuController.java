package com.atguigu.auth.controller;

import com.atguigu.auth.service.Impl.SysMenuServiceImpl;
import com.atguigu.common.result.Result;
import com.atguigu.model.system.AssignMenuVo;
import com.atguigu.model.system.SysMenu;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Api(tags = "菜单")
@Slf4j
@RestController
@RequestMapping("/admin/system/sysMenu")
public class SysMenuController {

    @Autowired
    private SysMenuServiceImpl sysMenuService;

    @ApiOperation(value = "菜单列表")
    @GetMapping("/findNodes")
    public Result<List<SysMenu>> findNodes() {
        List<SysMenu> list = sysMenuService.findNodes();
        return Result.success(list);
    }

    @ApiOperation(value = "新增菜单")
    @PostMapping("/save")
    public Result<String> save(@RequestBody SysMenu sysMenu) {
        log.info("新增菜单 sysMenu={}", sysMenu);
        sysMenuService.save(sysMenu);
        return Result.success();
    }

    @ApiOperation(value = "修改菜单")
    @PutMapping("/update")
    public Result<String> update(@RequestBody SysMenu sysMenu) {
        log.info("修改菜单 sysMenu={}", sysMenu);
        sysMenuService.updateById(sysMenu);
        return Result.success();
    }

    @ApiOperation(value = "删除菜单")
    @DeleteMapping("/remove/{id}")
    public Result<String> remove(@PathVariable Long id) {
        sysMenuService.removeMenuById(id);
        return Result.success();
    }

    @ApiOperation(value = "查询菜单和角色分配的菜单")
    @GetMapping("/toAssign/{roleId}")
    public Result<List<SysMenu>> toAssign(@PathVariable Long roleId) {
        List<SysMenu> list = sysMenuService.findMenuByRoleId(roleId);
        return Result.success(list);
    }

    @ApiOperation(value = "为角色分配菜单")
    @PostMapping("/doAssign")
    public Result<String> doAssign(@RequestBody AssignMenuVo assignMenuVo) {
        sysMenuService.doAssign(assignMenuVo);
        return Result.success();
    }
}
