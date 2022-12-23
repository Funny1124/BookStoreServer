package com.guet_unknown.bookstoreserver.mvc.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * (ROrderItem)实体类
 *
 * @author cyan
 * @since 2022-12-23 17:10:54
 */
@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("(ROrderItem)实体类")
public class ROrderItem implements Serializable {

    @ApiModelProperty(value = "")
    private Long orderId;
    @ApiModelProperty(value = "")
    private Long userId;
    @ApiModelProperty(value = "")
    private List<RCartItem> rCartItems;
    @ApiModelProperty(value = "")
    private Double orderTotalPrice;
    /**
     * 是否已支付
     */
    @ApiModelProperty(value = "是否已支付")
    private Integer orderPay;
    @ApiModelProperty(value = "")
    private Date createTime;
    @ApiModelProperty(value = "")
    private Date updateTime;
}


