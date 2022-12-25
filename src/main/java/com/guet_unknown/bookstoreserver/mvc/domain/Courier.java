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
 * (Courier)实体类
 *
 * @author cyan
 * @since 2022-12-25 12:26:42
 */
@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("(Courier)实体类")
public class Courier implements Serializable {
    private static final long serialVersionUID = 841638751755828651L;
    @ApiModelProperty(value = "")
    private Long courierId;
    @ApiModelProperty(value = "")
    private Long orderId;
    @ApiModelProperty(value = "")
    private Long userId;
    @ApiModelProperty(value = "")
    private String receiverName;
    @ApiModelProperty(value = "")
    private String receiverStatus;
    @ApiModelProperty(value = "")
    private Date receiverTime;
    @ApiModelProperty(value = "")
    private Date createTime;
    @ApiModelProperty(value = "")
    private Date updateTime;
}


