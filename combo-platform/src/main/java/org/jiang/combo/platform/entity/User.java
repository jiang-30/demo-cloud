package org.jiang.combo.platform.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("t_user")
@Data
public class User {
    @TableId(type = IdType.ASSIGN_UUID)
    private int id;
    private String username;
    private String email;
    private String password;
}
