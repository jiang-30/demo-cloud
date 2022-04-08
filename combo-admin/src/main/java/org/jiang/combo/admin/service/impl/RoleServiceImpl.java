package org.jiang.combo.admin.service.impl;

import org.jiang.combo.admin.model.Role;
import org.jiang.combo.admin.mapper.RoleMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.jiang.combo.admin.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author combo
 * @since 2022-01-21
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Override
    public List<Role> getRolesByUserId(Integer id) {
        return baseMapper.getRolesByUserId(id);
    }
}
