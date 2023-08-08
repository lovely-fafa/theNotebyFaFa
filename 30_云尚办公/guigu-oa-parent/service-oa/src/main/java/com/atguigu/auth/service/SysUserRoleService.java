package com.atguigu.auth.service;

import com.atguigu.model.system.AssignRoleVo;
import com.atguigu.model.system.SysUserRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

public interface SysUserRoleService extends IService<SysUserRole> {
    Map<String, Object> findRoleDataByUserId(Long id);

    void doAssign(AssignRoleVo assignRoleVo);
}
