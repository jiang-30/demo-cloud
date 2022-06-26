package org.jiang.combo.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jiang.combo.admin.model.User;
import org.jiang.combo.admin.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 登录用户信息表 前端控制器
 * </p>
 *
 * @author combo
 * @since 2022-01-21
 */
@Api(tags = "用户管理")
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    UserService userService;

    @ApiOperation(value = "查询用户列表（分页）")
    @GetMapping("/page")
    public IPage<User> page(Long current, Long size) {
        IPage<User> page =  userService.page(new Page<>(current, size));
        return page;
    }

    @ApiOperation(value = "查询用户列表（全部）")
    @GetMapping("/list")
    public List<User> list() {
        List<User> list =  userService.list();
        return list;
    }

    @ApiOperation(value = "查询用户详情")
    @GetMapping("/{id}")
    public User role(@PathVariable Integer id) {
        User entity = userService.getById(id);
        return entity;
    }

    @ApiOperation(value = "新增用户")
    @PostMapping("")
    public boolean  create(User entity) {
        boolean b =  userService.save(entity);
        return b;
    }

    @ApiOperation(value = "更新用户")
    @PutMapping("")
    public boolean  update(User entity) {
        boolean b =  userService.updateById(entity);
        return b;
    }

    @ApiOperation(value = "删除用户")
    @DeleteMapping("/{id}")
    public boolean  delete(@PathVariable Integer id) {
        boolean b =  userService.removeById(id);
        return b;
    }
}

