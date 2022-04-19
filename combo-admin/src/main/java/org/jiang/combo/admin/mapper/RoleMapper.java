package org.jiang.combo.admin.mapper;

import org.apache.ibatis.annotations.Param;
import org.jiang.combo.admin.model.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 角色 Mapper 接口
 * </p>
 *
 * @author combo
 * @since 2022-01-21
 */
public interface RoleMapper extends BaseMapper<Role> {
    /**
     * 通过用户id查询角色信息
     */
    List<Role> getRolesByUserId(@Param("id") Integer id);

    /**
     * 通过用户id查询角色列表
     */
    List<Role> listByUserId(@Param("id") Integer id);



}
