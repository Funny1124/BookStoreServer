package com.guet_unknown.bookstoreserver.mvc.service.impl;

import com.guet_unknown.bookstoreserver.mvc.domain.RmBooks;
import lombok.extern.slf4j.Slf4j;
import com.guet_unknown.bookstoreserver.mvc.mapper.RmBooksMapper;
import com.guet_unknown.bookstoreserver.mvc.service.RmBooksService;
import com.guet_unknown.bookstoreserver.util.R;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import javax.annotation.Resource;
import java.util.List;

/**
 * (RmBooks)表服务实现类
 *
 * @author cyan
 * @since 2022-12-18 22:13:19
 */
@Slf4j
@Service("rmBooksService")
public class RmBooksServiceImpl implements RmBooksService {
    @Resource
    private RmBooksMapper rmBooksMapper;

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
        List<RmBooks> lists = this.rmBooksMapper.queryAll();
        return R.success().setData(new PageInfo<>(lists));
    }

    /**
     * 查询所有
     *
     * @return 查询结果
     */
    @Override
    public R queryAll() {
        return R.success().setData(this.rmBooksMapper.queryAll());
    }

}

