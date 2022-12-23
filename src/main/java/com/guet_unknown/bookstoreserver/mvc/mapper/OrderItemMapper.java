package com.guet_unknown.bookstoreserver.mvc.mapper;

import com.guet_unknown.bookstoreserver.mvc.domain.OrderItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (OrderItem)表数据库访问层
 *
 * @author cyan
 * @since 2022-12-23 17:10:54
 */
@Mapper
public interface OrderItemMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param orderId 主键
     * @return 实例对象
     */
    OrderItem queryById(Long orderId);
    /**
     * 通过用户ID查询所有数据
     *
     * @param userId 用户
     * @return 实例对象列表
     */
    List<OrderItem> queryByUserId(Long userId);

    /**
     * 查询所有
     *
     * @return 对象列表
     */
    List<OrderItem> queryAll();

    /**
     * 统计总行数
     *
     * @param orderItem 查询条件
     * @return 总行数
     */
    long count(OrderItem orderItem);

    /**
     * 新增数据
     *
     * @param orderItem 实例对象
     * @return 影响行数
     */
    int insert(OrderItem orderItem);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<OrderItem> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<OrderItem> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<OrderItem> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<OrderItem> entities);

    /**
     * 修改数据
     *
     * @param orderItem 实例对象
     * @return 影响行数
     */
    int update(OrderItem orderItem);

    /**
     * 通过主键删除数据
     *
     * @param orderId 主键
     * @return 影响行数
     */
    int deleteById(Long orderId);

}


