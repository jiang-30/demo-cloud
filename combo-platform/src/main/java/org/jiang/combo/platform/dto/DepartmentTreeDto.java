package org.jiang.combo.platform.dto;

import org.jiang.combo.platform.entity.Department;

import java.util.List;

public class DepartmentTreeDto  extends Department {
    List<DepartmentTreeDto> children;
}
