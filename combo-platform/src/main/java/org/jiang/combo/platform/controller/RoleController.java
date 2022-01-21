package org.jiang.combo.platform.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.*;
import org.jiang.combo.platform.entity.Role;
import org.jiang.combo.platform.service.RoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 角色 前端控制器
 * </p>
 *
 * @author combo
 * @since 2022-01-21
 */
@Api(tags="角色管理")
@RestController
@RequestMapping("/role")
public class RoleController {

    @Resource
    RoleService roleService;

    @ApiOperation("查询角色列表(分页)")
    @GetMapping("/page")
    public IPage<Role> page(Long current, Long size) {
        IPage<Role> rolePage =  roleService.page(new Page<>(current, size));
        return rolePage;
    }

    @ApiOperation("查询角色列表")
    @GetMapping("")
    public List<Role> list() {
        List<Role> roleList =  roleService.list();
        return roleList;
    }

    @ApiOperation("查询角色详情")
    @GetMapping("/{id}")
    public Role role(@PathVariable Integer id) {
        Role role = roleService.getById(id);
        return role;
    }

    @ApiOperation("新增角色")
    @PostMapping("")
    public boolean  create( Role role) {
        boolean res =  roleService.save(role);
        return res;
    }

    @ApiOperation("更新角色")
    @PutMapping("")
    public boolean  update(Role role) {
        boolean res =  roleService.updateById(role);
        return res;
    }

    @ApiOperation("删除角色")
    @DeleteMapping("/{id}")
    public boolean  delete(@PathVariable Integer id) {
        boolean res =  roleService.removeById(id);
        return res;
    }

}

