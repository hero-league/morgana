package com.morgana.common.domain.account;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class AccountDTO implements Serializable {

    private static final long serialVersionUID = 4924227949491972884L;

    private String id;

    @ApiModelProperty(value = "创建人Id")
    private String createId;

    @ApiModelProperty(value = "创建人姓名")
    private String createName;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改人Id")
    private String modifyId;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "修改人姓名")
    private String modifyName;

    @ApiModelProperty(value = "冻结金额")
    private BigDecimal lockAccount;

    @ApiModelProperty(value = "金额")
    private BigDecimal account;

    @ApiModelProperty(value = "中间商ID")
    private String userId;

}
