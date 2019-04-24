package com.like.service;

import com.like.domain.UserInfo;

import java.util.List;

public interface IUserService
{
    List<UserInfo> findAll();

    void save(UserInfo userInfo);
}
