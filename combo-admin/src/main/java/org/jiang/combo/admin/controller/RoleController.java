package org.jiang.combo.admin.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.jiang.combo.admin.model.Role;
import org.jiang.combo.admin.model.dto.RoleMenuDto;
import org.jiang.combo.admin.service.MenuService;
import org.jiang.combo.admin.service.RoleService;
import org.springframework.web.bind.annotation.*;

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
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;
    private final MenuService menuService;


    @ApiOperation(value = "查询角色列表（分页）")
    @GetMapping("/page")
    public IPage<Role> page(Long current, Long size) {
        IPage<Role> page =  roleService.page(new Page<>(current, size));
        return page;
    }

    @ApiOperation(value = "查询角色列表（全部）")
    @GetMapping("/list")
    public List<Role> list() {
        List<Role> list =  roleService.list();
        return list;
    }

    @ApiOperation(value = "查询角色详情")
    @GetMapping("/{id}")
    public Role role(@PathVariable Integer id) {
        Role entity = roleService.getById(id);
        return entity;
    }

    @ApiOperation(value = "为角色分配权限")
    @PostMapping("/menu")
    public Boolean setMenu(@RequestBody RoleMenuDto roleMenu) {
        System.out.println(roleMenu);
        menuService.saveMenuForRole(roleMenu.getRoleId(), roleMenu.getMenuIds());
        return false;
    }

    @ApiOperation(value = "新增角色")
    @PostMapping("")
    public boolean  create( Role entity) {
        boolean b =  roleService.save(entity);
        return b;
    }

    @ApiOperation(value = "更新角色")
    @PutMapping("")
    public boolean  update(Role entity) {
        boolean b =  roleService.updateById(entity);
        return b;
    }

    @ApiOperation(value = "删除角色")
    @DeleteMapping("/{id}")
    public boolean  delete(@PathVariable Integer id) {
        boolean b =  roleService.removeById(id);
        return b;
    }

}

