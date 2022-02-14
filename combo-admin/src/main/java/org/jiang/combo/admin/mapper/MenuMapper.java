package org.jiang.combo.admin.mapper;

import org.apache.ibatis.annotations.Param;
import org.jiang.combo.admin.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 系统菜单 Mapper 接口
 * </p>
 *
 * @author combo
 * @since 2022-01-21
 */
public interface MenuMapper extends BaseMapper<Menu> {
    List<Menu> getTree(@Param("pId") Integer pId);
}
