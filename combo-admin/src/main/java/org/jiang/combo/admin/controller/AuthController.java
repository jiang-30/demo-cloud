package org.jiang.combo.admin.controller;

import org.jiang.combo.admin.dto.UserDto;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 注册
 * 登录
 * 登出
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/ok")
    public String ok() {
        return "rest request ok";
    }

    @GetMapping("/test")
    public UserDto test() {
        throw new RuntimeException("sadfjlk");
    }

    @PostMapping("/register")
    public UserDto register(@Valid @RequestBody UserDto userDto) {

        return userDto;
    }

}
