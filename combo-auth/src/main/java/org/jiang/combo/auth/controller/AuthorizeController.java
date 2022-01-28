package org.jiang.combo.auth.controller;

import org.jiang.combo.auth.dto.UserDto;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/authorize")
@RestController
public class AuthorizeController {

    @PostMapping("/register")
    public UserDto register(@Valid @RequestBody UserDto userDto) {

        return userDto;
    }

    @GetMapping("/test")
    public UserDto test( @RequestBody UserDto userDto) {
        throw new RuntimeException("sadfjlk");
    }
}
