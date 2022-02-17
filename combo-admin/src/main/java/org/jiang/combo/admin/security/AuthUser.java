package org.jiang.combo.admin.security;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
public class AuthUser implements UserDetails {
    /**
     * 通常 access token 是有有效期限的，如果过期就需要重新获取
     */
//    private String accessToken;

    /**
     * 一旦 access token 过期，你就可以通过 refresh token 再次请求 access token
     * 如果 refesh token 也过期了 这就需要用户重新登陆授权了
     */
//    private String refreshToken;
    private int id;
    private String username;
    private String password;
    private String enabled;
    private List<String> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    /**
     * 账户是否为未过期
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 账户是否为未锁定
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 密码是否为过期
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 是否可用
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
