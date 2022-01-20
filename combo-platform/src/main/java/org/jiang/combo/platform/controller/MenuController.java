package org.jiang.combo.platform.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.jiang.combo.platform.entity.Menu;
import org.jiang.combo.platform.service.MenuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 作者
 * @since 2022-01-20
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Resource
    MenuService menuService;

    @GetMapping("")
    public Menu get(){
        Menu menu = menuService.getById(1);

        return menu;
    }
    @GetMapping("/page")
    public Page<Menu> count(){
        Page<Menu> count = menuService.page(new Page<Menu>(1, 2));

        return count;
    }

}

