package org.jiang.combo.platform.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Delete;
import org.jiang.combo.platform.entity.Menu;
import org.jiang.combo.platform.service.MenuService;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 作者
 * @since 2022-01-12
 */
@Api(tags="菜单管理")
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Resource
    MenuService menuService;

    @ApiOperation("查询菜单树结构")
    @GetMapping("/tree")
    public String tree(Integer id){
//        Menu menu = menuService.getById(id);
//        return menu;

        return "'tree'";
    }

    @ApiOperation("通过id查询菜单详情")
    @GetMapping("/{id}")
    public Menu select(@PathVariable Integer id){
        Menu menu = menuService.getById(id);
        return menu;
    }

    @ApiOperation("新建菜单")
    @PostMapping("")
    public void create(Menu menu){
        boolean b = menuService.save(menu);
    }

    @ApiOperation("通过id更新菜单")
    @PutMapping("")
    public void update(Menu menu){
        boolean b = menuService.updateById(menu);
    }

    @ApiOperation("通过id删除菜单")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        boolean b = menuService.removeById(id);
    }
}

