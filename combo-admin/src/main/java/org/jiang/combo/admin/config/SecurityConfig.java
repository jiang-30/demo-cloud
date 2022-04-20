package org.jiang.combo.admin.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jiang.combo.admin.common.filter.TokenAuthorizationFilter;
import org.jiang.combo.admin.common.utils.Result;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@EnableWebSecurity(debug = false)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return  new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(request -> {
                    request
                            .mvcMatchers(HttpMethod.GET,
                                    "/favicon.ico",
                                    "/doc.html",
                                    "/v3/**",
                                    "/swagger-resources/**",
                                    "/webjars/**",
                                    "/auth/test"
                            ).permitAll()
                            .mvcMatchers(HttpMethod.POST,
                                    "/auth/login",
                                    "/auth/register"
                            ).permitAll()
                            .mvcMatchers("/client/**", "/department/**", "/menu/**", "/role/**", "/user/**").permitAll()
                            .anyRequest().authenticated();
                })
                .exceptionHandling(exception -> {
                    exception
                            .authenticationEntryPoint((HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) -> {
                                String res  = objectMapper.writeValueAsString(Result.fail(401, "未认证，请登陆后再访问系统资源"));
                                Result.response(response, res);
                            })
                            .accessDeniedHandler((HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) -> {
                                String res  = objectMapper.writeValueAsString(Result.fail(403, "未授权，请联系管理员授权后访问系统资源"));
                                Result.response(response, res);
                            });
                })
                .addFilterAfter(new TokenAuthorizationFilter(), SecurityContextPersistenceFilter.class)
                .requestCache().disable()
                .csrf().disable()
                .sessionManagement().disable();
    }
}
