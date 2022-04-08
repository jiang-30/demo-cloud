package org.jiang.combo.admin.model.dto;

import lombok.Data;
import org.jiang.combo.admin.model.User;

@Data
public class AuthDto {
    private String accessToken;
    private String refreshToken;
    private long expireIn;
    private User user;
//    menus
//    roles: ["ROLE_ADMIN"]
//    authorities ["get:/admin/user/*"]
//    token_type: "bearer"
//    scope: "server"
}
