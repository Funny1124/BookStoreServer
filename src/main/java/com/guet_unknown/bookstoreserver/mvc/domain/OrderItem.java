package com.guet_unknown.bookstoreserver.mvc.domain;

import lombok.extern.slf4j.Slf4j;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * (OrderItem)实体类
 *
 * @author cyan
 * @since 2022-12-23 17:10:54
 */
@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("(OrderItem)实体类")
public class OrderItem implements Serializable {
    private static final long serialVersionUID = -24385653510415863L;
    @ApiModelProperty(value = "")
    private Long orderId;
    @ApiModelProperty(value = "")
    private Long userId;
    @ApiModelProperty(value = "")
    private String cartItems;
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


