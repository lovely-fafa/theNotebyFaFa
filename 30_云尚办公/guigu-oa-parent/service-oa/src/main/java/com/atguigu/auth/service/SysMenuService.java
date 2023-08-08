package com.atguigu.auth.service;

import com.atguigu.model.system.AssignMenuVo;
import com.atguigu.model.system.RouterVo;
import com.atguigu.model.system.SysMenu;
import com.atguitu.common.exception.MyException;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service()
public interface SysMenuService extends IService<SysMenu> {
    List<SysMenu> findNodes();

    void removeMenuById(Long id) throws MyException;

    List<SysMenu> findMenuByRoleId(Long roleId);

    void doAssign(AssignMenuVo assignMenuVo);

    List<RouterVo> findUserMenuListByUserId(Long userId);

    List<String> findUserPermsByUserId(Long userId);
}
