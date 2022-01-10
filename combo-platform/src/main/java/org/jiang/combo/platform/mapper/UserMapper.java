package org.jiang.combo.platform.mapper;

import org.jiang.combo.platform.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User selectById(Integer id);
}
