package org.jiang.combo.admin.model.dto;

import lombok.Data;
import org.jiang.combo.admin.model.Role;
import org.jiang.combo.admin.model.User;

import java.util.List;

@Data
public class AuthDto {
    private String tokenType = "bearer";
    private String accessToken;
    private String refreshToken;
    private long expireIn;
    private User user;
    private List<String> authorities;
    private List<Role> roles;
    //    scope: "server"
}
