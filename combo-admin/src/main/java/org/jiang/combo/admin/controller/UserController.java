package org.jiang.combo.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jiang.combo.admin.entity.User;
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
@ApiSort(1)
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    UserService userService;

    @ApiOperation("查询用户列表（分页）")
    @GetMapping("/page")
    public IPage<User> page(Long current, Long size) {
        IPage<User> page =  userService.page(new Page<>(current, size));
        return page;
    }

    @ApiOperation("查询用户列表（全部）")
    @GetMapping("/list")
    public List<User> list() {
        List<User> list =  userService.list();
        return list;
    }

    @ApiOperation("查询用户详情")
    @ApiOperationSupport(order = 1)
    @GetMapping("/{id}")
    public User role(@PathVariable Integer id) {
        User entity = userService.getById(id);
        return entity;
    }

    @ApiOperation("新增用户")
    @ApiOperationSupport(order = 1)
    @PostMapping("")
    public boolean  create(User entity) {
        boolean b =  userService.save(entity);
        return b;
    }

    @ApiOperation("更新用户")
    @ApiOperationSupport(order = 1)
    @PutMapping("")
    public boolean  update(User entity) {
        boolean b =  userService.updateById(entity);
        return b;
    }

    @ApiOperation("删除用户")
    @ApiOperationSupport(order = 1)
    @DeleteMapping("/{id}")
    public boolean  delete(@PathVariable Integer id) {
        boolean b =  userService.removeById(id);
        return b;
    }
}

