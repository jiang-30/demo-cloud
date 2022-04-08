package org.jiang.combo.admin.model.dto;

import lombok.Data;
import lombok.ToString;
import org.jiang.combo.admin.model.Role;
import org.jiang.combo.admin.model.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@ToString
public class UserDto extends User {
    private List<Role> roles;
}
