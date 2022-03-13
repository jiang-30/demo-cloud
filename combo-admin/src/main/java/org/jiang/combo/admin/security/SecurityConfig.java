package org.jiang.combo.admin.security;

import lombok.RequiredArgsConstructor;
import org.jiang.combo.admin.security.filter.TokenAuthenticationFilter;
import org.jiang.combo.admin.security.filter.TokenAuthorizationFilter;
import org.jiang.combo.admin.security.handler.*;
import org.jiang.combo.admin.security.service.SecurityUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;


@RequiredArgsConstructor
//@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@EnableWebSecurity(debug = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private  final SecurityUserDetailsService securityUserDetailsService;
//    private final PasswordEncoder

    @Bean
    PasswordEncoder passwordEncoder() {
//        Pbkdf2PasswordEncoder()
//        MessageDigestPasswordEncoder // md5 sha-1
        return new BCryptPasswordEncoder();
//        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        /**
         * 未登录时错误处理
         * 登录成功处理
         * 登录失败处理
         * 注销成功处理
         * 注销失败处理
         * 权限id、权限标识、权限名称、资源名称、资源访问地址
         */
        http
                .exceptionHandling(exception -> {
                    exception
                            .authenticationEntryPoint(new RestUnAuthenticationHandler())
                            .accessDeniedHandler(new RestUnAuthorizationHandler());
                })
                .authorizeRequests(request -> {
                    request
//                            .antMatchers().permitAll()
////                            .antMatchers("/test/index").hasAuthority("create")
                            .anyRequest().authenticated();
                })
                .logout(logout -> {
                    logout
                            .logoutUrl("/auth/logout").permitAll()
                            .addLogoutHandler(new TokenLogoutHandler())
                            .logoutSuccessHandler(new RestLogoutSuccessHandler());
                })
                .csrf(csrf -> {
                    csrf.disable();
                })
                .rememberMe(remember -> {
                    remember.disable();
                })
                .sessionManagement(session -> {
                    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                })
                .addFilterAfter(new TokenAuthorizationFilter(), SecurityContextPersistenceFilter.class)
                .addFilterAt(
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
                        "/swagger-resources/**",
                        "/v3/**",
                        "/doc.html"
//                        "/auth/login"
                )
                .mvcMatchers("/public/**")
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
                .userDetailsService(securityUserDetailsService).passwordEncoder(passwordEncoder())
        ;

    }
}
