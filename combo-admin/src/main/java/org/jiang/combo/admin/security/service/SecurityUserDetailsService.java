package org.jiang.combo.admin.security.service;

import org.jiang.combo.admin.model.entiry.User;
import org.jiang.combo.admin.security.AuthUser;
import org.jiang.combo.admin.service.AuthService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 通过 username 查询用户，并构建用户信息
 */
@Service
public class SecurityUserDetailsService implements UserDetailsService {
    @Resource
    AuthService authService;

    @Override
    public AuthUser loadUserByUsername(String username) throws UsernameNotFoundException {

        if(username == "") {
            System.out.println("username11" + username);
            throw new UsernameNotFoundException("请输入用户名");
        }

        // 查询用户信息
        User user = authService.getByUsername(username);

        if(user == null) {
            throw new UsernameNotFoundException("username 的用户不存在");
        }

        // 角色、权限
        AuthUser authUser = new AuthUser();
        List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList(
                "create,ROLE_ADMIN"
        );

        authUser.setId(user.getId());
        authUser.setUsername(user.getUsername());
        authUser.setPassword(user.getPassword());
        authUser.setEnabled(user.getStatus());
        authUser.setAuthorities(auths);
        return authUser;
    }
}
