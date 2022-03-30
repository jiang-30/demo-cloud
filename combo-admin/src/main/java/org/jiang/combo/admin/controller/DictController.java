package org.jiang.combo.admin.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jiang.combo.admin.model.Dict;
import org.jiang.combo.admin.service.DictService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 字典 前端控制器
 * </p>
 *
 * @author combo
 * @since 2022-01-21
 */
@Api(tags = "字典管理")
@ApiSort(8)
@RestController
@RequestMapping("/dict")
public class DictController {
    @Resource
    DictService dictService;

    @ApiOperation("查询字典列表（分页）")
    @GetMapping("/page")
    public IPage<Dict> page(Long current, Long size) {
        IPage<Dict> page =  dictService.page(new Page<>(current, size));
        return page;
    }

    @ApiOperation("查询字典列表（全部）")
    @GetMapping("/list")
    public List<Dict> list() {
        List<Dict> list =  dictService.list();
        return list;
    }

    @ApiOperation("查询字典列表（全部并含字典项）")
    @GetMapping("/list/items")
    public List<Dict> listAndItems() {
        List<Dict> list = dictService.getListItems();
        return list;
    }

    @ApiOperation("查询字典详情（含字典项）")
    @GetMapping("/items/{id}")
    public Dict entityAndItems(@PathVariable Integer id) {
        Dict entity = dictService.getItems(id);
        return entity;
    }

    @ApiOperationSupport(order = 1)
    @ApiOperation("查询字典详情")
    @GetMapping("/{id}")
    public Dict entity(@PathVariable Integer id) {
        Dict entity = dictService.getById(id);
        return entity;
    }

    @ApiOperationSupport(order = 1)
    @ApiOperation("新增字典")
    @PostMapping("")
    public boolean  create(Dict entity) {
        boolean b =  dictService.save(entity);
        return b;
    }

    @ApiOperationSupport(order = 1)
    @ApiOperation("更新字典")
    @PutMapping("")
    public boolean  update(Dict entity) {
        boolean b =  dictService.updateById(entity);
        return b;
    }

    @ApiOperationSupport(order = 1)
    @ApiOperation("删除字典")
    @DeleteMapping("/{id}")
    public boolean  delete(@PathVariable Integer id) {
        boolean b =  dictService.removeById(id);
        return b;
    }
}

