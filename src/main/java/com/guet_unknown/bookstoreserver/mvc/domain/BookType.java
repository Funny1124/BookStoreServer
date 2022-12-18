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
 * (BookType)实体类
 *
 * @author cyan
 * @since 2022-12-17 16:24:08
 */
@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("(BookType)实体类")
public class BookType implements Serializable {
    private static final long serialVersionUID = 624868436907623325L;
    @ApiModelProperty(value = "")
    private Long bookTypeId;
    /**
     * 类型名称
     */
    @ApiModelProperty(value = "类型名称")
    private String bookTypeName;
    /**
     * 类型介绍
     */
    @ApiModelProperty(value = "类型介绍")
    private String bookTypeDesc;
    @ApiModelProperty(value = "")
    private Date createTime;
    @ApiModelProperty(value = "")
    private Date updateTime;
}


