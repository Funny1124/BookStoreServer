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
 * (User)实体类
 *
 * @author cyan
 * @since 2022-12-20 14:33:40
 */
@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("(User)实体类")
public class User implements Serializable {
    private static final long serialVersionUID = 245311741247008071L;
    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private Long userId;
    /**
     * 用于登录的用户名
     */
    @ApiModelProperty(value = "用于登录的用户名")
    private String userName;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String password;
    /**
     * 昵称
     */
    @ApiModelProperty(value = "昵称")
    private String nickName;
    /**
     * 头像地址
     */
    @ApiModelProperty(value = "头像地址")
    private String avatar;
    /**
     * 手机
     */
    @ApiModelProperty(value = "手机")
    private String phone;
    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    private String email;
    /**
     * 0普通用户，1管理员
     */
    @ApiModelProperty(value = "0普通用户，1管理员")
    private Integer role;
    @ApiModelProperty(value = "")
    private Date createTime;
    @ApiModelProperty(value = "")
    private Date updateTime;
}


