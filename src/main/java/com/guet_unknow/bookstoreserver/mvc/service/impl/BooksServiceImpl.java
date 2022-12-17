package com.guet_unknow.bookstoreserver.mvc.service.impl;

import lombok.extern.slf4j.Slf4j;
import com.guet_unknow.bookstoreserver.mvc.domain.Books;
import com.guet_unknow.bookstoreserver.mvc.mapper.BooksMapper;
import com.guet_unknow.bookstoreserver.mvc.service.BooksService;
import com.guet_unknow.bookstoreserver.util.R;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Books)表服务实现类
 *
 * @author cyan
 * @since 2022-12-17 16:55:31
 */
@Slf4j
@Service("booksService")
public class BooksServiceImpl implements BooksService {
    @Resource
    private BooksMapper booksMapper;

    /**
     * 分页查询
     *
     * @param pageNum  页码
     * @param pageSize 页面大小
     * @return 单条数据
     */
    @Override
    public R queryByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Books> lists = this.booksMapper.queryAll();
        return R.success().setData(new PageInfo<>(lists));
    }

    /**
     * 通过ID查询单条数据
     *
     * @param bookId 主键
     * @return 实例对象
     */
    @Override
    public R queryById(Long bookId) {
        return R.success().setData(this.booksMapper.queryById(bookId));
    }

    @Override
    public R queryByKeyWork(String keyWork) {
        if (keyWork.equals(" ") || keyWork.equals(""))
            return R.failure().setData("关键词不能为空");
        return R.success().setData(this.booksMapper.queryByKeyWork(keyWork));
    }

    @Override
    public R queryByBookTypeId(Long bookTypeId) {
        return R.success().setData(this.booksMapper.queryByType(bookTypeId));
    }

    @Override
    public R queryTypeByPage(int pageNum, int pageSize, Long bookTypeId) {
        PageHelper.startPage(pageNum, pageSize);
        List<Books> lists = this.booksMapper.queryByType(bookTypeId);
        return R.success().setData(new PageInfo<>(lists));
    }

    /**
     * 查询所有
     *
     * @return 查询结果
     */
    @Override
    public R queryAll() {
        return R.success().setData(this.booksMapper.queryAll());
    }

    /**
     * 新增数据
     *
     * @param books 实例对象
     * @return 实例对象
     */
    @Override
    public R insert(Books books) {
        this.booksMapper.insert(books);
        return R.success().setData(books);
    }

    /**
     * 修改数据
     *
     * @param books 实例对象
     * @return 实例对象
     */
    @Override
    public R update(Books books) {
        this.booksMapper.update(books);
        return R.success().setData(this.queryById(books.getBookId()));
    }

    /**
     * 通过主键删除数据
     *
     * @param bookId 主键
     * @return 是否成功
     */
    @Override
    public R deleteById(Long bookId) {
        boolean del = this.booksMapper.deleteById(bookId) > 0;
        return R.success().setData(del);
    }
}

