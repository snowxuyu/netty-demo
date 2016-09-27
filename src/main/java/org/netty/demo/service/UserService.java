package org.netty.demo.service;

import org.framework.basic.service.BaseService;
import org.netty.demo.entity.User;

import java.util.List;

/**
 * Created by snow on 2015/8/20.
 */
public interface UserService extends BaseService<User> {

    User queryBitById(String id);

    User queryById(String id);

    List<User> selectAll(Integer pageStar, Integer pageSize);
}
