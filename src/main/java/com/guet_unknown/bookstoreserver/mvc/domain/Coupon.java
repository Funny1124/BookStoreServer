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
 * (Coupon)实体类
 *
 * @author cyan
 * @since 2022-12-18 23:20:19
 */
@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("(Coupon)实体类")
public class Coupon implements Serializable {
    private static final long serialVersionUID = 896990809484165175L;
    /**
     * 优惠券编号
     */
    @ApiModelProperty(value = "优惠券编号")
    private Long couponId;
    /**
     * 图片
     */
    @ApiModelProperty(value = "图片")
    private String couponImages;
    /**
     * 优惠券信息介绍
     */
    @ApiModelProperty(value = "优惠券信息介绍")
    private String couponDesc;
    /**
     * 优惠券价值  元
     */
    @ApiModelProperty(value = "优惠券价值  元")
    private Double couponValue;
    /**
     * 是否可用
     */
    @ApiModelProperty(value = "是否可用")
    private Integer couponAvailable;
    @ApiModelProperty(value = "")
    private Date createTime;
    @ApiModelProperty(value = "")
    private Date updateTime;
}


