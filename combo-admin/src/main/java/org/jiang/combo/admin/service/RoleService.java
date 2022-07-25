package org.jiang.combo.admin.service;

import org.jiang.combo.admin.model.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 角色 服务类
 * </p>
 *
 * @author combo
 * @since 2022-01-21
 */
public interface RoleService extends IService<Role> {

    /**`zxcvbnm
     * 查询用户角色列表
     */
    List<Role> getRolesByUserId(Integer id);

}
