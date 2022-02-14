package org.jiang.combo.admin.service;

import org.jiang.combo.admin.entity.Department;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 平台 服务类
 * </p>
 *
 * @author combo
 * @since 2022-01-21
 */
public interface DepartmentService extends IService<Department> {

    /**
     *
     * @param pId
     * @return
     */
    List<Department> getTree(Integer pId);
}
