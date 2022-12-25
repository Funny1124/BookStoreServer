package com.guet_unknown.bookstoreserver.mvc.mapper;

import com.guet_unknown.bookstoreserver.mvc.domain.Courier;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Courier)表数据库访问层
 *
 * @author cyan
 * @since 2022-12-25 12:26:43
 */
@Mapper
public interface CourierMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param courierId 主键
     * @return 实例对象
     */
    Courier queryById(Long courierId);

    /**
     * 查询所有
     *
     * @return 对象列表
     */
    List<Courier> queryAll();

    /**
     * 统计总行数
     *
     * @param courier 查询条件
     * @return 总行数
     */
    long count(Courier courier);

    /**
     * 新增数据
     *
     * @param courier 实例对象
     * @return 影响行数
     */
    int insert(Courier courier);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Courier> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Courier> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Courier> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Courier> entities);

    /**
     * 修改数据
     *
     * @param courier 实例对象
     * @return 影响行数
     */
    int update(Courier courier);

    /**
     * 通过主键删除数据
     *
     * @param courierId 主键
     * @return 影响行数
     */
    int deleteById(Long courierId);

}


