package com.atguigu.auth.service.utils;

import com.atguigu.model.system.SysMenu;

import java.util.ArrayList;
import java.util.List;

public class MenuHelper {

    public static List<SysMenu> buildTree (List<SysMenu> sysMenuList) {
        ArrayList<SysMenu> tree = new ArrayList<>();
        for (SysMenu sysMenu : sysMenuList) {
            if (sysMenu.getParentId() == 0) {
                tree.add(children(sysMenuList, sysMenu));
            }
        }
        return tree;
    }

    public static SysMenu children(List<SysMenu> sysMenuList,
                                   SysMenu sysMenu) {
        sysMenu.setChildren(new ArrayList<>());
        for (SysMenu item : sysMenuList) {
            if (item.getParentId().longValue() == sysMenu.getId().longValue()) {
                if (sysMenu.getChildren() == null) {
                    sysMenu.setChildren(new ArrayList<>());
                }
                sysMenu.getChildren().add(children(sysMenuList, item));
            }
        }
        return sysMenu;
    }
}
