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
 * (CartItem)实体类
 *
 * @author cyan
 * @since 2022-12-19 16:54:22
 */
@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("(CartItem)实体类")
public class CartItem implements Serializable {
    private static final long serialVersionUID = 906686271986135035L;
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
    private Date createTime;
    @ApiModelProperty(value = "")
    private Date updataTime;
}


