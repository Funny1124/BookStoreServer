package com.guet_unknow.bookstoreserver.mvc.mapper;

import com.guet_unknow.bookstoreserver.mvc.domain.Books;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Books)表数据库访问层
 *
 * @author cyan
 * @since 2022-12-17 16:55:31
 */
@Mapper
public interface BooksMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param bookId 主键
     * @return 实例对象
     */
    Books queryById(Long bookId);

    /**
     * 通过ID查询单条数据
     *
     * @param bookTypeId 主键
     * @return 实例对象
     */
    List<Books> queryByType(Long bookTypeId);

    /**
     * 通过ID查询单条数据
     *
     * @param keyWork 主键
     * @return 实例对象
     */
    List<Books> queryByKeyWork(String keyWork);

    /**
     * 查询所有
     *
     * @return 对象列表
     */
    List<Books> queryAll();

    /**
     * 统计总行数
     *
     * @param books 查询条件
     * @return 总行数
     */
    long count(Books books);

    /**
     * 新增数据
     *
     * @param books 实例对象
     * @return 影响行数
     */
    int insert(Books books);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Books> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Books> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Books> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Books> entities);

    /**
     * 修改数据
     *
     * @param books 实例对象
     * @return 影响行数
     */
    int update(Books books);

    /**
     * 通过主键删除数据
     *
     * @param bookId 主键
     * @return 影响行数
     */
    int deleteById(Long bookId);

}


