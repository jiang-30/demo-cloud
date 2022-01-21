package org.jiang.combo.platform.service;

import org.jiang.combo.platform.entity.Role;
import org.jiang.combo.platform.mapper.RoleMapper;
import org.jiang.combo.platform.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
