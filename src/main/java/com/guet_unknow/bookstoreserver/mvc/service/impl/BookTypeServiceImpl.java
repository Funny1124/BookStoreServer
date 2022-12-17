package com.guet_unknow.bookstoreserver.mvc.service.impl;

import lombok.extern.slf4j.Slf4j;
import com.guet_unknow.bookstoreserver.mvc.domain.BookType;
import com.guet_unknow.bookstoreserver.mvc.mapper.BookTypeMapper;
import com.guet_unknow.bookstoreserver.mvc.service.BookTypeService;
import com.guet_unknow.bookstoreserver.util.R;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BookType)表服务实现类
 *
 * @author cyan
 * @since 2022-12-17 16:24:08
 */
@Slf4j
@Service("bookTypeService")
public class BookTypeServiceImpl implements BookTypeService {
    @Resource
    private BookTypeMapper bookTypeMapper;

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
        List<BookType> lists = this.bookTypeMapper.queryAll();
        return R.success().setData(new PageInfo<>(lists));
    }

    /**
     * 通过ID查询单条数据
     *
     * @param bookTypeId 主键
     * @return 实例对象
     */
    @Override
    public R queryById(Long bookTypeId) {
        return R.success().setData(this.bookTypeMapper.queryById(bookTypeId));
    }

    /**
     * 查询所有
     *
     * @return 查询结果
     */
    @Override
    public R queryAll() {
        return R.success().setData(this.bookTypeMapper.queryAll());
    }

    /**
     * 新增数据
     *
     * @param bookType 实例对象
     * @return 实例对象
     */
    @Override
    public R insert(BookType bookType) {
        this.bookTypeMapper.insert(bookType);
        return R.success().setData(bookType);
    }

    /**
     * 修改数据
     *
     * @param bookType 实例对象
     * @return 实例对象
     */
    @Override
    public R update(BookType bookType) {
        this.bookTypeMapper.update(bookType);
        return R.success().setData(this.queryById(bookType.getBookTypeId()));
    }

    /**
     * 通过主键删除数据
     *
     * @param bookTypeId 主键
     * @return 是否成功
     */
    @Override
    public R deleteById(Long bookTypeId) {
        boolean del = this.bookTypeMapper.deleteById(bookTypeId) > 0;
        return R.success().setData(del);
    }
}

