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
 * (UserCoupon)实体类
 *
 * @author cyan
 * @since 2022-12-19 19:22:57
 */
@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("(UserCoupon)实体类")
public class UserCoupon implements Serializable {
    private static final long serialVersionUID = 620228700784353367L;
    @ApiModelProperty(value = "")
    private Long id;
    /**
     * 优惠券编号
     */
    @ApiModelProperty(value = "优惠券编号")
    private Long couponId;
    /**
     * 拥有者
     */
    @ApiModelProperty(value = "拥有者")
    private Long userId;
    @ApiModelProperty(value = "")
    private Integer deleteFlag;
    @ApiModelProperty(value = "")
    private Date createTime;
    @ApiModelProperty(value = "")
    private Date updateTime;
}


