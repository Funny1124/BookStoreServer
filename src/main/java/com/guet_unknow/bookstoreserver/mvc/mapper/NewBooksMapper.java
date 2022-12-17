package com.guet_unknow.bookstoreserver.mvc.mapper;

import com.guet_unknow.bookstoreserver.mvc.domain.NewBooks;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (NewBooks)表数据库访问层
 *
 * @author cyan
 * @since 2022-12-17 17:10:38
 */
@Mapper
public interface NewBooksMapper {

    /**
     * 查询所有
     *
     * @return 对象列表
     */
    List<NewBooks> queryAll();

}


