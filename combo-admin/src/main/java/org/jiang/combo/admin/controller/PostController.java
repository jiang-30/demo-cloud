package org.jiang.combo.admin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.jiang.combo.admin.model.entiry.Department;
import org.jiang.combo.admin.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "岗位管理")
@RestController
@RequestMapping("/org")
@RequiredArgsConstructor
public class PostController {


    final DepartmentService departmentService;

    @ApiOperation(value = "查询岗位列表（全部）")
    @GetMapping("/list")
    public List<Department> getTree() {
        List<Department> tree = departmentService.getTree();
        return tree;
    }

    @ApiOperation(value = "查询岗位详情")
    @GetMapping("/{id}")
    public Department get(@PathVariable Integer id) {
        Department entity=  departmentService.getById(id);
        return entity;
    }

    @ApiOperation(value = "新建岗位")
    @PostMapping("")
    public boolean create(@RequestBody Department entity) {
        boolean b = departmentService.save(entity);
        return b;
    }

    @ApiOperation(value = "修改岗位")
    @PutMapping("")
    public boolean update(Department entity) {
        boolean b = departmentService.updateById(entity);
        return b;
    }

    @ApiOperation(value = "删除岗位")
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        boolean b = departmentService.removeById(id);
        return b;
    }
}
