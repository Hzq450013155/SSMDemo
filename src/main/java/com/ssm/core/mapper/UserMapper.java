package com.ssm.core.mapper;


import com.ssm.core.entity.User;

import java.util.List;

public interface UserMapper {

    User getUserByUsername(String username);

    List<User> getList();

    User getListById(Long userId);

    int delete(Long userId);

    int insert(User record);

    int update(User record);
}