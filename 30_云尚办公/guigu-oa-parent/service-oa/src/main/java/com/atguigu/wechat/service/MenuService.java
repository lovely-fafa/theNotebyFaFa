package com.atguigu.wechat.service;

import com.atguigu.model.wechat.Menu;
import com.atguigu.model.wechat.MenuVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.ArrayList;

public interface MenuService extends IService<Menu> {
    ArrayList<MenuVo> findMenuInfo();

    void syncMenu();

    void removeMenu();
}
