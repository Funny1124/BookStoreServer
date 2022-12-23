package com.guet_unknown.bookstoreserver.mvc.service.impl;

import com.guet_unknown.bookstoreserver.mvc.domain.RCartItem;
import com.guet_unknown.bookstoreserver.mvc.mapper.BooksMapper;
import lombok.extern.slf4j.Slf4j;
import com.guet_unknown.bookstoreserver.mvc.domain.CartItem;
import com.guet_unknown.bookstoreserver.mvc.mapper.CartItemMapper;
import com.guet_unknown.bookstoreserver.mvc.service.CartItemService;
import com.guet_unknown.bookstoreserver.util.R;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (CartItem)表服务实现类
 *
 * @author cyan
 * @since 2022-12-19 16:54:22
 */
@Slf4j
@Service("cartItemService")
public class CartItemServiceImpl implements CartItemService {
    @Resource
    private CartItemMapper cartItemMapper;
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
        List<CartItem> lists = this.cartItemMapper.queryAll();
        return R.success().setData(new PageInfo<>(lists));
    }

    /**
     * 通过ID查询单条数据
     *
     * @param cartItemId 主键
     * @return 实例对象
     */
    @Override
    public R queryById(Long cartItemId) {
        return R.success().setData(this.cartItemMapper.queryById(cartItemId));
    }

    /**
     * 通过ID查询单条数据
     *
     * @param cartItemId 主键
     * @return 实例对象
     */
    @Override
    public R queryById2(Long cartItemId) {
        CartItem cartItem = this.cartItemMapper.queryById(cartItemId);
        RCartItem rCartItem = new RCartItem();
        rCartItem.setCartItemId(cartItem.getCartItemId());
        rCartItem.setUserId(cartItem.getUserId());
        rCartItem.setBookId(cartItem.getBookId());
        rCartItem.setBooks(this.booksMapper.queryById(rCartItem.getBookId()));
        rCartItem.setBookNumber(cartItem.getBookNumber());
        rCartItem.setCartItemStatus(cartItem.getCartItemStatus());
        rCartItem.setDeleteFlag(cartItem.getDeleteFlag());
        rCartItem.setCreateTime(cartItem.getCreateTime());
        rCartItem.setUpdateTime(cartItem.getUpdateTime());
        return R.success().setData(rCartItem);
    }


    /**
     * 通过userId用户名查询购物车item
     * @param userId 用户名
     * @return 完整购物车
     */
    @Override
    public R queryByUserId(Long userId){
        return R.success().setData(this.cartItemMapper.queryByUserId(userId));
    }

    /**
     * 通过userId用户名查询购物车item
     * @param userId 用户名
     * @return 完整购物车
     */
    @Override
    public R queryByUserId2(Long userId){
        List<RCartItem> rCartItems = new ArrayList<>();
        List<CartItem> cartItems = this.cartItemMapper.queryByUserId(userId);
        for (int i = 0; i < cartItems.size(); i++) {
            RCartItem rCartItem = new RCartItem();
            rCartItem.setCartItemId(cartItems.get(i).getCartItemId());
            rCartItem.setUserId(cartItems.get(i).getUserId());
            rCartItem.setBookId(cartItems.get(i).getBookId());
            rCartItem.setBooks(this.booksMapper.queryById(rCartItem.getBookId()));
            rCartItem.setBookNumber(cartItems.get(i).getBookNumber());
            rCartItem.setCartItemStatus(cartItems.get(i).getCartItemStatus());
            rCartItem.setDeleteFlag(cartItems.get(i).getDeleteFlag());
            rCartItem.setCreateTime(cartItems.get(i).getCreateTime());
            rCartItem.setUpdateTime(cartItems.get(i).getUpdateTime());
            rCartItems.add(rCartItem);
        }
        return R.success().setData(rCartItems);
    }
    /**
     * 查询所有
     *
     * @return 查询结果
     */
    @Override
    public R queryAll() {
        return R.success().setData(this.cartItemMapper.queryAll());
    }

    /**
     * 新增数据
     *
     * @param cartItem 实例对象
     * @return 实例对象
     */
    @Override
    public R insert(CartItem cartItem) {
        this.cartItemMapper.insert(cartItem);
        return R.success().setData(cartItem);
    }

    /**
     * 修改数据
     *
     * @param cartItem 实例对象
     * @return 实例对象
     */
    @Override
    public R update(CartItem cartItem) {
        this.cartItemMapper.update(cartItem);
        return R.success().setData(this.queryById(cartItem.getCartItemId()));
    }

    /**
     * 通过主键删除数据
     *
     * @param cartItemId 主键
     * @return 是否成功
     */
    @Override
    public R deleteById(Long cartItemId) {
        boolean del = this.cartItemMapper.deleteById(cartItemId) > 0;
        return R.success().setData(del);
    }
}

