package com.guet_unknown.bookstoreserver.mvc.service.impl;

import com.guet_unknown.bookstoreserver.mvc.domain.User;
import com.guet_unknown.bookstoreserver.mvc.mapper.UserMapper;
import com.guet_unknown.bookstoreserver.mvc.service.UserService;
import com.guet_unknown.bookstoreserver.util.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author cyan
 * @since 2022-12-17 15:44:20
 */
@Slf4j
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

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
        List<User> lists = this.userMapper.queryAll();
        return R.success().setData(new PageInfo<>(lists));
    }

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    @Override
    public R queryById(Long userId) {
        return R.success().setData(this.userMapper.queryById(userId));
    }

    /**
     * 查询所有
     *
     * @return 查询结果
     */
    @Override
    public R queryAll() {
        return R.success().setData(this.userMapper.queryAll());
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public R insert(User user) {
        User tempUser = this.userMapper.queryByUserName(user.getUserName());
        if (tempUser != null)
            return R.failure().setData("该用户名已存在");

        this.userMapper.insert(user);
        return R.success().setData(user);
    }
    /**
     * 登录功能
     *
     * @param username 用户名
     * @param password 密码
     * @return 实例对象User
     */
    @Override
    public R login(String username, String password){
        User tempUser = this.userMapper.queryByUserName(username);
        if (tempUser == null)
            return R.failure().setData("不存在该用户，请确认用户名是否正确");
        else if (!tempUser.getPassword().equals(password)) {
            return R.failure().setData("密码错误");
        }
        return R.success().setData(tempUser);
    }
    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public R update(User user) {
        User tempUser = this.userMapper.queryByUserName(user.getUserName());
        if ( tempUser != null && !tempUser.getUserId().equals(user.getUserId()))
            return R.failure().setData("该用户名已存在");

        this.userMapper.update(user);
        return R.success().setData(this.userMapper.queryById(user.getUserId()));
    }

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    @Override
    public R deleteById(Long userId) {
        boolean del = this.userMapper.deleteById(userId) > 0;
        return R.success().setData(del);
    }
}

