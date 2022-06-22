package org.jiang.combo.admin.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

public class LoginDto {
    @Data
    @Accessors(chain = true)
    public static class UserDTO {
        @NotNull
        private String username;

        @NotNull
        private String password;

    //    public User convertToUser() {
    //
    //    }
    }
}
