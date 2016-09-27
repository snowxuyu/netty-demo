package org.netty.demo.service.impl;

import com.github.pagehelper.PageHelper;
import org.framework.basic.service.impl.BaseServiceImpl;
import org.netty.demo.dao.UserDao;
import org.netty.demo.entity.User;
import org.netty.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by snow on 2015/8/20.
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Resource
    private UserDao userDao;

    public User queryBitById(String id) {
        return userDao.queryBitById(id);
    }

    public User queryById(String id) {
        return userDao.queryById(id);
    }

    public List<User> selectAll(Integer pageStar, Integer pageSize) {
        PageHelper.startPage(pageStar, pageSize);
        List<User> all = userDao.selectAll();
        return all;
    }


}
