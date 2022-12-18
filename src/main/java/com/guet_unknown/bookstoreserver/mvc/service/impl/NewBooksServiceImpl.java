package com.guet_unknown.bookstoreserver.mvc.service.impl;

import com.guet_unknown.bookstoreserver.mvc.service.NewBooksService;
import lombok.extern.slf4j.Slf4j;
import com.guet_unknown.bookstoreserver.mvc.domain.NewBooks;
import com.guet_unknown.bookstoreserver.mvc.mapper.NewBooksMapper;
import com.guet_unknown.bookstoreserver.util.R;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import javax.annotation.Resource;
import java.util.List;

/**
 * (NewBooks)表服务实现类
 *
 * @author cyan
 * @since 2022-12-17 17:06:45
 */
@Slf4j
@Service("newBooksService")
public class NewBooksServiceImpl implements NewBooksService {
    @Resource
    private NewBooksMapper newBooksMapper;

    /**
     * 分页查询
     *
     * @param pageNum  页码
     * @param pageSize 页面大小
     * @return 分页数据
     */
    @Override
    public R queryByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<NewBooks> lists = this.newBooksMapper.queryAll();
        return R.success().setData(new PageInfo<>(lists));
    }

    /**
     * 查询所有
     *
     * @return 查询结果
     */
    @Override
    public R queryAll() {
        return R.success().setData(this.newBooksMapper.queryAll());
    }
}

