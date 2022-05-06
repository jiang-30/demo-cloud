package org.jiang.combo.admin.service;

import org.jiang.combo.admin.model.entiry.User;
import org.jiang.combo.admin.model.bo.SecurityUserDetails;
import org.jiang.combo.admin.model.dto.AuthDto;

public interface AuthService {
    User getByUsername(String username);

    /**
     * 创建用户认证信息通过用户名和密码
     *
     * @param username
     * @param password
     */
    AuthDto createAuthorization(String username, String password) throws Exception;

    /**
     *
     */
//    void attemptAuthorizationByPassword(String username, String password);
//    void attemptAuthorizationByCode(String code, '');

    /**
     * 清除用户认证信息
     */
    void deleteAuthorization();

    AuthDto getAuthByUsernameAndPassword(String username, String password) throws Exception;
//    void getMenu();
//    void getPermission();
//    void getRole();

    SecurityUserDetails getSecurityUserDetails(String username) throws Exception;
}
