package org.jiang.combo.admin.service;

import org.jiang.combo.admin.entity.Menu;
import org.jiang.combo.admin.mapper.MenuMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 系统菜单 服务实现类
 * </p>
 *
 * @author combo
 * @since 2022-01-21
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
    @Override
    public List<Menu> getTree(Integer pId) {
        List<Menu> tree = baseMapper.getTree(pId);
        return tree;
    }
}
