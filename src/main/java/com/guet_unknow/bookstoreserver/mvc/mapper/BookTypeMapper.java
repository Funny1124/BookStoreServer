package com.guet_unknow.bookstoreserver.mvc.mapper;

import com.guet_unknow.bookstoreserver.mvc.domain.BookType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (BookType)表数据库访问层
 *
 * @author cyan
 * @since 2022-12-17 16:24:08
 */
@Mapper
public interface BookTypeMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param bookTypeId 主键
     * @return 实例对象
     */
    BookType queryById(Long bookTypeId);

    /**
     * 查询所有
     *
     * @return 对象列表
     */
    List<BookType> queryAll();

    /**
     * 统计总行数
     *
     * @param bookType 查询条件
     * @return 总行数
     */
    long count(BookType bookType);

    /**
     * 新增数据
     *
     * @param bookType 实例对象
     * @return 影响行数
     */
    int insert(BookType bookType);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<BookType> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<BookType> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<BookType> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<BookType> entities);

    /**
     * 修改数据
     *
     * @param bookType 实例对象
     * @return 影响行数
     */
    int update(BookType bookType);

    /**
     * 通过主键删除数据
     *
     * @param bookTypeId 主键
     * @return 影响行数
     */
    int deleteById(Long bookTypeId);

}


