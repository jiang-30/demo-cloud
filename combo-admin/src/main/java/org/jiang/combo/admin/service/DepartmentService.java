package org.jiang.combo.admin.service;

import org.jiang.combo.admin.model.entiry.Department;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author jiangbo
* @description 针对表【s_department(组织机构)】的数据库操作Service
* @createDate 2022-04-20 21:52:35
*/
public interface DepartmentService extends IService<Department> {

    /**
     * 查询树形结构
     *
     * @return
     */
    List<Department> getTree();
}
