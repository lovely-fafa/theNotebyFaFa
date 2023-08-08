package com.atguigu.auth.service.Impl;

import com.atguigu.auth.service.SysMenuService;
import com.atguigu.auth.service.SysUserService;
import com.atguigu.security.custom.CustomUser;
import com.atguigu.security.custom.UserDetailsService;
import com.atguigu.model.system.SysUser;
import com.atguitu.common.exception.MyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysMenuService sysMenuService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("通过 username 加载用户信息 | username={}", username);
        SysUser sysUser = sysUserService.getUserByUsername(username);
        if (sysUser == null) {
            log.warn("用户名不存在 | username={}", username);
            throw new UsernameNotFoundException("用户名不存在");
        }

        if (sysUser.getStatus() == 0) {
            log.warn("账号已禁用 | username={}", username);
            throw new MyException(201, "账号已禁用");
        }

        List<String> permsByUserId = sysMenuService.findUserPermsByUserId(sysUser.getId());
        List<SimpleGrantedAuthority> authorityList = permsByUserId
                .stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        return new CustomUser(sysUser, authorityList);
    }
}
