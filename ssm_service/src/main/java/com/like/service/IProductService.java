package com.like.service;

import com.like.domain.Product;

import java.util.List;

public interface IProductService
{
    public List<Product> findAll() throws Exception;
}
