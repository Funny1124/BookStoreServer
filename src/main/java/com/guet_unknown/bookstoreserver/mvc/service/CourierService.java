package com.guet_unknown.bookstoreserver.mvc.service;

import com.guet_unknown.bookstoreserver.mvc.domain.Courier;
import com.guet_unknown.bookstoreserver.util.R;

/**
 * (Courier)表服务接口
 *
 * @author cyan
 * @since 2022-12-25 12:26:43
 */
public interface CourierService {

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
     * @param courierId 主键
     * @return 实例对象
     */
    R queryById(Long courierId);

    /**
     * 查询所有
     *
     * @return 查询结果
     */
    R queryAll();

    /**
     * 新增数据
     *
     * @param courier 实例对象
     * @return 实例对象
     */
    R insert(Courier courier);

    /**
     * 修改数据
     *
     * @param courier 实例对象
     * @return 实例对象
     */
    R update(Courier courier);

    /**
     * 通过主键删除数据
     *
     * @param courierId 主键
     * @return 是否成功
     */
    R deleteById(Long courierId);

}

