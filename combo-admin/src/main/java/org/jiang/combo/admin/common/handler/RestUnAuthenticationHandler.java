package org.jiang.combo.admin.common.handler;

import lombok.SneakyThrows;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 未认证
 */
@Component
public class RestUnAuthenticationHandler implements AuthenticationEntryPoint {

    @SneakyThrows
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setContentType("application/json; charset=utf-8");
//        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println("unAuth: " + authException);

//        String res  = objectMapper.readValue(R.fail(401, "为登录", authException.getMessage()), R.class);
        String res = "认证失败，无法访问系统资源，请先登陆";
        response.getWriter().write(res);
    }
}
