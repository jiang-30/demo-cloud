package org.jiang.combo.admin.mapper;

import org.apache.ibatis.annotations.Param;
import org.jiang.combo.admin.model.Dict;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 字典 Mapper 接口
 * </p>
 *
 * @author combo
 * @since 2022-01-21
 */
public interface DictMapper extends BaseMapper<Dict> {
    Dict getItems(@Param("id") Integer id);

    List<Dict> getListItems();
}
