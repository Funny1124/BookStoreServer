package com.guet_unknow.bookstoreserver.mvc.service;

import com.guet_unknow.bookstoreserver.mvc.domain.User;
import com.guet_unknow.bookstoreserver.util.R;

/**
 * (User)表服务接口
 *
 * @author cyan
 * @since 2022-12-17 15:44:20
 */
public interface UserService {

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
     * @param userId 主键
     * @return 实例对象
     */
    R queryById(Long userId);

    /**
     * 查询所有
     *
     * @return 查询结果
     */
    R queryAll();

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    R insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    R update(User user);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    R deleteById(Long userId);

}

