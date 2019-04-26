package com.like.service;

import com.like.domain.Permission;
import com.like.domain.Role;

import java.util.List;

public interface IRoleService
{
    List<Role> findAll();

    void save(Role role);

    List<Permission> addOtherPermission(Integer roleId);

    Role findById(Integer roleId);

    void addPermission(Integer roleId, Integer[] ids);
}
