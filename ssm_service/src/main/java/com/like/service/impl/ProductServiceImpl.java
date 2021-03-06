package com.like.service.impl;

import com.like.dao.IProductDao;
import com.like.domain.Product;
import com.like.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements IProductService
{
    @Autowired
    private IProductDao productDao;

    @Override
    @RolesAllowed("ADMIN")
    public List<Product> findAll() throws Exception
    {
        return productDao.findAll();
    }

    @Override
    public void save(Product product)
    {
        productDao.save(product);
    }
}
