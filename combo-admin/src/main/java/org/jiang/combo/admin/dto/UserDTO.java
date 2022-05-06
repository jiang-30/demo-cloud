package org.jiang.combo.admin.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import org.jiang.combo.admin.model.entiry.User;

import javax.validation.constraints.NotNull;

@Data
@Accessors(chain = true)
public class UserDTO {
    @NotNull
    private String username;

    @NotNull
    private String password;

//    public User convertToUser() {
//
//    }
}
