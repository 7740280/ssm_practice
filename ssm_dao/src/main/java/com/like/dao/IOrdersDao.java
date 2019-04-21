package com.like.dao;

import com.like.domain.Orders;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrdersDao
{
    List<Orders> findAll();

    Orders findById();
}
