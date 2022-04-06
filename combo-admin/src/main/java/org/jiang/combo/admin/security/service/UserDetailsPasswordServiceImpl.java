package org.jiang.combo.admin.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;

/**
 * 更新用户密码加密策略
 */
public class UserDetailsPasswordServiceImpl implements UserDetailsPasswordService {
    @Override
    public UserDetails updatePassword(UserDetails user, String newPassword) {
        return null;
    }
}
