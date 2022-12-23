package com.guet_unknown.bookstoreserver.mvc.service;

import com.guet_unknown.bookstoreserver.mvc.domain.CartItem;
import com.guet_unknown.bookstoreserver.util.R;

/**
 * (CartItem)表服务接口
 *
 * @author cyan
 * @since 2022-12-19 16:54:22
 */
public interface CartItemService {

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
     * @param cartItemId 主键
     * @return 实例对象
     */
    R queryById(Long cartItemId);
    /**
     * 通过userId用户名查询购物车item
     * @param userId 用户名
     * @return 完整购物车
     */
    R queryByUserId(Long userId);

    R queryByUserId2(Long userId);

    /**
     * 查询所有
     *
     * @return 查询结果
     */
    R queryAll();

    /**
     * 新增数据
     *
     * @param cartItem 实例对象
     * @return 实例对象
     */
    R insert(CartItem cartItem);

    /**
     * 修改数据
     *
     * @param cartItem 实例对象
     * @return 实例对象
     */
    R update(CartItem cartItem);

    /**
     * 通过主键删除数据
     *
     * @param cartItemId 主键
     * @return 是否成功
     */
    R deleteById(Long cartItemId);

}

