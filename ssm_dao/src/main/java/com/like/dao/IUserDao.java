package com.like.dao;


import com.like.domain.Role;
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


    @Select("select * from users where id = #{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),

            @Result(property = "roles", column = "id", javaType = List.class, many = @Many(select = "com.like.dao.IRoleDao.findRoleByUserId")),
    })
    UserInfo findById(Integer id);


    @Select("select * from role where id not in (select roleId from user_role where userId = #{userId})")
    List<Role> findOtherRoles(Integer userId);


    @Insert("insert into user_role (userId,roleId) values (#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") int userId, @Param("roleId") Integer roleId);
}
