package com.atguigu.wechat.controller;

import com.atguigu.common.result.Result;
import com.atguigu.model.wechat.MenuVo;
import com.atguigu.wechat.service.Impl.MenuServiceImpl;
import com.atguigu.wechat.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;

@CrossOrigin
@Slf4j
@RestController
@RequestMapping("/admin/wechat/menu")
public class MenuController {

    @Resource
    private MenuServiceImpl menuService;

    @GetMapping("/findMenuInfo")
    public Result findMenuInfo() {
        ArrayList<MenuVo> list = menuService.findMenuInfo();
        return Result.success(list);
    }

    @GetMapping("/syncMenu")
    public Result createMenu() {
        menuService.syncMenu();
        return Result.success();
    }

    @DeleteMapping("/removeMenu")
    public Result removeMenu() {
        menuService.removeMenu();
        return Result.success();
    }



}
