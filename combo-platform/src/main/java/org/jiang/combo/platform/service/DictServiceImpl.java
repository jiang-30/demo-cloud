package org.jiang.combo.platform.service;

import org.jiang.combo.platform.entity.Dict;
import org.jiang.combo.platform.mapper.DictMapper;
import org.jiang.combo.platform.service.DictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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