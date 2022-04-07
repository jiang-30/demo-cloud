package org.jiang.combo.admin.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.jiang.combo.admin.common.utils.JwtUtil;
import org.jiang.combo.admin.model.User;
import org.jiang.combo.admin.model.dto.AuthDto;
import org.jiang.combo.admin.model.dto.UserLoginDto;
import org.jiang.combo.admin.model.dto.UserRegisterDto;
import org.jiang.combo.admin.service.UserService;
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
    private final JwtUtil jwtUtil;

    @GetMapping("/test")
    public List<User> test() {
        List<User> list = userService.list();
        return list;
    }

    /**
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
     */
    @ApiOperationSupport(order = 2)
    @ApiOperation("用户登录")
    @PostMapping("/login")
    public AuthDto login(@Valid @RequestBody UserLoginDto userLogin) throws Exception {
        AuthDto auth = userService.getAuthByUsernameAndPassword(userLogin.getUsername(), userLogin.getPassword());

        return auth;
    }

    @ApiOperationSupport(order = 3)
    @ApiOperation("刷新token")
    @PostMapping("/refresh")
    public void refresh() {

    }

    @ApiOperationSupport(order = 4)
    @ApiOperation("验证token有效性")
    @PostMapping("/check")
    public void check() {

    }

    @ApiOperationSupport(order = 5)
    @ApiOperation("查询用户信息")
    @PostMapping("/profile")
    public void profile() {

    }

}
