package com.guet_unknow.bookstoreserver.mvc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import com.guet_unknow.bookstoreserver.mvc.domain.User;
import com.guet_unknow.bookstoreserver.mvc.service.UserService;
import com.guet_unknow.bookstoreserver.util.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (User)表控制层
 *
 * @author cyan
 * @since 2022-12-17 15:44:19
 */
@Slf4j
@RestController
@RequestMapping("user")
@Api(tags = "(User)表-控制层")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 查询所有
     *
     * @return 查询结果
     */
    @ApiOperation("查询所有")
    @GetMapping(value = "queryAll")
    public R queryAll() {
        return this.userService.queryAll();
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
        return this.userService.queryByPage(pageNum, pageSize);
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
        return this.userService.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param user 实体
     * @return 新增结果
     */
    @ApiOperation("新增数据")
    @PostMapping(value = "insert")
    public R insert(@ApiParam(value = "user 实体") @RequestBody User user) {
        return this.userService.insert(user);
    }

    /**
     * 更新数据
     *
     * @param user 实体
     * @return 更新数据
     */
    @ApiOperation("更新数据")
    @PutMapping(value = "update")
    public R update(@ApiParam(value = "user 实体") @RequestBody User user) {
        return this.userService.update(user);
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
        return this.userService.deleteById(id);
    }

}


