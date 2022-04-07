package org.jiang.combo.admin.security.handler;

import org.jiang.combo.admin.common.utils.RedisUtil;
import org.jiang.combo.admin.common.utils.TokenManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 退出处理
 */
@Component
public class TokenLogoutHandler implements LogoutHandler {

    @Resource
    private TokenManager tokenManager;

    @Resource
    private RedisUtil redisUtil;

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        // 从 header 中 获取 token
        String token = request.getHeader("token");

        System.out.println("logout: " + authentication);

        // token 不为空；移除token、redis中删除token
        if (token != null) {
            tokenManager.removeToken(token);
            String username = tokenManager.getUserInfo(token);
            redisUtil.del(username);
        }

    }
}
