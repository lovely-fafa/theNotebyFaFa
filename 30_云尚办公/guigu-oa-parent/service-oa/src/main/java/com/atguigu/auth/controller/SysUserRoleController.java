package com.atguigu.auth.controller;

import com.atguigu.auth.service.Impl.SysUserRoleServiceImpl;
import com.atguigu.common.result.Result;
import com.atguigu.model.system.AssignRoleVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

//@Api(tags = "角色用户管理")
@Slf4j
@RestController
@RequestMapping("/admin/system/sysRole")
public class SysUserRoleController {

    @Autowired
    private SysUserRoleServiceImpl sysUserRoleService;

    @ApiOperation("获取角色")
    @GetMapping("/toAssign/{id}")
    public Result<Map<String, Object>> toAssign(@PathVariable Long id) {
        log.info("获取用户角色信息 id={}", id);
        Map<String, Object> map = sysUserRoleService.findRoleDataByUserId(id);
        return Result.success(map);
    }

    @ApiOperation("为用户分配角色")
    @PostMapping("/doAssign")
    public Result<String> doAssign(@RequestBody AssignRoleVo assignRoleVo) {
        log.info("为用户分配角色 assignRoleVo={}", assignRoleVo);
        sysUserRoleService.doAssign(assignRoleVo);
        return Result.success();
    }
}
