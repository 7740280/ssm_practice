package com.like.dao;

import com.like.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

@Repository
public interface ISysLogDao
{
    @Insert("insert into sys_log (visitTime,username,ip,url,executionTime,method) values (#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method}) ")
    void save(SysLog sysLog);
}
