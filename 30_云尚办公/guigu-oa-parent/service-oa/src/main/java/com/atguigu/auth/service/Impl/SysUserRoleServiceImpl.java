package com.atguigu.auth.service.Impl;

import com.atguigu.auth.mapper.SysUserRoleMapper;
import com.atguigu.auth.service.SysUserRoleService;
import com.atguigu.model.system.AssignRoleVo;
import com.atguigu.model.system.SysRole;
import com.atguigu.model.system.SysUserRole;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {

    @Autowired
    private SysRoleServiceImpl sysRoleService;

    @Override
    public Map<String, Object> findRoleDataByUserId(Long id) {

        // 1 查询所有角色，返回List集合，返回
        List<SysRole> allRoleList = sysRoleService.list();

        // 2 根据userid查询 角色用户关系表，询userid对应所有角色id
        LambdaQueryWrapper<SysUserRole> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SysUserRole::getUserId, id);
        List<SysUserRole> sysUserRoles = baseMapper.selectList(lambdaQueryWrapper);

        List<Long> collect = sysUserRoles.stream().map(SysUserRole::getRoleId).collect(Collectors.toList());

        // 3 根据查询所有角色id，找到对应角色信息
        // 根据角色id到所有的角色的List集合进行比较
        ArrayList<SysRole> assignRoleList = new ArrayList<>();
        for (SysRole sysRole : allRoleList) {
            if (collect.contains(sysRole.getId())) {
                assignRoleList.add(sysRole);
            }
        }

        // 4 把得到两部分数据封装map 集合，返回
        HashMap<String, Object> map = new HashMap<>();
        map.put("assignRoleList", assignRoleList);
        map.put("allRoleList", allRoleList);

        return map;
    }

    /**
     * 为用户分配角色
     */
    @Override
    @Transactional
    public void doAssign(AssignRoleVo assignRoleVo) {
        // 删除旧的数据
        LambdaQueryWrapper<SysUserRole> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SysUserRole:: getUserId, assignRoleVo.getUserId());
        this.remove(lambdaQueryWrapper);

        // 添加数据
        HashSet<SysUserRole> hashSet = new HashSet<>();
        assignRoleVo
                .getRoleIdList()
                .forEach(item -> hashSet.add(new SysUserRole(item, assignRoleVo.getUserId())));
        this.saveBatch(hashSet);
    }
}
