package org.jiang.combo.admin.security;

public class authDto {
    /**
     * 通常 access token 是有有效期限的，如果过期就需要重新获取
     */
    private String accessToken;

    /**
     * 一旦 access token 过期，你就可以通过 refresh token 再次请求 access token
     * 如果 refesh token 也过期了 这就需要用户重新登陆授权了
     */
    private String refreshToken;
}
