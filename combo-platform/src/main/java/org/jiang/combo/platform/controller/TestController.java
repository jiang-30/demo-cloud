package org.jiang.combo.platform.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

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
