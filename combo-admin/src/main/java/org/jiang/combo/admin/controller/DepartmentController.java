package org.jiang.combo.admin.controller;


import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jiang.combo.admin.model.Department;
import org.jiang.combo.admin.service.DepartmentService;
import org.springframework.security.access.prepost.PreAuthorize;
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
@Api(tags="部门管理")
@ApiSort(20)
@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Resource
    DepartmentService departmentService;

    @ApiOperation("查询部门列表（树形）")
    @GetMapping("/tree")
//    @PreAuthorize("hasAuthority('get:department/tree')")
    public List<Department> getTree() {
        List<Department> tree = departmentService.getTree();
        return tree;
    }


    @ApiOperation("查询部门详情")
    @GetMapping("/{id}")
    public Department get(@PathVariable Integer id) {
        Department entity=  departmentService.getById(id);
        return entity;
    }

    @ApiOperation("新建部门")
    @PostMapping("")
    public boolean create(@RequestBody Department entity) {
        boolean b = departmentService.save(entity);
        return b;
    }

    @ApiOperation("修改部门")
    @PutMapping("")
    public boolean update(Department entity) {
        boolean b = departmentService.updateById(entity);
        return b;
    }

//    @ApiOperationSupport(order = 1)
//    @ApiOperation("删除部门")
//    @DeleteMapping("/{id}")
//    public boolean delete(@PathVariable Integer id) {
//        boolean b = departmentService.removeById(id);
//        return b;
//    }

}

