package org.jiang.combo.admin.mapper;

import org.apache.ibatis.annotations.Param;
import org.jiang.combo.admin.model.entiry.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 登录用户信息表 Mapper 接口
 * </p>
 *
 * @author combo
 * @since 2022-01-21
 */
public interface UserMapper extends BaseMapper<User> {
    User getUser(@Param("id") Integer id);

    User getProfile(@Param("id") Integer id);
}
