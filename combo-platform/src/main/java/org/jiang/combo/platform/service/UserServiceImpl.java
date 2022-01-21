package org.jiang.combo.platform.service;

import org.jiang.combo.platform.entity.User;
import org.jiang.combo.platform.mapper.UserMapper;
import org.jiang.combo.platform.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 登录用户信息表 服务实现类
 * </p>
 *
 * @author combo
 * @since 2022-01-21
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
