package org.jiang.combo.admin.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.jiang.combo.admin.common.utils.JwtUtil;
import org.jiang.combo.admin.common.utils.Result;
import org.jiang.combo.admin.model.User;
import org.jiang.combo.admin.model.dto.AuthDto;
import org.jiang.combo.admin.model.dto.UserLoginDto;
import org.jiang.combo.admin.model.dto.UserRegisterDto;
import org.jiang.combo.admin.service.AuthService;
import org.jiang.combo.admin.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 注册
 * 登录
 * 登出
 */
@ApiSort(1)
@Api(tags="认证授权")
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final AuthService authService;

    @GetMapping("/test")
    public List<User> test() {
        List<User> list = userService.list();
        return list;
    }

    /**
     * 用户注册：用户通过用户名和密码注册
     * 0. 密码解密
     * 1. 用户名唯一
     * 2. 邮箱唯一
     * 3. 默认角色
     */
    @ApiOperationSupport(order = 1)
    @ApiOperation("用户注册")
    @PostMapping("/register")
    public boolean register(@Valid @RequestBody UserRegisterDto registerUser) throws Exception {
        boolean flag = userService.isExistUsername(registerUser.getUsername());

        if(flag) {
            throw new Exception("用户已存在");
        }

        User user = new User();
        user.setPassword(passwordEncoder.encode(registerUser.getPassword()));
        user.setUsername(registerUser.getUsername());

        boolean save = userService.save(user);

        return save;
    }

    /**
     * 用户登录
     * 用户通过用户名和密码获取token和用户信息
     */
    @ApiOperationSupport(order = 2)
    @ApiOperation("用户登录")
    @PostMapping("/login")
    public AuthDto login(@Valid @RequestBody UserLoginDto userLogin) throws Exception {
        AuthDto auth = authService.getAuthByUsernameAndPassword(userLogin.getUsername(), userLogin.getPassword());

        return auth;
    }

    /**
     * 刷新token
     * 通过 refreshToken 获取新的token
     */
    @ApiOperationSupport(order = 3)
    @ApiOperation("刷新token")
    @PostMapping("/refresh")
    public Result<String> refresh(@RequestBody String refreshToken) {
        return Result.success(refreshToken);
    }

    /**
     * 校验 token
     * 校验用户的accessToken 是否有效
     */
    @ApiOperationSupport(order = 4)
    @ApiOperation("验证token有效性")
    @PostMapping("/check")
    public void check() {

    }

    /**
     * 获取当前用户的基础信息
     * 用户信息、角色信息
     */
    @ApiOperationSupport(order = 5)
    @ApiOperation("查询基础信息")
    @PostMapping("/user")
    public Authentication user(Authentication auth) {
        return auth;
    }

    /**
     * 当前用户角色包含的权限信息
     */
    @ApiOperationSupport(order = 5)
    @ApiOperation("查询权限信息")
    @PostMapping("/permission")
    public void permission() {

    }

    @ApiOperationSupport(order = 5)
    @ApiOperation("查询菜单信息")
    @PostMapping("/menu")
    public void menu() {

    }

    @PostMapping("/profile")
    public void profile() {

    }

}
