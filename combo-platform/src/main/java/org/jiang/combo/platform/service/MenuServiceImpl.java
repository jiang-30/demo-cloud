package org.jiang.combo.platform.service;

import org.jiang.combo.platform.entity.Menu;
import org.jiang.combo.platform.mapper.MenuMapper;
import org.jiang.combo.platform.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
