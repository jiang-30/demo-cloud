package org.jiang.combo.admin.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.jiang.combo.admin.model.Platform;
import org.jiang.combo.admin.service.PlatformService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 平台 前端控制器
 * </p>
 *
 * @author combo
 * @since 2022-01-21
 */
@Api(tags = "终端管理")
@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    final PlatformService platformService;

    @ApiOperation(value = "查询终端（分页）")
    @GetMapping("/page")
    public IPage<Platform> getPage(Integer size, Integer current) {
        IPage page = platformService.page(new Page(current, size));
        return page;
    }

    @ApiOperation(value = "查询终端（全部）")
    @GetMapping("/list")
    public List<Platform> getList() {
        List<Platform> list = platformService.list();
        return list;
    }

    @ApiOperation(value = "查询终端详情")
    @GetMapping("/{id}")
    public Platform get(@PathVariable Integer id) {
        Platform entity = platformService.getById(id);
        return entity;
    }

    @ApiOperation(value = "新建终端")
    @PostMapping("")
    public boolean create(Platform entity) {
        boolean b = platformService.save(entity);
        return b;
    }

    @ApiOperation(value = "更新终端")
    @PutMapping("")
    public boolean update(Platform entity) {
        boolean b = platformService.updateById(entity);
        return b;
    }

    @ApiOperation(value = "删除终端")
    @DeleteMapping("/{id")
    public boolean delete(@PathVariable Integer id) {
        boolean b = platformService.removeById(id);
        return b;
    }

}

