package org.jiang.combo.platform.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.jiang.combo.platform.entity.User;
import org.jiang.combo.platform.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
