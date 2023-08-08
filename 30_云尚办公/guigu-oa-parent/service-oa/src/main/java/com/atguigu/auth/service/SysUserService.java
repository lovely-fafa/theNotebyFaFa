package com.atguigu.auth.service;

import com.atguigu.model.system.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.HashMap;
import java.util.List;

public interface SysUserService extends IService<SysUser> {
    SysUser getUserByUsername(String username);

    HashMap<String, Object> getCurrentUser();
}
