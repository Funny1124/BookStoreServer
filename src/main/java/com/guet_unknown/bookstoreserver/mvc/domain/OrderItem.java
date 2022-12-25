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
 * @since 2022-12-25 13:35:53
 */
@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("(OrderItem)实体类")
public class OrderItem implements Serializable {
    private static final long serialVersionUID = 609429770879517396L;
    @ApiModelProperty(value = "")
    private Long orderId;
    @ApiModelProperty(value = "")
    private Long userId;
    @ApiModelProperty(value = "")
    private String cartItems;
    /**
     * 总价
     */
    @ApiModelProperty(value = "总价")
    private Double orderTotalPrice;
    /**
     * 是否已支付
     */
    @ApiModelProperty(value = "是否已支付")
    private Integer orderPay;
    /**
     * 收货人
     */
    @ApiModelProperty(value = "收货人")
    private String name;
    /**
     * 收货人电话
     */
    @ApiModelProperty(value = "收货人电话")
    private String phone;
    /**
     * 收货地址
     */
    @ApiModelProperty(value = "收货地址")
    private String address;
    /**
     * 0未签收，1已签收
     */
    @ApiModelProperty(value = "0未签收，1已签收")
    private Integer receiveStatus;
    /**
     * 签收人
     */
    @ApiModelProperty(value = "签收人")
    private String receiveName;
    @ApiModelProperty(value = "")
    private Date createTime;
    @ApiModelProperty(value = "")
    private Date updateTime;
}


