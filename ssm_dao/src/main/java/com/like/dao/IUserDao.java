package com.like.dao;


import com.like.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserDao
{
    @Select("select * from users where username = #{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),

            @Result(property = "roles",
                    column = "id",
                    javaType = List.class,
                    many = @Many(select = "com.like.dao.IRoleDao.findRoleByUserId")
            )
    })
    UserInfo findByUsername(String username);


    @Select("select * from users")
    List<UserInfo> findAll();


    @Insert("insert into users (email,username,password,phoneNum,status) values (#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo);
}
