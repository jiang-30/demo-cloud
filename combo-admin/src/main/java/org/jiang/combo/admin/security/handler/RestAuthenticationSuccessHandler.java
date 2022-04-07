package org.jiang.combo.admin.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jiang.combo.admin.security.AuthUser;
import org.jiang.combo.admin.common.utils.RedisUtil;
import org.jiang.combo.admin.common.utils.TokenManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录成功
 */
@Component
public class RestAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Resource
    private RedisUtil redisOperator;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        AuthUser authUser =  (AuthUser) authentication.getPrincipal();

        System.out.println("success-details:" + authentication.getDetails());
        System.out.println("success-Principal:" + authUser);
        System.out.println("success-Credentials:" + authentication.getCredentials());
        System.out.println("success-Authorities:" + authentication.getAuthorities());

        // 更具用户名生成 token Bearer
        TokenManager tokenManager = new TokenManager();
        String token = tokenManager.generateToken(authUser.getUsername());
        System.out.println("success-token:" + token);

        // 将用户信息、权限信息放到 redis
//        redisOperator.set();

        // 返回信息
        ObjectMapper objectMapper = new ObjectMapper();
        String res = objectMapper.writeValueAsString(authUser);

        response.setContentType("application/json; charset=utf-8;");
        response.getWriter().write(res);
    }

}
