package org.jiang.combo.admin.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.jiang.combo.admin.model.Dict;
import org.jiang.combo.admin.service.DictService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 字典 前端控制器
 * </p>
 *
 * @author combo
 * @since 2022-01-21
 */
@Api(tags = "数据字典")
@RestController
@RequestMapping("/dict/type")
@RequiredArgsConstructor
public class DictTypeController {

    final DictService dictService;

    @ApiOperation(value = "查询字典列表（全部）", notes = "全部类型及类型数据")
    @GetMapping("/all")
    public List<Dict> list() {
        List<Dict> list =  dictService.list();
        return list;
    }

    @ApiOperation(value = "查询字典类型列表（分页）")
    @GetMapping("/page")
    public IPage<Dict> page(Long current, Long size) {
        IPage<Dict> page =  dictService.page(new Page<>(current, size));
        return page;
    }

    @ApiOperation(value = "查询字典类型详情")
    @GetMapping("/{id}")
    public Dict entity(@PathVariable Integer id) {
        Dict entity = dictService.getById(id);
        return entity;
    }

    @ApiOperation(value = "新增字典类型")
    @PostMapping("")
    public boolean  create(Dict entity) {
        boolean b =  dictService.save(entity);
        return b;
    }

    @ApiOperation(value = "更新字典类型")
    @PutMapping("")
    public boolean  update(Dict entity) {
        boolean b =  dictService.updateById(entity);
        return b;
    }

    @ApiOperation(value = "删除字典类型", notes = "字典类型，并删除当前类型下的字典数据")
    @DeleteMapping("/{id}")
    public boolean  delete(@PathVariable Integer id) {
        boolean b =  dictService.removeById(id);
        return b;
    }
}

