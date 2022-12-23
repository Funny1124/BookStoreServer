package com.guet_unknown.bookstoreserver.mvc.service.impl;

import com.guet_unknown.bookstoreserver.mvc.domain.CartItem;
import com.guet_unknown.bookstoreserver.mvc.domain.RCartItem;
import com.guet_unknown.bookstoreserver.mvc.domain.ROrderItem;
import com.guet_unknown.bookstoreserver.mvc.mapper.CartItemMapper;
import com.guet_unknown.bookstoreserver.mvc.service.CartItemService;
import lombok.extern.slf4j.Slf4j;
import com.guet_unknown.bookstoreserver.mvc.domain.OrderItem;
import com.guet_unknown.bookstoreserver.mvc.mapper.OrderItemMapper;
import com.guet_unknown.bookstoreserver.mvc.service.OrderItemService;
import com.guet_unknown.bookstoreserver.util.R;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (OrderItem)表服务实现类
 *
 * @author cyan
 * @since 2022-12-23 17:10:55
 */
@Slf4j
@Service("orderItemService")
public class OrderItemServiceImpl implements OrderItemService {
    @Resource
    private OrderItemMapper orderItemMapper;
    @Resource
    private CartItemMapper cartItemMapper;
    @Resource
    private CartItemService cartItemService;

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
        List<OrderItem> lists = this.orderItemMapper.queryAll();
        return R.success().setData(new PageInfo<>(lists));
    }

    /**
     * 通过ID查询单条数据
     *
     * @param orderId 主键
     * @return 实例对象
     */
    @Override
    public R queryById(Long orderId) {
        return R.success().setData(this.orderItemMapper.queryById(orderId));
    }

    /**
     * 通过用户ID查询所有数据
     *
     * @param userId 用户
     * @return 实例对象
     */
    @Override
    public R queryByUserId(Long userId) {
        List<ROrderItem> rOrderItems = new ArrayList<>();
        List<OrderItem> orderItems = this.orderItemMapper.queryByUserId(userId);
        for (int i = 0; i < orderItems.size(); i++) {
            ROrderItem rOrderItem = new ROrderItem();
            List<RCartItem> rCartItemList = new ArrayList<>();
            String[] cartItems = orderItems
                    .get(i).getCartItems().split(",");//根据   ,  切分字符串
            for (int j = 0; j < cartItems.length; j++) {
                RCartItem rCartItem = (RCartItem) cartItemService.queryById2(Long.parseLong(cartItems[j])).getData();
                rCartItemList.add(rCartItem);
            }
            rOrderItem.setOrderId(orderItems.get(i).getOrderId());
            rOrderItem.setUserId(orderItems.get(i).getUserId());
            rOrderItem.setRCartItems(rCartItemList);
            rOrderItem.setOrderTotalPrice(orderItems.get(i).getOrderTotalPrice());
            rOrderItem.setOrderPay(orderItems.get(i).getOrderPay());
            rOrderItem.setCreateTime(orderItems.get(i).getCreateTime());
            rOrderItem.setUpdateTime(orderItems.get(i).getUpdateTime());
            rOrderItems.add(rOrderItem);
        }
        return R.success().setData(rOrderItems);
    }

    /**
     * 查询所有
     *
     * @return 查询结果
     */
    @Override
    public R queryAll() {
        List<ROrderItem> rOrderItems = new ArrayList<>();
        List<OrderItem> orderItems = this.orderItemMapper.queryAll();
        for (int i = 0; i < orderItems.size(); i++) {
            ROrderItem rOrderItem = new ROrderItem();
            List<RCartItem> rCartItemList = new ArrayList<>();
            String[] orderBooks = orderItems
                    .get(i).getCartItems().split(",");//根据   ,  切分字符串
            for (int j = 0; j < orderBooks.length; j++) {
                RCartItem rCartItem = (RCartItem) cartItemService.queryById2(Long.parseLong(orderBooks[j])).getData();
                rCartItemList.add(rCartItem);
            }
            rOrderItem.setOrderId(orderItems.get(i).getOrderId());
            rOrderItem.setUserId(orderItems.get(i).getUserId());
            rOrderItem.setRCartItems(rCartItemList);
            rOrderItem.setOrderTotalPrice(orderItems.get(i).getOrderTotalPrice());
            rOrderItem.setOrderPay(orderItems.get(i).getOrderPay());
            rOrderItem.setCreateTime(orderItems.get(i).getCreateTime());
            rOrderItem.setUpdateTime(orderItems.get(i).getUpdateTime());
            rOrderItems.add(rOrderItem);
        }
        return R.success().setData(rOrderItems);
    }

    /**
     * 新增数据
     *
     * @param orderItem 实例对象
     * @return 实例对象
     */
    @Override
    public R insert(OrderItem orderItem) {
        this.orderItemMapper.insert(orderItem);
        return R.success().setData(orderItem);
    }

    /**
     * 修改数据
     *
     * @param orderItem 实例对象
     * @return 实例对象
     */
    @Override
    public R update(OrderItem orderItem) {
        this.orderItemMapper.update(orderItem);
        return R.success().setData(this.queryById(orderItem.getOrderId()));
    }

    /**
     * 通过主键删除数据
     *
     * @param orderId 主键
     * @return 是否成功
     */
    @Override
    public R deleteById(Long orderId) {
        boolean del = this.orderItemMapper.deleteById(orderId) > 0;
        return R.success().setData(del);
    }
}

