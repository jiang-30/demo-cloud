package org.jiang.combo.admin.security.handler;

import org.jiang.combo.admin.entity.User;
import org.jiang.combo.admin.security.AuthUser;
import org.jiang.combo.admin.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SecurityUserDetailsService implements UserDetailsService {
    @Resource
    UserService userService;


    @Override
    public AuthUser loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userService.getByUsername(username);
        System.out.println(username + ";" + user.getPassword());

        AuthUser authUser = new AuthUser();
        authUser.setId(user.getId());
        authUser.setUsername(user.getUsername());
        authUser.setPassword(user.getPassword());
        authUser.setEnabled(user.getStatus());
        return authUser;
    }
}
