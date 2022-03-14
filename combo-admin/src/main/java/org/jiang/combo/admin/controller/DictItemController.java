package org.jiang.combo.admin.controller;


import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jiang.combo.admin.model.DictItem;
import org.jiang.combo.admin.service.DictItemService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 字典项 前端控制器
 * </p>
 *
 * @author combo
 * @since 2022-01-21
 */
@Api(tags = "字典项管理")
@ApiSort(9)
@RestController
@RequestMapping("/dictItem")
public class DictItemController {
    @Resource
    DictItemService dictItemService;

    @ApiOperationSupport(order = 1)
    @ApiOperation("查询字典项详情")
    @GetMapping("/{id}")
    public DictItem role(@PathVariable Integer id) {
        DictItem entity = dictItemService.getById(id);
        return entity;
    }

    @ApiOperationSupport(order = 1)
    @ApiOperation("新增字典项")
    @PostMapping("")
    public boolean  create(DictItem entity) {
        boolean b =  dictItemService.save(entity);
        return b;
    }

    @ApiOperationSupport(order = 1)
    @ApiOperation("更新字典项")
    @PutMapping("")
    public boolean  update(DictItem entity) {
        boolean b =  dictItemService.updateById(entity);
        return b;
    }

    @ApiOperationSupport(order = 1)
    @ApiOperation("删除字典项")
    @DeleteMapping("/{id}")
    public boolean  delete(@PathVariable Integer id) {
        boolean b =  dictItemService.removeById(id);
        return b;
    }
}

