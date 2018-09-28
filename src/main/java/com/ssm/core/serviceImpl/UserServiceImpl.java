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
import com.ssm.util.MD5Util;
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

    public User login(User user) {
        User yanzheng = userMapper.login(user);
        if (yanzheng != null) {
            String pass = MD5Util.md5Password(user.getPassword());
            if (pass.equals(yanzheng.getPassword())) {
                return yanzheng;
            } else {
                return null;
            }
        } else {
            return null;
        }


    }

    /*
     *  查询用户列表
     * @author zongqi.hao@hand-china.com
     * @date 2018-07-21 15:24
     * @param [mdoel]
     * @return java.util.List<com.ssm.core.entity.User>
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

    /*
     *  新增用户（事务）
     * @author zongqi.hao@hand-china.com
     * @date 2018-07-18 15:33
     * @param [mdoel]
     * @return void
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insert(User mdoel) {
        logger.info("===================新增用户=====================");
        userMapper.insert(mdoel);
    }

    /*
     *  更新用户
     * @author zongqi.hao@hand-china.com
     * @date 2018-07-18 15:34
     * @param [mdoel]
     * @return void
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void update(User mdoel) {
        logger.info("===================更新用户=====================");
        userMapper.update(mdoel);
    }

    /*
     *  删除用户
     * @author zongqi.hao@hand-china.com
     * @date 2018-07-21 15:24
     * @param [mdoel]
     * @return void
     */
    public void delete(User mdoel) {
        logger.info("===================删除用户=====================");
        userMapper.delete(mdoel.getUserId());
    }
}
