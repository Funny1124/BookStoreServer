package com.guet_unknow.bookstoreserver.mvc.service;

import com.guet_unknow.bookstoreserver.util.R;

/**
 * (RmBooks)表服务接口
 *
 * @author cyan
 * @since 2022-12-18 22:13:19
 */
public interface RmBooksService {

    /**
     * 分页查询
     *
     * @param pageNum  页码
     * @param pageSize 页面大小
     * @return 单条数据
     */
    R queryByPage(int pageNum, int pageSize);

    /**
     * 查询所有
     *
     * @return 查询结果
     */
    R queryAll();

}

