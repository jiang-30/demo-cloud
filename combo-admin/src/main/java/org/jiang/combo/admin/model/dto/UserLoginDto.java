package org.jiang.combo.admin.model.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserLoginDto {
    @NotNull
    private String username;

    @NotNull
    private String password;
}
