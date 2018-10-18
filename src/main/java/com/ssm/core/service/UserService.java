package com.ssm.core.service;


import com.ssm.core.entity.User;

import java.util.List;


public interface UserService {


    User getUserByUsername(String username);

    List<User> getList(User user);

    void insert(User user);

    void update(User user);

    void delete(User user);

}
