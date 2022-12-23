package com.guet_unknown.bookstoreserver.mvc.service;

import com.guet_unknown.bookstoreserver.mvc.domain.OrderItem;
import com.guet_unknown.bookstoreserver.util.R;

/**
 * (OrderItem)表服务接口
 *
 * @author cyan
 * @since 2022-12-23 17:10:55
 */
public interface OrderItemService {

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
     * @param orderId 主键
     * @return 实例对象
     */
    R queryById(Long orderId);

    R queryByUserId(Long userId);

    /**
     * 查询所有
     *
     * @return 查询结果
     */
    R queryAll();

    /**
     * 新增数据
     *
     * @param orderItem 实例对象
     * @return 实例对象
     */
    R insert(OrderItem orderItem);

    /**
     * 修改数据
     *
     * @param orderItem 实例对象
     * @return 实例对象
     */
    R update(OrderItem orderItem);

    /**
     * 通过主键删除数据
     *
     * @param orderId 主键
     * @return 是否成功
     */
    R deleteById(Long orderId);

}

