package org.jiang.combo.admin.service;

import org.jiang.combo.admin.model.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 系统菜单 服务类
 * </p>
 *
 * @author combo
 * @since 2022-01-21
 */
public interface MenuService extends IService<Menu> {
    List<Menu> getTree(Integer pId);
}
