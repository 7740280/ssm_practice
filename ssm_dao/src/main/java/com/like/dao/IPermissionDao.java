package com.like.dao;

import com.like.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPermissionDao
{
    @Select("select * from permission where id in (select permissionId from role_permission where roleId = #{id})")
    List<Permission> findPermissionByRoleId(Integer id);

    @Select("select * from permission")
    List<Permission> findAll();

    @Insert("insert into permission (permissionName,url) values ( #{permissionName}, #{url})")
    void save(Permission permission);
}