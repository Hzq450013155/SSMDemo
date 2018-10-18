/**
 * Copyright (C), 2015-2018, 上海汉得信息技术股份有限公司
 * FileName: UserServiceImpl
 * Author:   zqh
 * Date:     2018-07-17 14:05
 * Description:
 */
package com.ssm.core.serviceImpl;

import com.ssm.core.entity.User;
import com.ssm.core.mapper.UserMapper;
import com.ssm.core.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    public User getUserByUsername(String username) {
        User user = userMapper.getUserByUsername(username);
        if (user == null) {
            return null;
        }
        return user;
    }

    /**
     * 查询用户列表
     *
     * @param
     * @return java.util.List<com.ssm.core.entity.User>
     * @author zongqi.hao@hand-china.com
     * @date 2018-07-21 15:24
     */
    public List<User> getList(User mdoel) {
        logger.info("===================查询用户列表=====================");
        List<User> list = new ArrayList<User>();
        if (mdoel.getUserId() == null) {
            list = userMapper.getList();
        } else {
            User user = userMapper.getListById(mdoel.getUserId());
            list.add(user);
        }
        return list;
    }

    /**
     * 新增用户（事务）
     *
     * @param
     * @return void
     * @author zongqi.hao@hand-china.com
     * @date 2018-07-18 15:33
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insert(User mdoel) {
        logger.info("===================新增用户=====================");
        userMapper.insert(mdoel);
    }

    /**
     * 更新用户
     *
     * @param
     * @return void
     * @author zongqi.hao@hand-china.com
     * @date 2018-07-18 15:34
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void update(User mdoel) {
        logger.info("===================更新用户=====================");
        userMapper.update(mdoel);
    }

    /**
     * 删除用户
     *
     * @param
     * @return void
     * @author zongqi.hao@hand-china.com
     * @date 2018-07-21 15:24
     */
    public void delete(User mdoel) {
        logger.info("===================删除用户=====================");
        userMapper.delete(mdoel.getUserId());
    }
}
