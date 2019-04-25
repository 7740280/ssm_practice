package com.like.service;

import com.like.domain.Role;
import com.like.domain.UserInfo;

import java.util.List;

public interface IUserService
{
    List<UserInfo> findAll();

    void save(UserInfo userInfo);

    UserInfo findById(Integer id);

    List<Role> findOtherRoles(Integer userId);

    void addRoleToUser(int userId, Integer[] ids);
}
