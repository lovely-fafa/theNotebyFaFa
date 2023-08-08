package com.atguigu.auth.service.Impl;

import com.atguigu.auth.mapper.SysMenuMapper;
import com.atguigu.auth.service.SysMenuService;
import com.atguigu.auth.service.utils.MenuHelper;
import com.atguigu.model.system.*;
import com.atguitu.common.exception.MyException;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Resource
    private SysRoleMenuServiceImpl sysRoleMenuService;

    // 菜单列表获取
    @Override
    public List<SysMenu> findNodes() {
        List<SysMenu> sysMenuList = baseMapper.selectList(null);
        return MenuHelper.buildTree(sysMenuList);
    }

    @Override
    public void removeMenuById(Long id) {
        LambdaQueryWrapper<SysMenu> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SysMenu::getParentId, id);
        if (this.count(lambdaQueryWrapper) > 0) {
            throw new MyException(201, "有子菜单，不能删除");
        }
        baseMapper.deleteById(id);
    }

    /**
     * 查询菜单和角色分配的菜单
     *
     * @param roleId
     * @return
     */
    @Override
    public List<SysMenu> findMenuByRoleId(Long roleId) {
        LambdaQueryWrapper<SysMenu> sysMenuWrapper = new LambdaQueryWrapper<>();
        sysMenuWrapper.eq(SysMenu::getStatus, 1);
        List<SysMenu> sysMenuList = baseMapper.selectList(sysMenuWrapper);

        LambdaQueryWrapper<SysRoleMenu> sysRoleMenuWrapper = new LambdaQueryWrapper<>();
        sysRoleMenuWrapper.eq(SysRoleMenu::getRoleId, roleId);
        List<SysRoleMenu> sysRoleMenuList = sysRoleMenuService.list(sysRoleMenuWrapper);

        List<Long> menuId = sysRoleMenuList
                .stream().map(SysRoleMenu::getMenuId).collect(Collectors.toList());

        sysMenuList.forEach(item -> {
            if (menuId.contains(item.getId())) {
                item.setSelect(true);
            }
        });

        return MenuHelper.buildTree(sysMenuList);
    }

    /**
     * 为角色分配菜单
     *
     * @param assignMenuVo
     */
    @Override
    @Transactional
    public void doAssign(AssignMenuVo assignMenuVo) {
        LambdaQueryWrapper<SysRoleMenu> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SysRoleMenu::getRoleId, assignMenuVo.getRoleId());
        sysRoleMenuService.remove(lambdaQueryWrapper);

        List<SysRoleMenu> collect = assignMenuVo.getMenuIdList()
                .stream()
                .map(item -> new SysRoleMenu(assignMenuVo.getRoleId(), item))
                .collect(Collectors.toList());

        sysRoleMenuService.saveBatch(collect);
    }

    @Override
    public List<RouterVo> findUserMenuListByUserId(Long userId) {
        List<SysMenu> sysMenuList = null;
        // 1 判断当前用户是否是管理员userId=1是管理员
        if (userId == 1) {
            // 1.1 如果是管理员，查询所有菜单列表
            LambdaQueryWrapper<SysMenu> lambdaQueryWrapper = new LambdaQueryWrapper<>();
            lambdaQueryWrapper.eq(SysMenu::getStatus, 1);
            lambdaQueryWrapper.ne(SysMenu::getPath, "");
            lambdaQueryWrapper.isNotNull(SysMenu::getPath);
            lambdaQueryWrapper.orderByAsc(SysMenu::getSortValue);
            // todo: fafa 加的直接查有值的 所以还要写 sql
            sysMenuList = baseMapper.selectList(lambdaQueryWrapper);
        } else {
            // 1.2 如果不是管理员，根userId查询可以操作菜单列表
            // 多表关联查询:用户角色关系表 、 角色菜单关系表、菜单号
            sysMenuList = baseMapper.findUserMenuListById(userId);
        }

        // 2 把查询山来数据列表- 构建成框架要求的路由数据结构
        List<SysMenu> sysMenuTreeList = MenuHelper.buildTree(sysMenuList);
        return this.builderRouter(sysMenuTreeList);
    }

    @Override
    public List<String> findUserPermsByUserId(Long userId) {
        List<SysMenu> sysMenuList = null;
        // 1 判断是否是管理员，如果是管理员，查询所有按钮列表
        if (userId == 1) {
            LambdaQueryWrapper<SysMenu> lambdaQueryWrapper = new LambdaQueryWrapper<>();
            lambdaQueryWrapper.eq(SysMenu::getStatus, 1);
            sysMenuList = this.list(lambdaQueryWrapper);
        } else {
            // 2 如果不是管理员，根据userid查询可以操作按钮列表
            // 多表关联查询:用户角色关系表 、 角色单关系表、 单表
            sysMenuList = baseMapper.findUserMenuListById(userId);
        }
        // 3 从查询出来的数据里面，获取可以操作按值的Lst集合，返回
        return sysMenuList.stream().filter(item -> item.getType() == 2)
                .map(SysMenu::getPerms)
                .collect(Collectors.toList());
    }

    private List<RouterVo> builderRouter(List<SysMenu> menus) {
        List<RouterVo> routers = new ArrayList<>();

        for (SysMenu menu : menus) {
            RouterVo router = new RouterVo();
            router.setHidden(false);
            router.setAlwaysShow(false);
            router.setPath(getRouterPath(menu));
            router.setComponent(menu.getComponent());
            router.setMeta(new MetaVo(menu.getName(), menu.getIcon()));

            // 下一层的数据
            List<SysMenu> children = menu.getChildren();
            if (menu.getType() == 1L) {
                // 加载下面的隐藏路由
                List<SysMenu> hiddenMenuList = children.stream()
                        .filter(item -> StringUtils.hasText(item.getComponent()))
                        .collect(Collectors.toList());
                for (SysMenu hiddenMenu : hiddenMenuList) {
                    RouterVo hiddenRouter = new RouterVo();
                    hiddenRouter.setHidden(true);
                    hiddenRouter.setAlwaysShow(false);
                    hiddenRouter.setPath(getRouterPath(hiddenMenu));
                    hiddenRouter.setComponent(hiddenMenu.getComponent());
                    hiddenRouter.setMeta(new MetaVo(hiddenMenu.getName(), hiddenMenu.getIcon()));
                    // 因为隐藏路由是没有级别的，所以就直接放到一级去了
                    routers.add(hiddenRouter);
                }
            } else {
                if (!CollectionUtils.isEmpty(children)) {
                    if (children.size() > 0) {
                        router.setAlwaysShow(true);
                    }
                    // 递归
                    router.setChildren(builderRouter(children));
                }
            }
            routers.add(router);
        }
        return routers;
    }

    private String getRouterPath(SysMenu menu) {
        String path = "/" + menu.getPath();
        if (menu.getParentId() != 0) {
            path = menu.getPath();
        }
        return path;
    }
}
