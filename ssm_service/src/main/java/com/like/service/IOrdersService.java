package com.like.service;


import com.like.domain.Orders;

import java.util.List;

public interface IOrdersService
{
    List<Orders> findAll(Integer page,Integer size);

    Orders findById(Integer id);
}
