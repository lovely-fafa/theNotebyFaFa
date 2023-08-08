package com.atguigu.auth.activiti;

import org.springframework.stereotype.Component;

@Component
public class UserBean {

    public String getUsername(int id) {
        if (id == 1) {
            return "lihua";
        } else if (id == 2) {
            return "zhangmeili";
        } else {
            return "admin";
        }
    }
}
