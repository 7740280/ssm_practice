package com.like.dao;

import com.like.domain.Role;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRoleDao
{
    @Select("select * from role where id in (select roleId from user_role where userId = #{id})")
    List<Role> findRoleByUserId(Integer id);
}
