package org.jiang.combo.admin.service;

import org.jiang.combo.admin.entity.User;
import org.jiang.combo.admin.mapper.UserMapper;
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
