package org.jiang.combo.admin.security;

import lombok.RequiredArgsConstructor;
import org.jiang.combo.admin.security.filter.TokenAuthenticationFilter;
import org.jiang.combo.admin.security.filter.TokenAuthorizationFilter;
import org.jiang.combo.admin.security.handler.*;
import org.jiang.combo.admin.security.service.SecurityUserDetailsService;
import org.jiang.combo.admin.security.service.UserDetailsPasswordServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;

import java.util.HashMap;
import java.util.Map;


//@Configuration
@RequiredArgsConstructor
//@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
//@EnableWebSecurity(debug = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private  final SecurityUserDetailsService securityUserDetailsService;

    @Bean
    PasswordEncoder passwordEncoder() {
//        Pbkdf2PasswordEncoder()
//        MessageDigestPasswordEncoder // md5 sha-1
//        return NoOpPasswordEncoder.getInstance();
//
        String default1 = "bcrypt";

        Map encoders = new HashMap();
        encoders.put(default1, new BCryptPasswordEncoder());
        encoders.put("md5", new MessageDigestPasswordEncoder("md5"));
        new DelegatingPasswordEncoder(default1, encoders);

        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        /**
         * 异常；未登录时错误处理，未授权限的处理
         * 登录；登录成功处理；登录失败处理
         * 登出；注销成功处理；注销失败处理
         * 动态权限；权限id、权限标识、权限名称、资源名称、资源访问地址
         * requestMatchers() 匹配要进入 security 的路径 authorizeRequests authorizeHttpRequests
         */
        http
                .exceptionHandling(exception -> {
                    exception
                            .authenticationEntryPoint(new RestUnAuthenticationHandler())
                            .accessDeniedHandler(new RestUnAuthorizationHandler());
                })
                .authorizeHttpRequests(request -> {
                    request
                            .antMatchers(HttpMethod.GET, "/test/index", "/login").permitAll()
                            .anyRequest().authenticated()
//                            .anyRequest().access(new DynamicAuthorizationManager())
                    ;
                })
                .formLogin(Customizer.withDefaults())
                .logout(logout -> {
                    logout
                            .logoutUrl("/auth/logout")
                            .addLogoutHandler(new TokenLogoutHandler())
                            .logoutSuccessHandler(new RestLogoutSuccessHandler());
                })
                .csrf(csrf -> {
                    csrf.disable();
                })
                .rememberMe(remember -> {
                    remember.disable();
                })
//                .sessionManagement(session -> {
//                    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//                })
                .addFilterAfter(new TokenAuthorizationFilter(), SecurityContextPersistenceFilter.class)
                .addFilterAfter(
                        new TokenAuthenticationFilter(
                                "/auth/login",
                                authenticationManager(),
                                new RestAuthenticationSuccessHandler(),
                                new RestAuthenticationFailureHandler()
                        ),
                        UsernamePasswordAuthenticationFilter.class
                )
        ;
    }

    /**
     * 路径忽略
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers(
                        HttpMethod.GET,
                        "/v3/**",
                        "/doc.html",
                        "/swagger-resources/**"
                )
                .mvcMatchers("/static/**")
//                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()) // 常用的静态资源目录
        ;

    }

    /**
     * 授权
     * 配置用户、密码、角色
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(securityUserDetailsService)
                .passwordEncoder(passwordEncoder());

    }
}
