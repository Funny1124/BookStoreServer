package com.guet_unknown.bookstoreserver.mvc.service.impl;

import lombok.extern.slf4j.Slf4j;
import com.guet_unknown.bookstoreserver.mvc.domain.Courier;
import com.guet_unknown.bookstoreserver.mvc.mapper.CourierMapper;
import com.guet_unknown.bookstoreserver.mvc.service.CourierService;
import com.guet_unknown.bookstoreserver.util.R;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Courier)表服务实现类
 *
 * @author cyan
 * @since 2022-12-25 12:26:43
 */
@Slf4j
@Service("courierService")
public class CourierServiceImpl implements CourierService {
    @Resource
    private CourierMapper courierMapper;

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
        List<Courier> lists = this.courierMapper.queryAll();
        return R.success().setData(new PageInfo<>(lists));
    }

    /**
     * 通过ID查询单条数据
     *
     * @param courierId 主键
     * @return 实例对象
     */
    @Override
    public R queryById(Long courierId) {
        return R.success().setData(this.courierMapper.queryById(courierId));
    }

    /**
     * 查询所有
     *
     * @return 查询结果
     */
    @Override
    public R queryAll() {
        return R.success().setData(this.courierMapper.queryAll());
    }

    /**
     * 新增数据
     *
     * @param courier 实例对象
     * @return 实例对象
     */
    @Override
    public R insert(Courier courier) {
        this.courierMapper.insert(courier);
        return R.success().setData(courier);
    }

    /**
     * 修改数据
     *
     * @param courier 实例对象
     * @return 实例对象
     */
    @Override
    public R update(Courier courier) {
        this.courierMapper.update(courier);
        return R.success().setData(this.queryById(courier.getCourierId()));
    }

    /**
     * 通过主键删除数据
     *
     * @param courierId 主键
     * @return 是否成功
     */
    @Override
    public R deleteById(Long courierId) {
        boolean del = this.courierMapper.deleteById(courierId) > 0;
        return R.success().setData(del);
    }
}

