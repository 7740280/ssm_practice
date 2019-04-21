package com.like.service.impl;

import com.like.dao.IOrdersDao;
import com.like.domain.Orders;
import com.like.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrdersServiceImpl implements IOrdersService
{
    @Autowired
    private IOrdersDao iOrdersDao;

    @Override
    public List<Orders> findAll()
    {
        return iOrdersDao.findAll();
    }

    @Override
    public Orders findById(Integer id)
    {
        return iOrdersDao.findById(id);
    }
}
