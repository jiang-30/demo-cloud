package org.jiang.combo.admin.service.impl;

import org.jiang.combo.admin.model.Department;
import org.jiang.combo.admin.mapper.DepartmentMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.jiang.combo.admin.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 平台 服务实现类
 * </p>
 *
 * @author combo
 * @since 2022-01-21
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {

    @Override
    public List<Department> getTree(Integer pId) {
        List<Department> tree = baseMapper.getTree(pId);
        return tree;
    }
}
