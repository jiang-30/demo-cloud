package org.jiang.combo.admin.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.jiang.combo.admin.common.utils.Result;
import org.jiang.combo.admin.model.entiry.User;
import org.jiang.combo.admin.model.dto.AuthDto;
import org.jiang.combo.admin.model.dto.UserLoginDto;
import org.jiang.combo.admin.model.dto.UserRegisterDto;
import org.jiang.combo.admin.service.AuthService;
import org.jiang.combo.admin.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
     * 校验用户的accessToken 是否有效
     */
    @ApiOperationSupport(order = 4)
    @ApiOperation("验证token有效性")
    @PostMapping("/check")
    public void check() {

    }

    @ApiOperation(value = "退出登录", tags = "退出登录", notes = "删除用户登录信息")
    @ApiOperationSupport(order = 4)
    @PostMapping("/logout")
    public void logout() {

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
