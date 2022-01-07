package com.example.platform.controller;

import com.example.platform.mapper.UserMapper;
import com.example.platform.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {
    //    @Resource
//    private RestTemplate restTemplate;
//
//    @Value("${config.info}")
//    String configInfo;
//
//    @GetMapping("/abc")
//    public String index(){
//        String str = restTemplate.getForObject("http://auth-server/test", String.class);
//        return configInfo + ";" + "'platform'" + str;
//    }

    @Resource
    UserMapper userMapper;

    @GetMapping("/{id}")
    public User getUser(@PathVariable long id) {
      User user =  userMapper.selectById((int) id);

      return  user;
    }
}
