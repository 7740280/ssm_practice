package com.like.service;

import com.like.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService
{
    List<UserInfo> findAll();
}
