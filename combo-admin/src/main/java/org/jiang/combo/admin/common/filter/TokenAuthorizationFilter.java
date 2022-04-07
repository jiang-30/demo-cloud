package org.jiang.combo.admin.common.filter;

import org.jiang.combo.admin.common.utils.JwtUtil;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

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


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // 获取用户的认证信息
        String token = request.getHeader("Authorization");

//        System.out.println("header-token: " + token);
        if (token == null || !token.startsWith("Bearer ")) {
            //如果携带错误的token，则给用户提示请登录！
            filterChain.doFilter(request, response);
        } else  {

            //如果携带了正确格式的token要先得到token
            token = token.replace("Bearer ", "");
            int userId = JwtUtil.getSubject(token);
            System.out.println("header-username: " + userId);

            List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList(
                    "create,ROLE_ADMIN"
            );

            UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(userId, null, auths);

//            System.out.println("header-getPrincipal: " +  authRequest.getPrincipal());
//            System.out.println("header-getCredentials: " + authRequest.getCredentials());
//            System.out.println("header-authRequest: " +  authRequest.getAuthorities());

            // 添加到 Security 上下文
            SecurityContextHolder.getContext().setAuthentication(authRequest);

            filterChain.doFilter(request, response);
        }
    }
}
