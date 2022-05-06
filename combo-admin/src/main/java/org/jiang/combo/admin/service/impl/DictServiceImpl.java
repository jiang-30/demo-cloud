package org.jiang.combo.admin.service.impl;

import org.jiang.combo.admin.model.entiry.Dict;
import org.jiang.combo.admin.mapper.DictMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.jiang.combo.admin.service.DictService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 字典 服务实现类
 * </p>
 *
 * @author combo
 * @since 2022-01-21
 */
@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements DictService {
    @Override
    public Dict getItems(Integer id) {
        return baseMapper.getItems(id);
    }

    @Override
    public List<Dict> getListItems() {
        return baseMapper.getListItems();
    }
}
