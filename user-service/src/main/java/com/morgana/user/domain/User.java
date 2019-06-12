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
 * 用户
 * </p>
 *
 * @author gm
 * @since 2019-06-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="User对象", description="用户")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "Id")
    @TableId("id")
    private String id;

    @ApiModelProperty(value = "手机号")
    @TableField("mobile")
    private String mobile;

    @ApiModelProperty(value = "姓名")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "角色")
    @TableField("role")
    private String role;

    @ApiModelProperty(value = "认证(0.未认证 1.处理中 2.已认证 3.认证失败)")
    @TableField("examine")
    private String examine;

    @ApiModelProperty(value = "是否已删除(0.未删除 1.已删除")
    @TableField("is_delete")
    private String isDelete;

    @ApiModelProperty(value = "地址")
    @TableField("address")
    private String address;

    @ApiModelProperty(value = "编号")
    @TableField("code")
    private String code;

    @ApiModelProperty(value = "认证时间")
    @TableField("examine_time")
    private LocalDateTime examineTime;

    @ApiModelProperty(value = "最后登录时间")
    @TableField("last_login_time")
    private LocalDateTime lastLoginTime;

    @ApiModelProperty(value = "密码")
    @TableField("pwd")
    private String pwd;

    @ApiModelProperty(value = "性别")
    @TableField("sex")
    private String sex;

    @ApiModelProperty(value = "状态(0.正常 1.冻结)")
    @TableField("status")
    private String status;

    @ApiModelProperty(value = "邀请码")
    @TableField("invitation_code")
    private String invitationCode;

    @ApiModelProperty(value = "注册码")
    @TableField("poll_code")
    private String pollCode;

    @ApiModelProperty(value = "机构id")
    @TableField("owner_id")
    private String ownerId;

    @ApiModelProperty(value = "上级用户姓名")
    @TableField("parent_name")
    private String parentName;

    @ApiModelProperty(value = "角色id")
    @TableField("role_id")
    private String roleId;

    @ApiModelProperty(value = "角色名称")
    @TableField("role_name")
    private String roleName;

    @ApiModelProperty(value = "代理等级(0.平台 1.一级代理 2.二级代理)")
    @TableField("level")
    private Integer level;

    @ApiModelProperty(value = "上级用户ID")
    @TableField("parent_id")
    private String parentId;

    @ApiModelProperty(value = "上级用户手机号")
    @TableField("parent_mobile")
    private String parentMobile;

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

    @ApiModelProperty(value = "修改人姓名")
    @TableField("modify_name")
    private String modifyName;

    @ApiModelProperty(value = "修改时间")
    @TableField("update_time")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "电子邮箱")
    @TableField("email")
    private String email;

    @ApiModelProperty(value = "官网地址")
    @TableField("website")
    private String website;


}
