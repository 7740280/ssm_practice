package com.like.service;


import com.like.domain.Orders;

import java.util.List;

public interface IOrdersService
{
    List<Orders> findAll();

    Orders findById(Integer id);
}
