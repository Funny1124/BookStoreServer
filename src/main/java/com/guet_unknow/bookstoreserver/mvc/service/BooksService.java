package com.guet_unknow.bookstoreserver.mvc.service;

import com.guet_unknow.bookstoreserver.mvc.domain.Books;
import com.guet_unknow.bookstoreserver.util.R;

/**
 * (Books)表服务接口
 *
 * @author cyan
 * @since 2022-12-17 16:55:31
 */
public interface BooksService {

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
     * @param bookId 主键
     * @return 实例对象
     */
    R queryById(Long bookId);

    /**
     * 通过keyWork查询
     *
     * @param keyWork 关键词
     * @return 实例对象
     */
    R queryByKeyWork(String keyWork);

    /**
     * 通过ID查询单条数据
     *
     * @param bookTypeId 主键
     * @return 实例对象
     */
    R queryByBookTypeId(Long bookTypeId);

    /**
     * 分页查询
     *
     * @param pageNum  页码
     * @param pageSize 页面大小
     * @return 单条数据
     */
    R queryTypeByPage(int pageNum, int pageSize, Long bookTypeId);

    /**
     * 查询所有
     *
     * @return 查询结果
     */
    R queryAll();

    /**
     * 新增数据
     *
     * @param books 实例对象
     * @return 实例对象
     */
    R insert(Books books);

    /**
     * 修改数据
     *
     * @param books 实例对象
     * @return 实例对象
     */
    R update(Books books);

    /**
     * 通过主键删除数据
     *
     * @param bookId 主键
     * @return 是否成功
     */
    R deleteById(Long bookId);

}

