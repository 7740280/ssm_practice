package com.like.service;

import com.like.domain.Permission;

import java.util.List;

public interface IPermissionService
{
    List<Permission> findAll();

    void save(Permission permission);
}
