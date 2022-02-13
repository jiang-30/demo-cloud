package org.jiang.combo.platform.controller;

import org.jiang.combo.platform.dto.UserDto;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/authorize")
public class AuthorizeController {

    @PostMapping("/register")
    public UserDto register(@Valid @RequestBody UserDto userDto) {

        return userDto;
    }

    @GetMapping("/test")
    public UserDto test() {
        throw new RuntimeException("sadfjlk");
    }
}
