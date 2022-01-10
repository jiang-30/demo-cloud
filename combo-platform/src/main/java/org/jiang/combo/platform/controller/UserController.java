package org.jiang.combo.platform.controller;

import org.jiang.combo.platform.entity.User;
import org.jiang.combo.platform.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    UserService userService;

    @GetMapping("/list")
    public List<User>  getUser() {
      List<User> userList =  userService.list();

      return  userList;
    }
}
