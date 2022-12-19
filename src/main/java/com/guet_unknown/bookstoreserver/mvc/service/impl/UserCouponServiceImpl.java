package com.guet_unknown.bookstoreserver.mvc.service.impl;

import lombok.extern.slf4j.Slf4j;
import com.guet_unknown.bookstoreserver.mvc.domain.UserCoupon;
import com.guet_unknown.bookstoreserver.mvc.mapper.UserCouponMapper;
import com.guet_unknown.bookstoreserver.mvc.service.UserCouponService;
import com.guet_unknown.bookstoreserver.util.R;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import javax.annotation.Resource;
import java.util.List;

/**
 * (UserCoupon)表服务实现类
 *
 * @author cyan
 * @since 2022-12-19 19:22:58
 */
@Slf4j
@Service("userCouponService")
public class UserCouponServiceImpl implements UserCouponService {
    @Resource
    private UserCouponMapper userCouponMapper;

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
        List<UserCoupon> lists = this.userCouponMapper.queryAll();
        return R.success().setData(new PageInfo<>(lists));
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public R queryById(Long id) {
        return R.success().setData(this.userCouponMapper.queryById(id));
    }

    /**
     * 查询所有
     *
     * @return 查询结果
     */
    @Override
    public R queryAll() {
        return R.success().setData(this.userCouponMapper.queryAll());
    }

    public R queryByUserId(Long userId) {
        return R.success().setData(this.userCouponMapper.queryByUserId(userId));
    }
    /**
     * 新增数据
     *
     * @param userCoupon 实例对象
     * @return 实例对象
     */
    @Override
    public R insert(UserCoupon userCoupon) {
        this.userCouponMapper.insert(userCoupon);
        return R.success().setData(userCoupon);
    }

    /**
     * 修改数据
     *
     * @param userCoupon 实例对象
     * @return 实例对象
     */
    @Override
    public R update(UserCoupon userCoupon) {
        this.userCouponMapper.update(userCoupon);
        return R.success().setData(this.queryById(userCoupon.getId()));
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public R deleteById(Long id) {
        boolean del = this.userCouponMapper.deleteById(id) > 0;
        return R.success().setData(del);
    }
}

