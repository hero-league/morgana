package com.morgana.user.domain;

import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 权限
 * </p>
 *
 * @author gm
 * @since 2019-06-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Power对象", description="权限")
public class Power implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "Id")
    @TableId("id")
    private String id;

    @ApiModelProperty(value = "权限编码")
    @TableField("code")
    private String code;

    @ApiModelProperty(value = "权限等级")
    @TableField("level")
    private Integer level;

    @ApiModelProperty(value = "权限名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "父级权限")
    @TableField("parent_id")
    private String parentId;

    @ApiModelProperty(value = "权限顺序")
    @TableField("sort")
    private Integer sort;

    @ApiModelProperty(value = "权限类型(0.菜单 1.动作)")
    @TableField("type")
    private String type;

    @ApiModelProperty(value = "访问路径")
    @TableField("url")
    private String url;


}
