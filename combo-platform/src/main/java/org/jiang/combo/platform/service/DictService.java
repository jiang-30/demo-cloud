package org.jiang.combo.platform.service;

import org.jiang.combo.platform.entity.Dict;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 字典 服务类
 * </p>
 *
 * @author combo
 * @since 2022-01-21
 */
public interface DictService extends IService<Dict> {
    Dict getItems(Integer id);

    List<Dict> getListItems();
}
