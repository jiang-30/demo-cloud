package org.jiang.combo.admin.common.filter;

import lombok.SneakyThrows;
import org.jiang.combo.admin.common.utils.JwtUtil;
import org.jiang.combo.admin.common.utils.RedisUtil;
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
 * 认证：解析Authorization 查询用户信息
 */
public class TokenAuthorizationFilter extends OncePerRequestFilter {

    @Resource
    private RedisUtil redisUtil;

//    @Resource
//    private AuthService authService;

    @SneakyThrows
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = request.getHeader("Authorization");
        System.out.println(token);

        /**
         * 携带token则解析，解析成功后查询用户信息生成 Authentication
         */
        if (token != null && token.startsWith("Bearer ")) {
            token = token.replace("Bearer ", "");
            String username = JwtUtil.getAccessSubject(token);
            String s = redisUtil.get("authorization:" + username);
            if(s  != null) {
                //          User user = authService.getByUsername(username);


                List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList(
                        "create,ROLE_ADMIN"
                );
                UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, null, auths);
                SecurityContextHolder.getContext().setAuthentication(authRequest);
            }
        }
        filterChain.doFilter(request, response);
    }
}
