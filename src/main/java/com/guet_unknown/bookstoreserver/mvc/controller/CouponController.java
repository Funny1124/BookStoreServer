package com.guet_unknown.bookstoreserver.mvc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import com.guet_unknown.bookstoreserver.mvc.domain.Coupon;
import com.guet_unknown.bookstoreserver.mvc.service.CouponService;
import com.guet_unknown.bookstoreserver.util.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Coupon)表控制层
 *
 * @author cyan
 * @since 2022-12-18 23:20:19
 */
@Slf4j
@RestController
@RequestMapping("coupon")
@Api(tags = "(Coupon)表-控制层")
public class CouponController {
    /**
     * 服务对象
     */
    @Resource
    private CouponService couponService;

    /**
     * 查询所有
     *
     * @return 查询结果
     */
    @ApiOperation("查询所有")
    @GetMapping(value = "queryAll")
    public R queryAll() {
        return this.couponService.queryAll();
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
        return this.couponService.queryByPage(pageNum, pageSize);
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
        return this.couponService.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param coupon 实体
     * @return 新增结果
     */
    @ApiOperation("新增数据")
    @PostMapping(value = "insert")
    public R insert(@ApiParam(value = "coupon 实体") @RequestBody Coupon coupon) {
        return this.couponService.insert(coupon);
    }

    /**
     * 更新数据
     *
     * @param coupon 实体
     * @return 更新数据
     */
    @ApiOperation("更新数据")
    @PutMapping(value = "update")
    public R update(@ApiParam(value = "coupon 实体") @RequestBody Coupon coupon) {
        return this.couponService.update(coupon);
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
        return this.couponService.deleteById(id);
    }

}


