package org.jiang.combo.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.RequiredArgsConstructor;
import org.jiang.combo.admin.common.utils.JwtUtil;
import org.jiang.combo.admin.common.utils.RedisUtil;
import org.jiang.combo.admin.model.User;
import org.jiang.combo.admin.mapper.UserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.jiang.combo.admin.model.bo.SecurityUserDetails;
import org.jiang.combo.admin.model.dto.AuthDto;
import org.jiang.combo.admin.model.dto.UserDto;
import org.jiang.combo.admin.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 登录用户信息表 服务实现类
 * </p>
 *
 * @author combo
 * @since 2022-01-21
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public boolean isExistUsername(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        long l = count(queryWrapper);

        return l > 0;
    }

    @Override
    public User getUser(Integer id) {
        return baseMapper.getUser(id);
    }
}
