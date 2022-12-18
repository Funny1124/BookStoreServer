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
 * (Books)实体类
 *
 * @author cyan
 * @since 2022-12-17 16:55:31
 */
@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("(Books)实体类")
public class Books implements Serializable {
    private static final long serialVersionUID = -34772090086646333L;
    @ApiModelProperty(value = "")
    private Long bookId;
    /**
     * 外键：类型id
     */
    @ApiModelProperty(value = "外键：类型id")
    private Long bookTypeId;
    /**
     * 书名
     */
    @ApiModelProperty(value = "书名")
    private String bookName;
    /**
     * 作者
     */
    @ApiModelProperty(value = "作者")
    private String bookAuthor;
    /**
     * 封面图
     */
    @ApiModelProperty(value = "封面图")
    private String bookCover;
    /**
     * 书籍介绍
     */
    @ApiModelProperty(value = "书籍介绍")
    private String bookDesc;
    /**
     * 价格
     */
    @ApiModelProperty(value = "价格")
    private Double bookPrice;
    /**
     * 是否上架在售
     */
    @ApiModelProperty(value = "是否上架在售")
    private Integer bookStatus;
    /**
     * 是否被标记为删除
     */
    @ApiModelProperty(value = "是否被标记为删除")
    private Integer bookDeleteFlag;
    @ApiModelProperty(value = "")
    private Date createTime;
    @ApiModelProperty(value = "")
    private Date updateTime;
    /**
     * 是否为新书
     */
    @ApiModelProperty(value = "是否为新书")
    private Integer isNew;
    /**
     * 是否为推荐书籍
     */
    @ApiModelProperty(value = "是否为推荐书籍")
    private Integer isRm;
}


