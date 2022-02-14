package org.jiang.combo.admin.dto;

import org.jiang.combo.admin.entity.Department;

import java.util.List;

public class DepartmentTreeDto  extends Department {
    List<DepartmentTreeDto> children;
}
