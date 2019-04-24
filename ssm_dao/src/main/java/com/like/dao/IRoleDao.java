package com.like.dao;

import com.like.domain.Role;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRoleDao
{
    @Select("select * from role where id in (select roleId from user_role where userId = #{id})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "roleDesc", column = "roleDesc"),

            @Result(property = "permissions", column = "id", javaType = List.class, many = @Many(select = "com.like.dao.IPermission.findPermissionByRoleId"))
    })
    List<Role> findRoleByUserId(Integer id);
}
