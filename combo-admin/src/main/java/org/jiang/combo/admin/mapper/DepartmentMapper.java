package org.jiang.combo.admin.mapper;

import org.apache.ibatis.annotations.Param;
import org.jiang.combo.admin.model.Department;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 平台 Mapper 接口
 * </p>
 *
 * @author combo
 * @since 2022-01-21
 */
public interface DepartmentMapper extends BaseMapper<Department> {

    List<Department> getTree(@Param("pId") Integer pId);

    List<Department> selectByNameTrueOrderByUpdatedTime();

}
