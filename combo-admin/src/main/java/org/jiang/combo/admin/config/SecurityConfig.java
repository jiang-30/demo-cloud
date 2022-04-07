package org.jiang.combo.admin.config;

import org.jiang.combo.admin.common.filter.TokenAuthorizationFilter;
import org.jiang.combo.admin.common.handler.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;


@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@Configuration
@EnableWebSecurity(debug = false)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return  new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .exceptionHandling(exception -> {
                    exception
                            .authenticationEntryPoint(new RestUnAuthenticationHandler())
                            .accessDeniedHandler(new RestUnAuthorizationHandler());
                })
                .authorizeHttpRequests(request -> {
                    request
                            .antMatchers("/auth/test", "/auth/login", "/auth/register").permitAll()
                            .anyRequest().authenticated();
                })
                .csrf(csrf -> {
                    csrf.disable();
                })
                .addFilterAfter(new TokenAuthorizationFilter(), SecurityContextPersistenceFilter.class)
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
                        "/favicon.ico",
                        "/doc.html",
                        "/v3/**",
                        "/swagger-resources/**",
                        "/webjars/**"
                );

    }
}
