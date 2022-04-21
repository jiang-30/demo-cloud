package org.jiang.combo.admin.model;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

/**
 * 组织机构
 * @TableName s_department
 */
@TableName(value ="s_department")
@Data
public class Department implements Serializable {
    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 创建时间
     */
    @TableField(value = "created_time")
    private LocalDateTime createdTime;

    /**
     * 创建人
     */
    @TableField(value = "created_by")
    private Long createdBy;

    /**
     * 更新时间
     */
    @TableField(value = "updated_time")
    private LocalDateTime updatedTime;

    /**
     * 更新人
     */
    @TableField(value = "updated_by")
    private Long updatedBy;

    /**
     * 数据权限
     */
    @TableField(value = "scope_department")
    private Long scopeDepartment;

    /**
     * 是否删除: 1 已删；0 未删
     */
    @TableLogic
    @TableField(value = "is_deleted")
    private String isDeleted;

    /**
     * 父ID
     */
    @TableField(value = "parent_id")
    private Long parentId;

    /**
     * 名称
     */
    @TableField(value = "title")
    private String title;

    /**
     * 描述
     */
    @TableField(value = "description")
    private String description;

    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;

    /**
     * 排序
     */
    @TableField(value = "sort")
    private Integer sort;

    /**
     * 是否启用: 1 启用；0 禁用
     */
    @TableField(value = "is_enabled")
    private String isEnabled;

    /**
     * 子级
     */
    @TableField(exist = false)
    private List<Department> children;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}