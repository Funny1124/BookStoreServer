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
 * (Address)实体类
 *
 * @author cyan
 * @since 2022-12-25 23:14:57
 */
@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("(Address)实体类")
public class Address implements Serializable {
    private static final long serialVersionUID = -51574392548681608L;
    @ApiModelProperty(value = "")
    private Long addressId;
    /**
     * 外键，用户id
     */
    @ApiModelProperty(value = "外键，用户id")
    private Long userId;
    @ApiModelProperty(value = "")
    private String name;
    @ApiModelProperty(value = "")
    private String phone;
    /**
     * 省
     */
    @ApiModelProperty(value = "省")
    private String addressProvince;
    /**
     * 市区
     */
    @ApiModelProperty(value = "市区")
    private String addressCity;
    /**
     * 详情
     */
    @ApiModelProperty(value = "详情")
    private String addressDetail;
    /**
     * 是否为默认，1为默认地址
     */
    @ApiModelProperty(value = "是否为默认，1为默认地址")
    private Integer isDefault;
    @ApiModelProperty(value = "")
    private Date createTime;
    @ApiModelProperty(value = "")
    private Date updateTime;
}


