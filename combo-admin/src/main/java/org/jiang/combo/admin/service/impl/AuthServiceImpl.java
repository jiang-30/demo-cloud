package org.jiang.combo.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.RequiredArgsConstructor;
import org.jiang.combo.admin.common.utils.JwtUtil;
import org.jiang.combo.admin.common.utils.RedisUtil;
import org.jiang.combo.admin.model.Role;
import org.jiang.combo.admin.model.User;
import org.jiang.combo.admin.model.bo.SecurityUserDetails;
import org.jiang.combo.admin.model.dto.AuthDto;
import org.jiang.combo.admin.service.AuthService;
import org.jiang.combo.admin.service.MenuService;
import org.jiang.combo.admin.service.RoleService;
import org.jiang.combo.admin.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserService userService;
    private final RoleService roleService;
    private final MenuService menuService;
    private final PasswordEncoder passwordEncoder;
    private final RedisUtil redisUtil;

    @Override
    public User getByUsername(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        User user = userService.getOne(queryWrapper);

        return user;
    }

    @Override
    public AuthDto createAuthorization(String username, String password) throws Exception {
        User user = getByUsername(username);

        if(user == null) {
            throw new Exception("用户名不正确");
        }

        if(!passwordEncoder.matches(password, user.getPassword())) {
            throw new Exception("密码不正确");
        }

        /**
         * 用户角色信息
         */
        List<Role> roles = roleService.getRolesByUserId(user.getId());
        user.setRoles(roles);
        List<Integer> rIds = roles.stream().map(Role::getId).collect(Collectors.toList());
        List<String> authorities= menuService.getAuthoritiesByRoles(rIds);


        /**
         * token
         */
        String accessToken = JwtUtil.generateAccessToken(user.getUsername());
        String refreshToken = JwtUtil.generateRefreshToken(user.getUsername());

//        permission
//        menus
        redisUtil.set("authorization:" + user.getUsername(), user.getUsername());


        AuthDto auth = new AuthDto();
        auth.setAccessToken(accessToken);
        auth.setRefreshToken(refreshToken);
        auth.setExpireIn(JwtUtil.expireIn);
        auth.setUser(user);

        return auth;
    }

    @Override
    public void deleteAuthorization() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        System.out.println(principal);

    }

    @Override
    public AuthDto getAuthByUsernameAndPassword(String username, String password) throws Exception {
        User user = getByUsername(username);

        if(user == null) {
            throw new Exception("用户名不正确");
        }

        if(!passwordEncoder.matches(password, user.getPassword())) {
            throw new Exception("密码不正确");
        }

        /**
         * 用户角色信息
         */
        List<Role> roles = roleService.getRolesByUserId(user.getId());
        user.setRoles(roles);
        List<Integer> rIds = roles.stream().map(Role::getId).collect(Collectors.toList());
        List<String> authorities= menuService.getAuthoritiesByRoles(rIds);


        /**
         * token
         */
        String accessToken = JwtUtil.generateAccessToken(user.getUsername());
        String refreshToken = JwtUtil.generateRefreshToken(user.getUsername());

//        permission
//        menus
        redisUtil.set("authorization:" + user.getUsername(), user.getUsername());


        AuthDto auth = new AuthDto();
        auth.setAccessToken(accessToken);
        auth.setRefreshToken(refreshToken);
        auth.setExpireIn(JwtUtil.expireIn);
        auth.setUser(user);

        return auth;
    }

    @Override
    public SecurityUserDetails getSecurityUserDetails(String username) throws Exception {
        User user = getByUsername(username);

        System.out.println(redisUtil.get("admin"));

        List<Role> roles = roleService.getRolesByUserId(user.getId());
        user.setRoles(roles);

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
