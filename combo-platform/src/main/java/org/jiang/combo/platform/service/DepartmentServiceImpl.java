package org.jiang.combo.platform.service;

import org.jiang.combo.platform.entity.Department;
import org.jiang.combo.platform.mapper.DepartmentMapper;
import org.jiang.combo.platform.service.DepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
