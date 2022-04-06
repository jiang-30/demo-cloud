package org.jiang.combo.admin.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jiang.combo.admin.model.dto.UserDto;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 注册
 * 登录
 * 登出
 */
@Api(tags="认证授权")
@ApiSort(1)
@RestController
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/test")
    public String ok() {
        return "rest request ok";
    }

    /**
     * 1.检测数据的唯一性
     * 2. UserDto  -> User, 默认角色
     * @param userDto
     * @return
     */
    @ApiOperationSupport(order = 1)
    @ApiOperation("用户注册")
    @PostMapping("/register")
    public UserDto register(@Valid @RequestBody UserDto userDto) {
//        1. 用户名是否存在
//        2. 邮箱是否存在
//        3. 手机是否存在
        return userDto;
    }

    @ApiOperationSupport(order = 2)
    @ApiOperation("用户登录")
    @PostMapping("/login")
    public void login() {

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
