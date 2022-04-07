package org.jiang.combo.admin.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.RequiredArgsConstructor;
import org.jiang.combo.admin.common.utils.JwtUtil;
import org.jiang.combo.admin.common.utils.RedisUtil;
import org.jiang.combo.admin.model.User;
import org.jiang.combo.admin.mapper.UserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.jiang.combo.admin.model.bo.SecurityUserDetails;
import org.jiang.combo.admin.model.dto.AuthDto;
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

    private final PasswordEncoder passwordEncoder;
    private final RedisUtil redisUtil;

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

    @Override
    public boolean isExistUsername(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        long l = count(queryWrapper);

        return l > 0;
    }

    /**
     * 1. 查询用户信息生成 token
     * 2. redis 中如果已存在清楚
     * 2. 基础信息存入redis
     */
    @Override
    public AuthDto getAuthByUsernameAndPassword(String username, String password) throws Exception {
        User user = getByUsername(username);

        if(user == null) {
            throw new Exception("用户名不正确");
        }

        if(!passwordEncoder.matches(password, user.getPassword())) {
            throw new Exception("密码不正确");
        }

        String accessToken = JwtUtil.generateToken(user.getId());
        String refreshToken = JwtUtil.generateToken(user.getId());

        redisUtil.set(user.getUsername(), user.getUsername());

        AuthDto auth = new AuthDto();
        auth.setAccessToken(accessToken);
        auth.setRefreshToken(refreshToken);
        auth.setExpireIn(JwtUtil.expireIn);

        return auth;
    }

    @Override
    public SecurityUserDetails getSecurityUserDetailsById(Long id) throws Exception {
        User user = getById(id);

        if(user == null) {
            throw new Exception("用户不存在");
        }

        System.out.println(redisUtil.get("admin"));

        List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList(
                "create,ROLE_ADMIN"
        );

        SecurityUserDetails userDetails = new SecurityUserDetails();


        userDetails.setId(user.getId());
        userDetails.setUsername(user.getUsername());
        userDetails.setPassword(user.getPassword());
        userDetails.setEnabled(user.getStatus());
        userDetails.setAuthorities(auths);
        return userDetails;
    }

}
