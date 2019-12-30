/**
 * Copyright (C), 2015-2018, 上海汉得信息技术股份有限公司
 * FileName: UserServiceImpl
 * Author:   zqh
 * Date:     2018-07-17 14:05
 * Description:
 */
package com.ssm.core.serviceImpl;

import com.ssm.core.mapper.UserRolesMapper;
import com.ssm.core.service.UserRolesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRolesServiceImpl implements UserRolesService {

    private static final Logger logger = LoggerFactory.getLogger(UserRolesServiceImpl.class);

    @Autowired
    private UserRolesMapper userRolesMapper;

    public List<String> getRolesByUsername(String username) {
        List<String> list = userRolesMapper.getRolesByUsername(username);
        if (list == null) {
            return null;
        }
        return list;
    }

//    /**
//     * 查询用户列表
//     *
//     * @param
//     * @return java.util.List<com.ssm.core.entity.User>
//     * @author zongqi.hao@hand-china.com
//     * @date 2018-07-21 15:24
//     */
//    public List<User> getList(User mdoel) {
//        logger.info("===================查询用户列表=====================");
//        List<User> list = new ArrayList<User>();
//        if (mdoel.getUserId() == null) {
//            list = userMapper.getList();
//        } else {
//            User user = userMapper.getListById(mdoel.getUserId());
//            list.add(user);
//        }
//        return list;
//    }
//
//    /**
//     * 新增用户（事务）
//     *
//     * @param
//     * @return void
//     * @author zongqi.hao@hand-china.com
//     * @date 2018-07-18 15:33
//     */
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    public void insert(User mdoel) {
//        logger.info("===================新增用户=====================");
//        userMapper.insert(mdoel);
//    }
//
//    /**
//     * 更新用户
//     *
//     * @param
//     * @return void
//     * @author zongqi.hao@hand-china.com
//     * @date 2018-07-18 15:34
//     */
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    public void update(User mdoel) {
//        logger.info("===================更新用户=====================");
//        userMapper.update(mdoel);
//    }
//
//    /**
//     * 删除用户
//     *
//     * @param
//     * @return void
//     * @author zongqi.hao@hand-china.com
//     * @date 2018-07-21 15:24
//     */
//    public void delete(User mdoel) {
//        logger.info("===================删除用户=====================");
//        userMapper.delete(mdoel.getUserId());
//    }
}
