package org.jiang.combo.admin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jiang.combo.admin.common.enums.ResultCode;
import org.jiang.combo.admin.common.exception.BizException;
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

@Api(tags="用户认证授权")
@RequestMapping("/auth")
@RestController
@Slf4j
@RequiredArgsConstructor
public class AuthController {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final AuthService authService;

    @ApiOperation("用户注册")
    @PostMapping("/register")
    public boolean register(@Valid @RequestBody UserRegisterDto registerUser) throws Exception {
        boolean flag = userService.isExistUsername(registerUser.getUsername());

        if(flag) {
            throw new BizException(ResultCode.USER_HAS_EXISTED);
        }

        User user = new User();
        user.setPassword(passwordEncoder.encode(registerUser.getPassword()));
        user.setUsername(registerUser.getUsername());

        boolean save = userService.save(user);

        return save;
    }


    @ApiOperation(value = "用户登录", notes = "用户通过用户名和密码获取token和用户信息")
    @PostMapping("/login")
    public AuthDto login(@Valid @RequestBody UserLoginDto userLogin) throws Exception {

        log.info("'djfj'");
        AuthDto auth = authService.getAuthByUsernameAndPassword(userLogin.getUsername(), userLogin.getPassword());

        return auth;
    }

    @ApiOperation(value = "退出登录", notes = "删除用户登录信息 token有效性")
    @PostMapping("/logout")
    public void logout() {

    }

    @ApiOperation(value="校验token", notes="校验用户的 accessToken 是否有效")
    @PostMapping("/check")
    public void check() {

    }

    @ApiOperation(value = "刷新token", notes = "通过 refreshToken 获取新的token")
    @PostMapping("/refresh")
    public Result<String> refresh(@RequestBody String refreshToken) {
        return Result.success(refreshToken);
    }

    @ApiOperation(value="查询基础信息", notes = "获取当前用户的基础信息 用户信息、角色信息、部门信息")
    @PostMapping("/profile")
    public Authentication profile(Authentication auth) {
        return auth;
    }

    @ApiOperation(value="查询菜单信息", notes = "用户权限信息 菜单、权限")
    @PostMapping("/menu")
    public void menu() {

    }

    @ApiOperation(value="查询权限信息", notes = "当前用户角色包含的权限信息")
    @PostMapping("/permission")
    public void permission() {

    }


    @ApiOperation(value="找回密码")
    @PostMapping("/password-find")
    public void findPassword() {


    }


    @ApiOperation("修改用户密码")
    @PostMapping("/password-update")
    public void updatePassword() {

    }

    @ApiOperation("修改用户信息")
    @PostMapping("/update")
    public void update() {

    }

    @ApiOperation(value="用户注销")
    @PostMapping("/destroy")
    public void deleteUser() {

    }

}
