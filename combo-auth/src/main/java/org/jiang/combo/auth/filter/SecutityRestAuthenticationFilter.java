package org.jiang.combo.auth.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecutityRestAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
//    private ObjectMapper objectMapper;

//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
//
//        UsernamePasswordAuthenticationToken authenticationToken;
//        authenticationToken = new UsernamePasswordAuthenticationToken("user", "123456");
//
//        System.out.println("filter;" + authenticationToken);
//        setDetails(request, authenticationToken);
//        return this.getAuthenticationManager().authenticate(authenticationToken);
//    }
}
