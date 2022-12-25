package com.guet_unknown.bookstoreserver.mvc.service.impl;

import lombok.extern.slf4j.Slf4j;
import com.guet_unknown.bookstoreserver.mvc.domain.Address;
import com.guet_unknown.bookstoreserver.mvc.mapper.AddressMapper;
import com.guet_unknown.bookstoreserver.mvc.service.AddressService;
import com.guet_unknown.bookstoreserver.util.R;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Address)表服务实现类
 *
 * @author cyan
 * @since 2022-12-19 22:27:30
 */
@Slf4j
@Service("addressService")
public class AddressServiceImpl implements AddressService {
    @Resource
    private AddressMapper addressMapper;

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
        List<Address> lists = this.addressMapper.queryAll();
        return R.success().setData(new PageInfo<>(lists));
    }

    /**
     * 通过ID查询单条数据
     *
     * @param addressId 主键
     * @return 实例对象
     */
    @Override
    public R queryById(Long addressId) {
        return R.success().setData(this.addressMapper.queryById(addressId));
    }

    @Override
    public R queryByUserId(Long userId) {
        return R.success().setData(this.addressMapper.queryByUserId(userId));
    }


    /**
     * 查询所有
     *
     * @return 查询结果
     */
    @Override
    public R queryAll() {
        return R.success().setData(this.addressMapper.queryAll());
    }

    /**
     * 新增数据
     *
     * @param address 实例对象
     * @return 实例对象
     */
    @Override
    public R insert(Address address) {
        this.addressMapper.insert(address);
        return R.success().setData(address);
    }

    /**
     * 修改数据
     *
     * @param address 实例对象
     * @return 实例对象
     */
    @Override
    public R update(Address address) {
        this.addressMapper.update(address);
        return R.success().setData(this.queryById(address.getAddressId()));
    }

    /**
     * 通过主键删除数据
     *
     * @param addressId 主键
     * @return 是否成功
     */
    @Override
    public R deleteById(Long addressId) {
        boolean del = this.addressMapper.deleteById(addressId) > 0;
        return R.success().setData(del);
    }
}

