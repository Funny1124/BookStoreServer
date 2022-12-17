package com.guet_unknow.bookstoreserver.mvc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import com.guet_unknow.bookstoreserver.mvc.domain.Books;
import com.guet_unknow.bookstoreserver.mvc.service.BooksService;
import com.guet_unknow.bookstoreserver.util.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Books)表控制层
 *
 * @author cyan
 * @since 2022-12-17 16:55:31
 */
@Slf4j
@RestController
@RequestMapping("books")
@Api(tags = "(Books)表-控制层")
public class BooksController {
    /**
     * 服务对象
     */
    @Resource
    private BooksService booksService;

    /**
     * 查询所有
     *
     * @return 查询结果
     */
    @ApiOperation("查询所有")
    @GetMapping(value = "queryAll")
    public R queryAll() {
        return this.booksService.queryAll();
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
        return this.booksService.queryByPage(pageNum, pageSize);
    }

    @ApiOperation("按类型分页查询")
    @GetMapping(value = "queryTypeByPage")
    public R queryTypeByPage(@ApiParam(value = "页码") int pageNum, @ApiParam(value = "页面大小") int pageSize, @ApiParam(value = "类型id") Long bookTypeId) {
        return this.booksService.queryTypeByPage(pageNum, pageSize, bookTypeId);
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
        return this.booksService.queryById(id);
    }

    /**
     * 通过关键词查询
     *
     * @param keyWork 关键词
     * @return 数据列表
     */
    @ApiOperation("通过关键词查询")
    @GetMapping(value = "queryByKeyWork")
    public R queryByKeyWork(@ApiParam(value = "keyWork 关键词") @RequestParam("keyWork") String keyWork) {
        return this.booksService.queryByKeyWork(keyWork);
    }

    /**
     * 通过主键查询数据
     *
     * @param bookTypeId 主键
     * @return 数据集合
     */
    @ApiOperation("通过类型id查询")
    @GetMapping(value = "queryByType")
    public R queryByType(@ApiParam(value = "bookTypeId 主键") @RequestParam("bookTypeId") Long bookTypeId) {
        return this.booksService.queryByBookTypeId(bookTypeId);
    }

    /**
     * 新增数据
     *
     * @param books 实体
     * @return 新增结果
     */
    @ApiOperation("新增数据")
    @PostMapping(value = "insert")
    public R insert(@ApiParam(value = "books 实体") @RequestBody Books books) {
        return this.booksService.insert(books);
    }

    /**
     * 更新数据
     *
     * @param books 实体
     * @return 更新数据
     */
    @ApiOperation("更新数据")
    @PutMapping(value = "update")
    public R update(@ApiParam(value = "books 实体") @RequestBody Books books) {
        return this.booksService.update(books);
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
        return this.booksService.deleteById(id);
    }

}


