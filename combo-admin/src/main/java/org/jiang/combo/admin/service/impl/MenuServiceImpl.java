package org.jiang.combo.admin.service.impl;

import org.jiang.combo.admin.model.Menu;
import org.jiang.combo.admin.mapper.MenuMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.jiang.combo.admin.service.MenuService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 系统菜单 服务实现类
 * </p>
 *
 * @author combo
 * @since 2022-01-21
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Override
    public List<Menu> getTree(Integer pId) {
        List<Menu> tree = baseMapper.getTree(pId);
        return tree;
    }

    @Override
    public List<Menu> getTreeEnabled(Integer pId) {
        return null;
    }

    @Override
    public List<Menu> getListByRoleIds(List<Integer> ids) {
        baseMapper.selectListByRoleIds(ids);
        return null;
    }

    @Override
    public List<String> getAuthoritiesByRoles(List<Integer> ids) {
        List<String> authorities = baseMapper.getAuthoritiesByRoleIds(ids);
        return authorities;
    }


    @Override
    public boolean saveMenuForRole(Integer id, List<Integer> ids) {
        int count = baseMapper.deleteRoleMenuByRoleId(id);
        int i = baseMapper.insertRoleMenu(id, ids);

        List<Integer> rIds = new ArrayList<>();
        rIds.add(1);
        rIds.add(2);
//        List<Menu> menus = baseMapper.selectListByRoleIds(rIds);

//        System.out.println(authorities);
        return false;
    }
}
