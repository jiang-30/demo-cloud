package org.jiang.combo.admin.controller;

import org.jiang.combo.admin.common.utils.RedisOperator;
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
        return "static/login.html";
    }

    @GetMapping("/index")
    public String index() {
        System.out.println(SecurityContextHolder.getContext().getAuthentication());
        return "templates/index.html";
    }

    @GetMapping("/create")
    public String create() {
        return "static/create.html";
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
