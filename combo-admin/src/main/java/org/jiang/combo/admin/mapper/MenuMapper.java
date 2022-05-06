package org.jiang.combo.admin.mapper;

import org.apache.ibatis.annotations.Param;
import org.jiang.combo.admin.model.entiry.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 系统菜单 Mapper 接口
 * </p>
 *
 * @author combo
 * @since 2022-01-21
 */
public interface MenuMapper extends BaseMapper<Menu> {
    List<Menu> getTree(@Param("pId") Integer pId);

    /**
     * 通过角色id查询权限列表
     */
    List<String> getAuthoritiesByRoleIds(@Param("rIds") List<Integer> rIds);

    /**
     * 通过角色ids 查询菜单
     */
    List<Menu> selectListByRoleIds(@Param("rIds") List<Integer> rIds);

    /**
     * 删除角色和权限
     */
    int deleteRoleMenuByRoleId(@Param("id") Integer id);

    /**
     * 为角色赋权限
     */
    int insertRoleMenu(@Param("rId") Integer rId, @Param("mIds") List<Integer> mIds);


}
