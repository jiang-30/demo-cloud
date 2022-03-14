package org.jiang.combo.admin.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.jiang.combo.admin.model.User;
import org.jiang.combo.admin.mapper.UserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 登录用户信息表 服务实现类
 * </p>
 *
 * @author combo
 * @since 2022-01-21
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    /**
     * 根据用户名查询用户信息
     */
    @Override
    public User getByUsername(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        User user = getOne(queryWrapper);
        return user;
    }
}
