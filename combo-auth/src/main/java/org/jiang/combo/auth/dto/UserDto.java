package org.jiang.combo.auth.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserDto {
    @NotNull
    @NotBlank
    @Size(min = 2, max = 10, message = "用户名长度需要再2到10个字符之间")
    private String username;
    @NotNull
    @Size(min = 2, max = 10, message = "密码长度需要再2到10个字符之间")
    private String password;
    private String rePassword;
    @Email
    private String email;
}
