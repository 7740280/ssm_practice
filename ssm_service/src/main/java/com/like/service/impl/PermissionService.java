package com.like.service.impl;

import com.like.dao.IPermissionDao;
import com.like.domain.Permission;
import com.like.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PermissionService implements IPermissionService
{
    @Autowired
    private IPermissionDao permissionDao;

    @Override
    public List<Permission> findAll()
    {
        return permissionDao.findAll();
    }

    @Override
    public void save(Permission permission)
    {
        permissionDao.save(permission);
    }
}
