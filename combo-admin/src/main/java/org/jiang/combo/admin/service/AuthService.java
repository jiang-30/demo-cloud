package org.jiang.combo.admin.service;

import org.jiang.combo.admin.model.User;
import org.jiang.combo.admin.model.bo.SecurityUserDetails;
import org.jiang.combo.admin.model.dto.AuthDto;

public interface AuthService {
    User getByUsername(String username);

    AuthDto getAuthByUsernameAndPassword(String username, String password) throws Exception;
//    void getMenu();
//    void getPermission();
//    void getRole();

    SecurityUserDetails getSecurityUserDetails(String username) throws Exception;
}
