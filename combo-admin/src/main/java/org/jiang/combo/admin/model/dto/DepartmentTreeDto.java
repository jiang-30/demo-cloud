package org.jiang.combo.admin.model.dto;

import org.jiang.combo.admin.model.Department;

import java.util.List;

public class DepartmentTreeDto  extends Department {
    List<DepartmentTreeDto> children;
}
