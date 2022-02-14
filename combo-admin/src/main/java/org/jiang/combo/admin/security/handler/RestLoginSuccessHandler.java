package org.jiang.combo.admin.security.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录成功
 */
@Component
public class RestLoginSuccessHandler  implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//        AjaxResponseBody responseBody = new AjaxResponseBody();
//
//        responseBody.setStatus("00");
//        responseBody.setMsg("登陆成功!");

//        SelfUserDetails selfUserDetails = (SelfUserDetails) authentication.getPrincipal();

// 创建 token ，并返回 ，设置过期时间为 300 秒
//        String jwtToken = JwtTokenUtil.generateToken(selfUserDetails.getUsername(), 300);
//        responseBody.setJwtToken(jwtToken);

        response.getWriter().write("登录成功JSON.toJSONString(responseBody");
    }
}
