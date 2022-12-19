package com.guet_unknown.bookstoreserver.mvc.mapper;

import com.guet_unknown.bookstoreserver.mvc.domain.CartItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (CartItem)表数据库访问层
 *
 * @author cyan
 * @since 2022-12-19 16:54:22
 */
@Mapper
public interface CartItemMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param cartItemId 主键
     * @return 实例对象
     */
    CartItem queryById(Long cartItemId);

    List<CartItem> queryByUserId(Long userId);
    /**
     * 查询所有
     *
     * @return 对象列表
     */
    List<CartItem> queryAll();

    /**
     * 统计总行数
     *
     * @param cartItem 查询条件
     * @return 总行数
     */
    long count(CartItem cartItem);

    /**
     * 新增数据
     *
     * @param cartItem 实例对象
     * @return 影响行数
     */
    int insert(CartItem cartItem);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<CartItem> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<CartItem> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<CartItem> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<CartItem> entities);

    /**
     * 修改数据
     *
     * @param cartItem 实例对象
     * @return 影响行数
     */
    int update(CartItem cartItem);

    /**
     * 通过主键删除数据
     *
     * @param cartItemId 主键
     * @return 影响行数
     */
    int deleteById(Long cartItemId);

}


