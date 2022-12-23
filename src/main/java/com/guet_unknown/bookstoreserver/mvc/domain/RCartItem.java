package com.guet_unknown.bookstoreserver.mvc.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.Date;

/**
 * (RCartItem)实体类
 *
 * @author cyan
 * @since 2022-12-19 18:44:05
 */
@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("(RCartItem)实体类")
public class RCartItem implements Serializable {
    private static final long serialVersionUID = 562277740593296521L;
    @ApiModelProperty(value = "")
    private Long cartItemId;
    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private Long userId;

    /**
     * 书籍id
     */
    @ApiModelProperty(value = "书籍id")
    private Long bookId;


    /**
     * 书信息
     */
    @ApiModelProperty(value = "书信息")
    private Books books;

    /**
     * 书籍数量
     */
    @ApiModelProperty(value = "书籍数量")
    private Integer bookNumber;
    /**
     * 是否选中
     */
    @ApiModelProperty(value = "是否选中")
    private Integer cartItemStatus;
    @ApiModelProperty(value = "")
    private Integer deleteFlag;
    @ApiModelProperty(value = "")
    private Date createTime;
    @ApiModelProperty(value = "")
    private Date updateTime;
}


