package org.jiang.combo.admin.service;

import org.jiang.combo.admin.model.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 登录用户信息表 服务类
 * </p>
 *
 * @author combo
 * @since 2022-01-21
 */
public interface UserService extends IService<User> {

    User getByUsername(String username);
}
