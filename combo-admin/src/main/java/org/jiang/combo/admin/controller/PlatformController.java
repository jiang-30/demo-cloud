package org.jiang.combo.admin.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jiang.combo.admin.model.Platform;
import org.jiang.combo.admin.service.PlatformService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 平台 前端控制器
 * </p>
 *
 * @author combo
 * @since 2022-01-21
 */
@Api(tags = "系统平台管理")
@ApiSort(6)
@RestController
@RequestMapping("/platform")
public class PlatformController {

    @Resource
    PlatformService platformService;

    @ApiOperation("查询系统平台（分页）")
    @GetMapping("/page")
    public IPage<Platform> getPage(Integer size, Integer current) {
        IPage page = platformService.page(new Page(current, size));
        return page;
    }

    @ApiOperation("查询系统平台（全部）")
    @GetMapping("/list")
    public List<Platform> getList() {
        List<Platform>  list = platformService.list();
        return list;
    }

    @ApiOperationSupport(order = 1)
    @ApiOperation("查询系统平台详情")
    @GetMapping("/{id}")
    public Platform get(@PathVariable Integer id) {
        Platform entity = platformService.getById(id);
        return entity;
    }

    @ApiOperationSupport(order = 1)
    @ApiOperation("新建系统平台")
    @PostMapping("")
    public boolean create(Platform entity) {
        boolean b = platformService.save(entity);
        return b;
    }

    @ApiOperationSupport(order = 1)
    @ApiOperation("更新系统平台")
    @PutMapping("")
    public boolean update(Platform entity) {
        boolean b = platformService.updateById(entity);
        return b;
    }

    @ApiOperationSupport(order = 1)
    @ApiOperation("删除系统平台")
    @DeleteMapping("/{id")
    public boolean delete(@PathVariable Integer id) {
        boolean b = platformService.removeById(id);
        return b;
    }

}

