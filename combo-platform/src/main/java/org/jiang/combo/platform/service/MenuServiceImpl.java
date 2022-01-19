package org.jiang.combo.platform.service;

import org.jiang.combo.platform.entity.Menu;
import org.jiang.combo.platform.mapper.MenuMapper;
import org.jiang.combo.platform.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 作者
 * @since 2022-01-12
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
    @Override
    public Menu getTree(Integer id) {
        baseMapper.getTree(id);
        return null;
    }
}
