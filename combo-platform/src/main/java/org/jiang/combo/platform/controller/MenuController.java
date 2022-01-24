package org.jiang.combo.platform.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jiang.combo.platform.entity.Menu;
import org.jiang.combo.platform.service.MenuService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
@ApiSort(3)
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Resource
    MenuService menuService;

    @ApiOperation("查询部门列表（树形）")
    @GetMapping("/tree")
    public List<Menu> getTree(Integer pId) {
        List<Menu> tree = menuService.getTree(pId);
        return tree;
    }

    @ApiOperation("查询菜单列表（分页）")
    @GetMapping("/page")
    public IPage<Menu> page(Long current, Long size) {
        IPage<Menu> page =  menuService.page(new Page<>(current, size));
        return page;
    }

    @ApiOperation("查询菜单列表（全部）")
    @GetMapping("/list")
    public List<Menu> list() {
        List<Menu> list =  menuService.list();
        return list;
    }

    @ApiOperation("查询菜单详情")
    @ApiOperationSupport(order = 1)
    @GetMapping("/{id}")
    public Menu role(@PathVariable Integer id) {
        Menu entity = menuService.getById(id);
        return entity;
    }

    @ApiOperation("新增菜单")
    @ApiOperationSupport(order = 1)
    @PostMapping("")
    public boolean  create(Menu entity) {
        boolean b =  menuService.save(entity);
        return b;
    }

    @ApiOperation("更新菜单")
    @ApiOperationSupport(order = 1)
    @PutMapping("")
    public boolean  update(Menu entity) {
        boolean b =  menuService.updateById(entity);
        return b;
    }

    @ApiOperation("删除菜单")
    @ApiOperationSupport(order = 1)
    @DeleteMapping("/{id}")
    public boolean  delete(@PathVariable Integer id) {
        boolean b =  menuService.removeById(id);
        return b;
    }
}

