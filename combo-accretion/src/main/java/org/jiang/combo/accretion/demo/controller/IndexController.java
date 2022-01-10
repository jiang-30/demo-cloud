package org.jiang.combo.accretion.demo.controller;

import org.jiang.combo.accretion.demo.entity.User;
import org.jiang.combo.accretion.demo.mapper.UserMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/demo")
public class IndexController {

    @GetMapping("")
    public String index() {
        return  "hello demo index";
    }

    @Resource
    UserMapper userMapper;

    @GetMapping("/{id}")
    public User getUser(@PathVariable long id) {
        User user =  userMapper.selectById((int) id);

        return  user;
    }
}
