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

/**
 * <p>
 * 平台
 * </p>
 *
 * @author combo
 * @since 2022-01-21
 */
@Getter
@Setter
@TableName("s_department")
@ApiModel(value = "Department对象", description = "平台")
public class Department {

    @ApiModelProperty("主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    @TableField(value = "created_time", insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER)
    private LocalDateTime createdTime;

    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")
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
    @TableField(value = "deleted_flag", insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER, select = false)
    @TableLogic
    private String deletedFlag;

    @ApiModelProperty("部门名称")
    @TableField("name")
    private String name;

    @ApiModelProperty("部门描述")
    @TableField("description")
    private String description;

    @ApiModelProperty("排序")
    @TableField("sort")
    @OrderBy(asc = true)
    private Integer sort;

    @ApiModelProperty("状态: 1 启用；0 禁用")
    @TableField(value = "status", insertStrategy = FieldStrategy.NOT_EMPTY, updateStrategy = FieldStrategy.NOT_EMPTY)
    private String status;

    @ApiModelProperty("父ID")
    @TableField("parent_id")
    private Integer parentId;

    @TableField(exist = false)
    private List<Department> children;
}
