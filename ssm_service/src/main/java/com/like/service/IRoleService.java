package com.like.service;

import com.like.domain.Role;

import java.util.List;

public interface IRoleService
{
    List<Role> findAll();

    void save(Role role);
}
