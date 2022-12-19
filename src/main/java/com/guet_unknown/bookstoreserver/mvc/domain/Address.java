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
 * @since 2022-12-19 22:27:30
 */
@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("(Address)实体类")
public class Address implements Serializable {
    private static final long serialVersionUID = -26459991025643447L;
    @ApiModelProperty(value = "")
    private Long addressId;
    /**
     * 外键，用户id
     */
    @ApiModelProperty(value = "外键，用户id")
    private Long userId;
    /**
     * 省
     */
    @ApiModelProperty(value = "省")
    private String addressProvince;
    /**
     * 市
     */
    @ApiModelProperty(value = "市")
    private String addressCity;
    /**
     * 详情
     */
    @ApiModelProperty(value = "详情")
    private String addressDetail;
    @ApiModelProperty(value = "")
    private Date createTime;
    @ApiModelProperty(value = "")
    private Date updateTime;
}


