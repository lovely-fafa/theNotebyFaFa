package com.atguigu.auth.controller;

import com.atguigu.auth.service.Impl.SysMenuServiceImpl;
import com.atguigu.auth.service.Impl.SysUserServiceImpl;
import com.atguigu.common.jwt.JwtHelper;
import com.atguigu.common.result.Result;
import com.atguigu.model.system.RouterVo;
import com.atguigu.model.system.SysUser;
import com.atguitu.common.exception.MyException;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Api(tags = "后台登录管理")
@Slf4j
@RestController
@RequestMapping("/user")
public class IndexController {

    @Autowired
    private SysUserServiceImpl sysUserService;
    @Autowired
    private SysMenuServiceImpl sysMenuService;

    @PostMapping("/login")
    @ApiOperation(value = "登录")
    public Result<HashMap<String, Object>> login(@RequestBody SysUser sysUser) {
        log.info("用户登录 sysUser={}", sysUser);
        LambdaQueryWrapper<SysUser> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SysUser:: getUsername, sysUser.getUsername());
        SysUser dbUser = sysUserService.getOne(lambdaQueryWrapper);

        if (dbUser == null) {
            log.info("用户登录 账号不存在 sysUser={}", sysUser);
            throw new MyException(201, "账号不存在");
        }

        if (!Objects.equals(dbUser.getPassword(), sysUser.getPassword())) {
            log.info("用户登录 密码错误 sysUser={} dbUser={}", sysUser, dbUser);
            throw new MyException(201, "密码错误");
        }

        if (dbUser.getStatus() == 0) {
            log.info("用户登录 账号被封禁 sysUser={}", sysUser);
            throw new MyException(201, "账号被封禁");
        }

        HashMap<String, Object> map = new HashMap<>();
        map.put("token", JwtHelper.createToken(dbUser.getId(), dbUser.getUsername()));
        return Result.success(map);
    }

    @GetMapping("/info")
    @ApiOperation("获取信息")
    public Result<HashMap<String, Object>> info(HttpServletRequest request) {
        // 1 从请求获取用户信息(获取请头token 字符串)
        String token = request.getHeader("token");
        log.info("获取用户信息 token={} request={}", token, request);

        // 2 从token字符串获取用户id 或者 用户名称
        Long userId = JwtHelper.getUserId(token);

        // 3 根据用户id查询数据库，把用户信息获取出来
        SysUser dbUser = sysUserService.getById(userId);

        // 4 根据用户id获取用户可以操作菜单列表
        List<RouterVo> routers = sysMenuService.findUserMenuListByUserId(userId);
        List<String> buttons = sysMenuService.findUserPermsByUserId(userId);

        HashMap<String, Object> map = new HashMap<>();
        map.put("roles", "[admin]");
        map.put("name", dbUser.getName());
        map.put("avatar", dbUser.getHeadUrl());
        map.put("routers", routers);
        map.put("buttons", buttons);
        return Result.success(map);
    }

    @PostMapping("/logout")
    @ApiOperation(value = "登出")
    public Result<String> logout() {
        log.info("用户登出");
        return Result.success();
    }
}
