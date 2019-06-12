package com.morgana.account.domain;

import java.math.BigDecimal;
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
 * 
 * </p>
 *
 * @author gm
 * @since 2019-06-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Account对象", description="")
public class Account implements Serializable {

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

    @ApiModelProperty(value = "冻结金额")
    @TableField("lock_account")
    private BigDecimal lockAccount;

    @ApiModelProperty(value = "金额")
    @TableField("account")
    private BigDecimal account;

    @ApiModelProperty(value = "中间商ID")
    @TableField("user_id")
    private String userId;

    @TableField("version")
    @Version
    private Integer version;


}
