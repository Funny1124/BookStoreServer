package com.guet_unknow.bookstoreserver.mvc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import com.guet_unknow.bookstoreserver.mvc.service.RmBooksService;
import com.guet_unknow.bookstoreserver.util.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (RmBooks)视图-控制层
 *
 * @author cyan
 * @since 2022-12-18 22:13:05
 */
@Slf4j
@RestController
@RequestMapping("rmBooks")
@Api(tags = "(RmBooks)视图-控制层")
public class RmBooksController {
    /**
     * 服务对象
     */
    @Resource
    private RmBooksService rmBooksService;

    /**
     * 查询所有
     *
     * @return 查询结果
     */
    @ApiOperation("查询所有")
    @GetMapping(value = "queryAll")
    public R queryAll() {
        return this.rmBooksService.queryAll();
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
        return this.rmBooksService.queryByPage(pageNum, pageSize);
    }
}


