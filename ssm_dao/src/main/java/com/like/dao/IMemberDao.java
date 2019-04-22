package com.like.dao;


import com.like.domain.Member;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface IMemberDao
{
    @Select("select * from member where id = #{id}")
    Member findById(Integer id);
}
