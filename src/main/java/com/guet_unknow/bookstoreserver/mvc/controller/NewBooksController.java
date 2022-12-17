package com.guet_unknow.bookstoreserver.mvc.controller;

import com.guet_unknow.bookstoreserver.mvc.service.NewBooksService;
import com.guet_unknow.bookstoreserver.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (NewBooks)表控制层
 *
 * @author cyan
 * @since 2022-12-17 17:06:44
 */
@Slf4j
@RestController
@RequestMapping("newBooks")
@Api(tags = "(NewBooks)表-控制层")
public class NewBooksController {
    /**
     * 服务对象
     */
    @Resource
    private NewBooksService newBooksService;

    /**
     * 查询所有
     *
     * @return 查询结果
     */
    @ApiOperation("查询所有")
    @GetMapping(value = "queryAll")
    public R queryAll() {
        return this.newBooksService.queryAll();
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
        return this.newBooksService.queryByPage(pageNum, pageSize);
    }

}


