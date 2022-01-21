package org.jiang.combo.platform.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 字典
 * </p>
 *
 * @author combo
 * @since 2022-01-21
 */
@Getter
@Setter
@TableName("s_dict")
@ApiModel(value = "Dict对象", description = "字典")
public class Dict {

    @ApiModelProperty("主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("创建时间")
    @TableField(value = "created_time", fill = FieldFill.INSERT)
    private LocalDateTime createdTime;

    @ApiModelProperty("更新时间")
    @TableField(value = "updated_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedTime;

    @ApiModelProperty("创建人")
    @TableField(value = "created_by", fill = FieldFill.INSERT)
    private Integer createdBy;

    @ApiModelProperty("更新人")
    @TableField(value = "updated_by", fill = FieldFill.INSERT_UPDATE)
    private Integer updatedBy;

    @ApiModelProperty("删除状态: 1 已删；0 未删")
    @TableField("deleted_flag")
    @TableLogic
    private String deletedFlag;

    @ApiModelProperty("字典名称")
    @TableField("name")
    private String name;

    @ApiModelProperty("字典标识")
    @TableField("code")
    private String code;

    @ApiModelProperty("字典描述")
    @TableField("description")
    private String description;

    @ApiModelProperty("状态: 1 启用；0 禁用")
    @TableField("status")
    private String status;


}
