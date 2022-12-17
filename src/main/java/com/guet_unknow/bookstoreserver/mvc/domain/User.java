package com.guet_unknow.bookstoreserver.mvc.domain;

import lombok.extern.slf4j.Slf4j;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * (User)实体类
 *
 * @author cyan
 * @since 2022-12-17 15:44:19
 */
@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("(User)实体类")
public class User implements Serializable {
    private static final long serialVersionUID = -26364255411151392L;
    @ApiModelProperty(value = "")
    private Long userId;
    @ApiModelProperty(value = "")
    private String userName;
    @ApiModelProperty(value = "")
    private String password;
    @ApiModelProperty(value = "")
    private String nickName;
    @ApiModelProperty(value = "")
    private String avatar;
    @ApiModelProperty(value = "")
    private String phnoe;
    @ApiModelProperty(value = "")
    private String email;
    @ApiModelProperty(value = "")
    private Date createTime;
    @ApiModelProperty(value = "")
    private Date updateTime;
}


