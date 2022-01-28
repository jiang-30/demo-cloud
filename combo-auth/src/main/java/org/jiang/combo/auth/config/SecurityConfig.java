package org.jiang.combo.auth.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.jiang.combo.auth.filter.SecutityRestAuthenticationFilter;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final ObjectMapper objectMapper;
    private final DataSource dataSource;

    public  SecutityRestAuthenticationFilter secutityRestAuthenticationFilter() throws Exception {
        SecutityRestAuthenticationFilter filter = new SecutityRestAuthenticationFilter();
        filter.setAuthenticationManager(authenticationManager());
        filter.setAuthenticationSuccessHandler((request, response, authentication) -> {  // AuthenticationSuccessHandler
//                        response.setStatus(HttpStatus.);
//                        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.getWriter().println(objectMapper.writeValueAsString(authentication));
        });
        filter.setAuthenticationFailureHandler((request, response, exception) -> {

            response.getWriter().println(objectMapper.writeValueAsString(exception));
        });

        filter.setFilterProcessesUrl("/auth");

        return filter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        /**
         * 拦截那些请求
         * 多配置时候使用
         */
//        http
//                .requestMatchers();

        /**
         *
         */
        http
                .authorizeRequests(request -> {
                    request
                            .antMatchers("/authorize/**").permitAll()
                            .anyRequest().authenticated();
                })
                .addFilter(secutityRestAuthenticationFilter())
        ;

        /**
         * 登陆认证 UsernamePasswordAuthenticationFilter
         * AuthenticationSuccessHandler
         */
//        http.formLogin()
//               .loginPage("/login") // 自定义登陆页的路径
//                .usernameParameter("username") // 自定义登陆表单用户名
//                .passwordParameter("password") // 自定义登陆表单密码名
//                .loginProcessingUrl("/auth/auth") // 自定义登陆接口api路径
////                .successForwardUrl("/home") // 登陆成功后重定向的url
////                .failureForwardUrl("/login/fail") // 登陆失败后重定向的url
//                .successHandler(((request, response, authentication) -> {  // AuthenticationSuccessHandler
//                    ObjectMapper objectMapper = new ObjectMapper();
////                    response.setStatus(HttpStatus.);
////                    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
//                    response.getWriter().println(objectMapper.writeValueAsString(authentication));
//                }))
////                .failureHandler(((request, response, exception) -> {}))
//                .permitAll(); // 跳过认证



        /**
         * 退出登陆
         * .logoutSuccessHandler()
         */
        http.logout(logout -> {
            logout
                    .logoutUrl("/logout"); // 指定登出的请求路径
        });

        /**
         * csrf 攻击
         */
        http.csrf(csrf -> {
//            csrf.csrfTokenRepository();
            csrf.disable(); // 禁用 csrf
        });

        /**
         * session remember-me
         * cookie 存储 用户名、过期时间、hash
         * hash：md5(用户名、密码、过期时间、key)
         */
        http.rememberMe().disable();

    }

    /**
     * 路径忽略
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .mvcMatchers("/public/**")
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()); // 常用的静态资源目录

    }

    /**
     * 授权
     * 配置用户、密码、角色
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select username, password, status as enabled from s_user where username = ?")
                .authoritiesByUsernameQuery("select u.username as username,  r.code as authority from  s_user u left join r_user_role  userRole on u.id = userRole.user_id left join s_role r on userRole.role_id = r.id where u.username = ?")
                .passwordEncoder(passwordEncoder());
//                .inMemoryAuthentication()
//                .withUser("user").password(passwordEncoder().encode("123456")).disabled(true).roles("ADMIN", "USER")
//                .and().withUser("user1").password(passwordEncoder().encode("123456")).roles("ADMIN")
        ;

    }

    @Bean
    PasswordEncoder passwordEncoder() {
//        Pbkdf2PasswordEncoder()
//        MessageDigestPasswordEncoder // md5 sha-1
//        Encoder
//        return new BCryptPasswordEncoder();
        return NoOpPasswordEncoder.getInstance();
    }
}
