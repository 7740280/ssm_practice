package com.like.dao;

import com.like.domain.Member;
import com.like.domain.Orders;
import com.like.domain.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrdersDao
{
    @Select("select * from orders")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "payType", column = "payType"),
            @Result(
                    property = "product",
                    column = "productId",
                    javaType = Product.class,
                    one = @One(select = "com.like.dao.IProductDao.findById")
            ),
    })
    List<Orders> findAll();

    @Select("select * from orders where id = #{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "payType", column = "payType"),
            @Result(
                    property = "product",
                    column = "productId",
                    javaType = Product.class,
                    one = @One(select = "com.like.dao.IProductDao.findById")
            ),
            @Result(
                    property = "member",
                    column = "memberId",
                    javaType = Member.class,
                    one = @One(select = "com.like.dao.IMemberDao.findById")
            ),
            @Result(
                    property = "travellers",
                    column = "id",
                    javaType = List.class,
                    many = @Many(select = "com.like.dao.ITravellerDao.findByOrdersId"))
    })
    Orders findById(Integer id);
}
