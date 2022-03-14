package org.jiang.combo.accretion.demo.controller;

import org.jiang.combo.accretion.demo.entity.User;
import org.jiang.combo.accretion.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/idex")
    public String index() {
        return  "hello demo index";
    }

//    @Resource
//    UserMapper userMapper;

//    @GetMapping("/{id}")
//    public List<User>  getUser(@PathVariable long id) {
//        List<User> userList =  userMapper.selectList(null);
//
//        return  userList;
//    }
}
