package com.like.service.impl;

import com.like.dao.IRoleDao;
import com.like.domain.Role;
import com.like.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService
{
    @Autowired
    private IRoleDao roleDao;

    @Override
    public List<Role> findAll()
    {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role)
    {
        roleDao.save(role);
    }
}
