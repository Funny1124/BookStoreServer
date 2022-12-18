package com.guet_unknow.bookstoreserver.mvc.mapper;

import com.guet_unknow.bookstoreserver.mvc.domain.RmBooks;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (RmBooks)表数据库访问层
 *
 * @author cyan
 * @since 2022-12-18 22:13:19
 */
@Mapper
public interface RmBooksMapper {

    /**
     * 查询所有
     *
     * @return 对象列表
     */
    List<RmBooks> queryAll();

}


