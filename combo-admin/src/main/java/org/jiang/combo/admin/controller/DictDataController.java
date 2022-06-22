package org.jiang.combo.admin.controller;


import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.jiang.combo.admin.model.DictItem;
import org.jiang.combo.admin.service.DictItemService;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 字典项 前端控制器
 * </p>
 *
 * @author combo
 * @since 2022-01-21
 */
@Api(tags = "数据字典")
@ApiSort(40)
@RestController
@RequestMapping("/dict/data")
@RequiredArgsConstructor
public class DictDataController {
    final DictItemService dictItemService;

    @ApiOperation(value = "字典数据列表")
    @GetMapping("/list")
    public DictItem list(@PathVariable Integer id) {
        DictItem entity = dictItemService.getById(id);
        return entity;
    }

    @ApiOperation(value = "字典数据详情")
    @GetMapping("/{id}")
    public DictItem role(@PathVariable Integer id) {
        DictItem entity = dictItemService.getById(id);
        return entity;
    }

    @ApiOperation(value = "新增字典数据")
    @PostMapping("")
    public boolean  create(DictItem entity) {
        boolean b =  dictItemService.save(entity);
        return b;
    }

    @ApiOperation(value = "更新字典数据")
    @PutMapping("")
    public boolean  update(DictItem entity) {
        boolean b =  dictItemService.updateById(entity);
        return b;
    }

    @ApiOperation(value = "删除字典数据")
    @DeleteMapping("/{id}")
    public boolean  delete(@PathVariable Integer id) {
        boolean b =  dictItemService.removeById(id);
        return b;
    }
}

