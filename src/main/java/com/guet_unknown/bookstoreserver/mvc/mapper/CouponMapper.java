package com.guet_unknown.bookstoreserver.mvc.mapper;

import com.guet_unknown.bookstoreserver.mvc.domain.Coupon;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Coupon)表数据库访问层
 *
 * @author cyan
 * @since 2022-12-18 23:20:19
 */
@Mapper
public interface CouponMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param couponId 主键
     * @return 实例对象
     */
    Coupon queryById(Long couponId);

    /**
     * 查询所有
     *
     * @return 对象列表
     */
    List<Coupon> queryAll();

    /**
     * 统计总行数
     *
     * @param coupon 查询条件
     * @return 总行数
     */
    long count(Coupon coupon);

    /**
     * 新增数据
     *
     * @param coupon 实例对象
     * @return 影响行数
     */
    int insert(Coupon coupon);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Coupon> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Coupon> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Coupon> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Coupon> entities);

    /**
     * 修改数据
     *
     * @param coupon 实例对象
     * @return 影响行数
     */
    int update(Coupon coupon);

    /**
     * 通过主键删除数据
     *
     * @param couponId 主键
     * @return 影响行数
     */
    int deleteById(Long couponId);

}


