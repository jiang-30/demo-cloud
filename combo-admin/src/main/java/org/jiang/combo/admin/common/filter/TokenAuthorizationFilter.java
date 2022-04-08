package org.jiang.combo.admin.common.filter;

import lombok.SneakyThrows;
import org.jiang.combo.admin.common.utils.JwtUtil;
import org.jiang.combo.admin.model.User;
import org.jiang.combo.admin.service.AuthService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 授权
 */
public class TokenAuthorizationFilter extends OncePerRequestFilter {


//    @Resource
//    private AuthService authService;

    @SneakyThrows
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 获取用户的认证信息
        String token = request.getHeader("Authorization");
        System.out.println(token);

        if (token != null && token.startsWith("Bearer ")) {
            //如果携带了正确格式的token要先得到token
            token = token.replace("Bearer ", "");
            String username = JwtUtil.getAccessSubject(token);
//            System.out.println("header-username: " + username);

//            User user = authService.getByUsername(username);

            List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList(
                    "create,ROLE_ADMIN"
            );

            UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, null, auths);
            // 添加到 Security 上下文
            SecurityContextHolder.getContext().setAuthentication(authRequest);
        }
        filterChain.doFilter(request, response);
    }
}
