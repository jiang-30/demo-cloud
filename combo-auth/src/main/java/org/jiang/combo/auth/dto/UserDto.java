package org.jiang.combo.auth.dto;

import lombok.Data;
import org.jiang.combo.common.annotation.ValidEmail;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserDto {
    @NotNull
    @NotBlank
    @Size(min = 2, max = 10, message = "用户名长度需要再2到10个字符之间")
    private String username;
    @Size(min = 2, max = 10, message = "密码长度需要再2到10个字符之间")
    private String password;
    private String rePassword;
    @ValidEmail()
    private String email;
}
