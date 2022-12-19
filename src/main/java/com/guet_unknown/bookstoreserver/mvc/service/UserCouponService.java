package com.guet_unknown.bookstoreserver.mvc.service;

import com.guet_unknown.bookstoreserver.mvc.domain.UserCoupon;
import com.guet_unknown.bookstoreserver.util.R;

/**
 * (UserCoupon)表服务接口
 *
 * @author cyan
 * @since 2022-12-19 19:22:58
 */
public interface UserCouponService {

    /**
     * 分页查询
     *
     * @param pageNum  页码
     * @param pageSize 页面大小
     * @return 单条数据
     */
    R queryByPage(int pageNum, int pageSize);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    R queryById(Long id);

    /**
     * 查询所有
     *
     * @return 查询结果
     */
    R queryAll();

    R queryByUserId(Long userId);
    /**
     * 新增数据
     *
     * @param userCoupon 实例对象
     * @return 实例对象
     */
    R insert(UserCoupon userCoupon);

    /**
     * 修改数据
     *
     * @param userCoupon 实例对象
     * @return 实例对象
     */
    R update(UserCoupon userCoupon);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    R deleteById(Long id);

}

