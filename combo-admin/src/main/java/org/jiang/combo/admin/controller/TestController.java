package org.jiang.combo.admin.controller;

import org.jiang.combo.admin.util.RedisOperator;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    RedisOperator redisOperator;

    @GetMapping("/login")
    public String login() {
        return "public/login.html";
    }

    @GetMapping("/index")
    public String index() {
        System.out.println(SecurityContextHolder.getContext().getAuthentication());
        return "public/index.html";
    }

    @GetMapping("/create")
    public String create() {
        return "public/create.html";
    }

    @GetMapping("/redis")
    public String redis() {
        String str = redisOperator.get("aaa");
        return str;
    }

    @GetMapping("")
    public String test() {
        return  "test ok;";
    }

    @GetMapping("/int")
    public int testInt() {
        return  112222;
    }

    @GetMapping("/fail")
    public int testFail() {
        throw new RuntimeException("自定义异常");
    }
}
