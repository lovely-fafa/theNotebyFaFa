package com.atguigu.wechat.service.Impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.atguigu.model.wechat.Menu;
import com.atguigu.model.wechat.MenuVo;
import com.atguigu.wechat.mapper.MenuMapper;
import com.atguigu.wechat.service.MenuService;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Resource
    private WxMpService wxMpService;

    // 获取全部菜单
    @Override
    public ArrayList<MenuVo> findMenuInfo() {
        // 查所有的菜单的 list
        List<Menu> menus = baseMapper.selectList(null);

        // 筛出一级菜单的 list
        List<Menu> rootMenuList = menus.stream().filter(menu -> menu.getParentId() == 0).collect(Collectors.toList());

        // 遍历 一级菜单 把二级菜单放进一级菜单的 children中 得到 menuVo 的 list
        ArrayList<MenuVo> result = new ArrayList<>();
        for (Menu rootMenu: rootMenuList) {
            MenuVo menuVo = new MenuVo();
            BeanUtils.copyProperties(rootMenu, menuVo);

            List<MenuVo> sonMenuList = menus.stream()
                    .filter(item -> Objects.equals(item.getParentId(), rootMenu.getId()))
                    .map(item -> {
                        MenuVo sonMenuVo = new MenuVo();
                        BeanUtils.copyProperties(item, sonMenuVo);
                        return sonMenuVo;
                    }).collect(Collectors.toList());
            menuVo.setChildren(sonMenuList);
            result.add(menuVo);
        }
        return result;
    }

    @Override
    public void syncMenu() {
        List<MenuVo> menuVoList = this.findMenuInfo();
        //菜单
        JSONArray buttonList = new JSONArray();
        for(MenuVo oneMenuVo : menuVoList) {
            JSONObject one = new JSONObject();
            one.put("name", oneMenuVo.getName());
            if(CollectionUtils.isEmpty(oneMenuVo.getChildren())) {
                one.put("type", oneMenuVo.getType());
                one.put("url", "http://oa.atguigu.cn/#"+oneMenuVo.getUrl());
            } else {
                JSONArray subButton = new JSONArray();
                for(MenuVo twoMenuVo : oneMenuVo.getChildren()) {
                    JSONObject view = new JSONObject();
                    view.put("type", twoMenuVo.getType());
                    if(twoMenuVo.getType().equals("view")) {
                        view.put("name", twoMenuVo.getName());
                        //H5页面地址
                        view.put("url", "http://oa.atguigu.cn#"+twoMenuVo.getUrl());
                    } else {
                        view.put("name", twoMenuVo.getName());
                        view.put("key", twoMenuVo.getMeunKey());
                    }
                    subButton.add(view);
                }
                one.put("sub_button", subButton);
            }
            buttonList.add(one);
        }
        //菜单
        JSONObject button = new JSONObject();
        button.put("button", buttonList);
        try {
            wxMpService.getMenuService().menuCreate(button.toJSONString());
        } catch (WxErrorException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeMenu() {
        try {
            wxMpService.getMenuService().menuDelete();
        } catch (WxErrorException e) {
            throw new RuntimeException(e);
        }
    }
}
