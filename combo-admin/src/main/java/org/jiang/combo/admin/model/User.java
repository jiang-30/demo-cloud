package org.jiang.combo.admin.model;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 登录用户信息表
 * </p>
 *
 * @author combo
 * @since 2022-01-21
 */

@ApiModel(value = "User对象", description = "登录用户信息表")
@TableName("s_user")
@Getter
@Setter
@ToString
public class User {

    @ApiModelProperty("主键id")
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private Integer id;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "created_time", insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER)
    private LocalDateTime createdTime;

    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "updated_time", insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER)
    private LocalDateTime updatedTime;

    @ApiModelProperty("创建人")
    @TableField(value = "created_by", fill = FieldFill.INSERT)
    private Integer createdBy;

    @ApiModelProperty("更新人")
    @TableField(value = "updated_by", fill = FieldFill.INSERT_UPDATE)
    private Integer updatedBy;

    @ApiModelProperty("删除状态: 1 已删；0 未删")
    @JsonIgnore
    @TableField(value = "deleted_flag", insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER)
    @TableLogic
    private String deletedFlag;

    @ApiModelProperty("用户名")
    @TableField("username")
    private String username;

    @ApiModelProperty("登录密码")
    @JsonIgnore
    @TableField("password")
    private String password;

    @ApiModelProperty("邮箱")
    @TableField("email")
    private String email;

    @ApiModelProperty("手机号码")
    @TableField("phone")
    private String phone;

    @ApiModelProperty("部门ID")
    @TableField("department_id")
    private Integer departmentId;

    @ApiModelProperty("状态: 1 启用；0 禁用")
    @TableField(value = "status", insertStrategy = FieldStrategy.NOT_EMPTY, updateStrategy = FieldStrategy.NOT_EMPTY)
    private String status;

    @ApiModelProperty("角色")
    @TableField(exist = false)
    private List<Role> roles;
}
