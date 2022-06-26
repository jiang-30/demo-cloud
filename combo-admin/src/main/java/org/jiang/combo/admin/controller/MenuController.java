package org.jiang.combo.admin.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.jiang.combo.admin.model.Menu;
import org.jiang.combo.admin.service.MenuService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 系统菜单 前端控制器
 * </p>
 *
 * @author combo
 * @since 2022-01-21
 */
@Api(tags = "菜单管理")
@RestController
@RequestMapping("/menu")
@RequiredArgsConstructor
public class MenuController {

    final MenuService menuService;

    @ApiOperation(value="查询可用权限（树形）", notes = "查询可为角色分配的权限")
    @GetMapping("/authtree")
    public List<Menu> getTreeEnabled(Integer pId) {
        List<Menu> tree = menuService.getTreeEnabled(pId);
        return tree;
    }

    @ApiOperation(value = "查询部门列表（树形）")
    @GetMapping("/tree")
    public List<Menu> tree(Integer pId) {
        List<Menu> tree = menuService.getTree(pId);
        return tree;
    }

    @ApiOperation(value = "查询菜单列表（全部）")
    @GetMapping("/list")
    public List<Menu> list() {
        List<Menu> list =  menuService.list();
        return list;
    }

    @ApiOperation(value = "查询菜单详情")
    @GetMapping("/{id}")
    public Menu detail(@PathVariable Integer id) {
        Menu entity = menuService.getById(id);
        return entity;
    }

    @ApiOperation(value = "新增菜单")
    @PostMapping("")
    public boolean  create(Menu entity) {
        boolean b =  menuService.save(entity);
        return b;
    }

    @ApiOperation(value = "更新菜单")
    @PutMapping("")
    public boolean  update(Menu entity) {
        boolean b =  menuService.updateById(entity);
        return b;
    }

    @ApiOperation(value = "删除菜单")
    @DeleteMapping("/{id}")
    public boolean  delete(@PathVariable Integer id) {
        boolean b =  menuService.removeById(id);
        return b;
    }
}

