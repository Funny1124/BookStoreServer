package com.guet_unknown.bookstoreserver.mvc.service.impl;

import lombok.extern.slf4j.Slf4j;
import com.guet_unknown.bookstoreserver.mvc.domain.Coupon;
import com.guet_unknown.bookstoreserver.mvc.mapper.CouponMapper;
import com.guet_unknown.bookstoreserver.mvc.service.CouponService;
import com.guet_unknown.bookstoreserver.util.R;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Coupon)表服务实现类
 *
 * @author cyan
 * @since 2022-12-18 23:20:20
 */
@Slf4j
@Service("couponService")
public class CouponServiceImpl implements CouponService {
    @Resource
    private CouponMapper couponMapper;

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
        List<Coupon> lists = this.couponMapper.queryAll();
        return R.success().setData(new PageInfo<>(lists));
    }

    /**
     * 通过ID查询单条数据
     *
     * @param couponId 主键
     * @return 实例对象
     */
    @Override
    public R queryById(Long couponId) {
        return R.success().setData(this.couponMapper.queryById(couponId));
    }

    /**
     * 查询所有
     *
     * @return 查询结果
     */
    @Override
    public R queryAll() {
        return R.success().setData(this.couponMapper.queryAll());
    }

    /**
     * 新增数据
     *
     * @param coupon 实例对象
     * @return 实例对象
     */
    @Override
    public R insert(Coupon coupon) {
        this.couponMapper.insert(coupon);
        return R.success().setData(coupon);
    }

    /**
     * 修改数据
     *
     * @param coupon 实例对象
     * @return 实例对象
     */
    @Override
    public R update(Coupon coupon) {
        this.couponMapper.update(coupon);
        return R.success().setData(this.queryById(coupon.getCouponId()));
    }

    /**
     * 通过主键删除数据
     *
     * @param couponId 主键
     * @return 是否成功
     */
    @Override
    public R deleteById(Long couponId) {
        boolean del = this.couponMapper.deleteById(couponId) > 0;
        return R.success().setData(del);
    }
}

