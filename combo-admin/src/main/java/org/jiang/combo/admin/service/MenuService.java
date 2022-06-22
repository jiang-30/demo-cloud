package org.jiang.combo.admin.service;

import org.jiang.combo.admin.model.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 系统菜单 服务类
 * </p>
 *
 * @author combo
 * @since 2022-01-21
 */
public interface MenuService extends IService<Menu> {

    /**
     * 以树型查询全部权限(Admin使用添加等功能)
     * @param pId
     * @return
     */
    List<Menu> getTree(Integer pId);

    /**
     * 查询可用权限(数据权限)（用于为角色分配权限）
     */
    List<Menu> getTreeEnabled(Integer pId);

    /**
     * 通过角色查询菜单（角色权限关联表-并且权限可用状态）
     */
    List<Menu> getListByRoleIds(List<Integer> ids);

    /**
     * 通过角色查询权限（角色权限关联表-并且权限可用状态）
     * @return
     */
    List<String> getAuthoritiesByRoles(List<Integer> ids);

    /**
     * 为角色设置权限
     * 1. 删除当前角色的所有权限
     * 2. 设置新权限
     * 3. 通知
     */
    boolean saveMenuForRole(Integer id, List<Integer> ids);

}
