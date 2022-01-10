package org.jiang.combo.accretion.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.jiang.combo.accretion.demo.entity.User;

@Mapper
public interface UserMapper {
    User selectById(Integer id);
}
