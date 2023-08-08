package com.atguigu.auth.service.Impl;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
public class TestSysMenuServiceImpl {

    @Test
    public void testFindUserPermsByUserId() {
        SysMenuServiceImpl sysMenuService = new SysMenuServiceImpl();
        System.out.println(sysMenuService.findUserPermsByUserId(2L));

    }

    @Test
    public void testFindUserMenuListByUserId() {
        SysMenuServiceImpl sysMenuService = new SysMenuServiceImpl();
        System.out.println(sysMenuService.findUserMenuListByUserId(2L));
    }

    @Test
    public void test() {
        int a = 5;
        System.out.println("value is " + ((a < 5) ? 1.9 : 9));
    }
}
