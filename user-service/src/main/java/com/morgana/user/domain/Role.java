package com.morgana.user.domain;

import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色
 * </p>
 *
 * @author gm
 * @since 2019-06-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Role对象", description="角色")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "Id")
    @TableId("id")
    private String id;

    @ApiModelProperty(value = "创建人Id")
    @TableField("create_id")
    private String createId;

    @ApiModelProperty(value = "创建人姓名")
    @TableField("create_name")
    private String createName;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改人Id")
    @TableField("modify_id")
    private String modifyId;

    @ApiModelProperty(value = "修改时间")
    @TableField("update_time")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "修改人姓名")
    @TableField("modify_name")
    private String modifyName;

    @ApiModelProperty(value = "角色编码")
    @TableField("code")
    private String code;

    @ApiModelProperty(value = "部门ID")
    @TableField("dept_id")
    private String deptId;

    @ApiModelProperty(value = "部门名称")
    @TableField("dept_name")
    private String deptName;

    @ApiModelProperty(value = "角色名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "角色说明")
    @TableField("remark")
    private String remark;

    @ApiModelProperty(value = "排序值")
    @TableField("sort")
    private Integer sort;

    @ApiModelProperty(value = "角色状态(0.冻结 1.启用)")
    @TableField("status")
    private String status;


}
