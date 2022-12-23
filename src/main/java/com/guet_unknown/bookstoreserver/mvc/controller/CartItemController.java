package com.guet_unknown.bookstoreserver.mvc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import com.guet_unknown.bookstoreserver.mvc.domain.CartItem;
import com.guet_unknown.bookstoreserver.mvc.service.CartItemService;
import com.guet_unknown.bookstoreserver.util.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (CartItem)表控制层
 *
 * @author cyan
 * @since 2022-12-19 16:54:22
 */
@Slf4j
@RestController
@RequestMapping("cartItem")
@Api(tags = "(CartItem)表-控制层")
public class CartItemController {
    /**
     * 服务对象
     */
    @Resource
    private CartItemService cartItemService;

    /**
     * 查询所有
     *
     * @return 查询结果
     */
    @ApiOperation("查询所有")
    @GetMapping(value = "queryAll")
    public R queryAll() {
        return this.cartItemService.queryAll();
    }

    /**
     * 通过主键查询单条数据
     *
     * @param pageNum  页码
     * @param pageSize 页面大小
     * @return 单条数据
     */
    @ApiOperation("分页查询")
    @GetMapping(value = "queryByPage")
    public R queryByPage(@ApiParam(value = "页码") int pageNum, @ApiParam(value = "页面大小") int pageSize) {
        return this.cartItemService.queryByPage(pageNum, pageSize);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation("通过主键id查询")
    @GetMapping(value = "queryById")
    public R queryById(@ApiParam(value = "id 主键") @RequestParam("id") Long id) {
        return this.cartItemService.queryById(id);
    }

    /**
     * 通过userId用户名查询购物车item
     * @param userId 用户名
     * @return 完整购物车
     */
    @ApiOperation("通过userId用户名查询")
    @GetMapping(value = "queryByUserId")
    public R queryByUserId(@ApiParam(value = "userId用户名") @RequestParam("userId") Long userId) {
        return this.cartItemService.queryByUserId(userId);
    }
    /**
     * 通过userId用户名查询-完整版
     * @param userId 用户名
     * @return 完整购物车
     */
    @ApiOperation("通过userId用户名查询-完整版")
    @GetMapping(value = "queryByUserId2")
    public R queryByUserId2(@ApiParam(value = "userId用户名") @RequestParam("userId") Long userId) {
        return this.cartItemService.queryByUserId2(userId);
    }
    /**
     * 新增数据
     *
     * @param cartItem 实体
     * @return 新增结果
     */
    @ApiOperation("新增数据")
    @PostMapping(value = "insert")
    public R insert(@ApiParam(value = "cartItem 实体") @RequestBody CartItem cartItem) {
        return this.cartItemService.insert(cartItem);
    }

    /**
     * 更新数据
     *
     * @param cartItem 实体
     * @return 更新数据
     */
    @ApiOperation("更新数据")
    @PutMapping(value = "update")
    public R update(@ApiParam(value = "cartItem 实体") @RequestBody CartItem cartItem) {
        return this.cartItemService.update(cartItem);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @ApiOperation("删除数据")
    @DeleteMapping(value = "deleteById")
    public R deleteById(@ApiParam(value = "id 主键") @RequestParam("id") Long id) {
        return this.cartItemService.deleteById(id);
    }

}


