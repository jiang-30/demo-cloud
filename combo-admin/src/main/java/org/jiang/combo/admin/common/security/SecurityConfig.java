package org.jiang.combo.admin.common.security;

import lombok.RequiredArgsConstructor;
import org.jiang.combo.admin.common.security.filter.TokenAuthenticationFilter;
import org.jiang.combo.admin.common.security.filter.TokenAuthorizationFilter;
import org.jiang.combo.admin.common.security.handler.*;
import org.jiang.combo.admin.common.security.service.SecurityUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
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
         * ?????????????????????????????????????????????????????????
         * ????????????????????????????????????????????????
         * ????????????????????????????????????????????????
         * ?????????????????????id??????????????????????????????????????????????????????????????????
         * requestMatchers() ??????????????? security ????????? authorizeRequests authorizeHttpRequests
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
     * ????????????
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
//                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()) // ???????????????????????????
        ;

    }

    /**
     * ??????
     * ??????????????????????????????
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(securityUserDetailsService)
                .passwordEncoder(passwordEncoder());

    }
}
