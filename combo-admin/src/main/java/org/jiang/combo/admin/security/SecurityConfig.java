package org.jiang.combo.admin.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.jiang.combo.admin.security.handler.SecutityRestAuthenticationFilter;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//import javax.sql.DataSource;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final ObjectMapper objectMapper;
//    private final DataSource dataSource;

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
         * 未登录时错误处理
         * 登录成功处理
         * 登录失败处理
         * 注销成功处理
         * 注销失败处理
         */

        /**
         * 拦截那些请求
         * 多配置时候使用
         */
//        http
//                .requestMatchers();

//        http.authorizeHttpRequests()
        /**
         * 访问控制 authorizeRequests
         * 路径
         * antMatchers ant匹配 可以配置method
         * regexMatchers() 正则匹配 可以配置method
         * ? mvcMatcher() 统一前缀 spring.mvc.servlet.path
         * anyRequest 所有请求
         * 控制
         * authenticated() 需要被认证才能访问，permitAll() 任何人都允许访问， denyAll() 不允许被访问, anonymous() 匿名访问匹配的URL 会执行 filter
         * 特定
         * hasAuthority(String) 特定的权限
         * hasAnyAuthority(String ...) 给定权限中某一个
         * hasRole(String) 给定角色 ROLE_ 开头
         * hasAnyRole(String ...)
         * hasIpAddress(String) 如果请求是指定的 IP 就运行访问 可以通过 request.getRemoteAddr()获取 ip 地址。
         */
        http
                .authorizeRequests(request -> {
                    request
                            .antMatchers("/").permitAll()
                            .antMatchers("/auth/**", "/department/**").permitAll()
                            .anyRequest().authenticated();
                })

                .addFilter(secutityRestAuthenticationFilter())
        ;
        // 关闭 csrf
        http.csrf().disable();
        // 关闭 session
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        // 未登录时返回处理
//        http.httpBasic().authenticationEntryPoint(authenticationEntryPoint)
//        http.exceptionHandling()
//                .authenticationEntryPoint(new UnauthorizedEntryPoint());
// 登录
http.formLogin()
        .usernameParameter("username")
        .passwordParameter("password")
        .loginProcessingUrl("/auth/login")
//                .successHandler() // AuthenticationSuccessHandler
//                .failureHandler() // AuthenticationFailureHandler
        .permitAll();

// 注销
        http.logout(logout -> {
            logout

                    .logoutUrl("/auth/logout")
//                    .addLogoutHandler() // 登出处理器
//                    .logoutSuccessHandler()
            ; // 指定登出的请求路径
        });

//                authorizeRequests()
//                .anyRequest().authenticated();

//                .and().logout().logoutUrl("/admin/acl/index/logout")
//                .addLogoutHandler(new TokenLogoutHandler(tokenManager, redisTemplate)).and()
//                .addFilter(new TokenLoginFilter(authenticationManager(), tokenManager, redisTemplate))
//                .addFilter(new TokenAuthenticationFilter(authenticationManager(), tokenManager, redisTemplate)).httpBasic();

        /**
         * 基于 HttpServletRequest 的限制访问
         */
//        http.authorizeRequests();
        /**
         * 配置会话管理
         * 关闭 session
         */
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        /**
         * 请求缓存
         */
//        http.requestCache();
        /**
         * 更具 auth2 的认证
         */
//        http.oauth2Login();

        /**
         * 异常/错误处理
         * accessDeniedHandler() 访问受限后交处理，访问失败后
         */
//        http.exceptionHandling().accessDeniedHandler()

        /**
         * 表单登录：登录页面，登录路径，重定义登录字段名，登录成功重定向页面或者处理类，登录失败重定向页面或者处理类
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
         * .logoutSuccessHandler() 退出成功处理器
         * .addLogoutHandler()
         * clearAuthentication(boolean) 是否清除认证状态，默认为 true
         * invalidateHttpSession(boolean) 是否销毁 HttpSession 对象，默认为 true
         */
//        http.logout(logout -> {
//            logout
//
//                    .logoutUrl("/logout"); // 指定登出的请求路径
//        });

        /**
         * csrf 攻击
         *        // csrf配置
         *         httpSecurity.csrf();
         *         // 开启跨域共享，跨域伪造请求限制=无效
         *         httpSecurity.cors().and().csrf().disable();
         *         csrf.csrfTokenRepository();
         *         csrf.disable(); // 禁用 csrf
         */
//        http.csrf().disable();

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
//        auth
//                .jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery("select username, password, status as enabled from s_user where username = ?")
//                .authoritiesByUsernameQuery("select u.username as username,  r.code as authority from  s_user u left join r_user_role  userRole on u.id = userRole.user_id left join s_role r on userRole.role_id = r.id where u.username = ?")
//                .passwordEncoder(passwordEncoder())
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
