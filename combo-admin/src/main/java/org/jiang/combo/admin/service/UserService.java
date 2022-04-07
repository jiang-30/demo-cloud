package org.jiang.combo.admin.service;

import org.jiang.combo.admin.model.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.jiang.combo.admin.model.bo.SecurityUserDetails;
import org.jiang.combo.admin.model.dto.AuthDto;

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

    boolean isExistUsername(String username);

    AuthDto getAuthByUsernameAndPassword(String username, String password) throws Exception;

    SecurityUserDetails getSecurityUserDetailsById(Long id) throws Exception;
}
