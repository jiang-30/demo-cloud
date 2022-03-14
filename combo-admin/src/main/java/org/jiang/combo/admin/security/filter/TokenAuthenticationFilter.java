package org.jiang.combo.admin.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.jiang.combo.admin.security.entity.LoginDto;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 认证
 */
public class TokenAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    public TokenAuthenticationFilter(
            String processesUrl,
            AuthenticationManager authenticationManager,
            AuthenticationSuccessHandler authenticationSuccessHandler,
            AuthenticationFailureHandler authenticationFailureHandler
    ) {
        setFilterProcessesUrl(processesUrl);
        setAuthenticationManager(authenticationManager);
        setAuthenticationSuccessHandler(authenticationSuccessHandler);
        setAuthenticationFailureHandler(authenticationFailureHandler);
    }

    @SneakyThrows
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        if (!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("请求方法不支持: " + request.getMethod());
        }

        System.out.println("contentType: " + request.getContentType());
        if(!request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)) {
            throw new AuthenticationServiceException("错误的 Content-type: " + request.getMethod());
        }

        ObjectMapper mapper = new ObjectMapper();
        LoginDto loginDto = mapper.readValue(request.getInputStream(), LoginDto.class);

        System.out.println("123:" + loginDto);

        String username = loginDto.getUsername();
        username = (username != null) ? username : "";
        username = username.trim();
        String password = loginDto.getPassword();
        password = (password != null) ? password : "";
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);

        setDetails(request, authRequest);
        return this.getAuthenticationManager().authenticate(authRequest);

//        try {
//            UserPojo sysUser = new ObjectMapper().readValue(request.getInputStream(), UserPojo.class);
//            UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(sysUser.getUsername(), sysUser.getPassword());
//            return authenticationManager.authenticate(authRequest);
//        }catch (Exception e){
//            try {
//                response.setContentType("application/json;charset=utf-8");
//                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//                PrintWriter out = response.getWriter();
//                Map resultMap = new HashMap();
//                resultMap.put("code", HttpServletResponse.SC_UNAUTHORIZED);
//                resultMap.put("msg", "用户名或密码错误！");
//                out.write(new ObjectMapper().writeValueAsString(resultMap));
//                out.flush();
//                out.close();
//            }catch (Exception outEx){
//                outEx.printStackTrace();
//            }
//            throw new RuntimeException(e);
//        }
    }

}
