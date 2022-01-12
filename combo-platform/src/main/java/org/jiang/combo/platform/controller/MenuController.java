package org.jiang.combo.platform.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 作者
 * @since 2022-01-12
 */
@Api(tags="用户管理")
@RestController
@RequestMapping("/menu")
public class MenuController {


    @ApiOperation("用户列表")
    @GetMapping("/{id}")
    public void select(){

    }

}

