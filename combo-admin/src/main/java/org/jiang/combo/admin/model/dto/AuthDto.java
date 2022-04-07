package org.jiang.combo.admin.model.dto;

import lombok.Data;

@Data
public class AuthDto {
    private String accessToken;
    private String refreshToken;
    private int expireIn;
}
