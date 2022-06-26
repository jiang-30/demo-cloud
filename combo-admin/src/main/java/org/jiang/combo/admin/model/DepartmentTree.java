package org.jiang.combo.admin.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 组织机构树结构关联
 * @TableName r_department_tree
 */
@TableName(value ="r_department_tree")
@Data
public class DepartmentTree implements Serializable {
    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 祖先ID
     */
    @TableField(value = "ancestor_id")
    private Long ancestorId;

    /**
     * 当前ID
     */
    @TableField(value = "descendant_id")
    private Long descendantId;

    /**
     * 深度
     */
    @TableField(value = "deep")
    private Integer deep;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}