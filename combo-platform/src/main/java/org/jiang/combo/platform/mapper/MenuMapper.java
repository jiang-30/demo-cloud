package org.jiang.combo.platform.mapper;

import org.jiang.combo.platform.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 作者
 * @since 2022-01-12
 */
public interface MenuMapper extends BaseMapper<Menu> {
    Menu getTree(Integer id);
}
