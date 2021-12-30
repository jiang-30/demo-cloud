package com.example.platform.dao;

import com.example.platform.entity.User;

public interface UserDao {


    User selectById(Integer id);
}
