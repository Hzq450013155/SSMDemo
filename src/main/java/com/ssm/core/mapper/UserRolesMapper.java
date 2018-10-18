package com.ssm.core.mapper;

import com.ssm.core.entity.UserRoles;

import java.util.List;

public interface UserRolesMapper {

    List<String> getRolesByUsername(String username);

    int deleteByPrimaryKey(Integer id);

    int insert(UserRoles record);

    int insertSelective(UserRoles record);

    UserRoles selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRoles record);

    int updateByPrimaryKey(UserRoles record);
}