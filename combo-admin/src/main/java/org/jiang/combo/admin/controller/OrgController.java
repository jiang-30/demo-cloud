package org.jiang.combo.admin.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.jiang.combo.admin.model.Department;
import org.jiang.combo.admin.service.DepartmentService;
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

@Api(tags="组织管理")
@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class OrgController {

    final DepartmentService departmentService;


    @ApiOperation(value = "查询组织列表（树形）")
    @GetMapping("/tree")
    public List<Department> getTree() {
        List<Department> tree = departmentService.getTree();
        return tree;
    }

    @ApiOperation(value = "查询组织详情")
    @GetMapping("/{id}")
    public Department get(@PathVariable Integer id) {
        Department entity=  departmentService.getById(id);
        return entity;
    }

    @ApiOperation(value = "新建组织")
    @PostMapping("")
    public boolean create(@RequestBody Department entity) {
        boolean b = departmentService.save(entity);
        return b;
    }

    @ApiOperation(value = "修改组织")
    @PutMapping("")
    public boolean update(Department entity) {
        boolean b = departmentService.updateById(entity);
        return b;
    }

    @ApiOperation(value = "删除组织")
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        boolean b = departmentService.removeById(id);
        return b;
    }

}

