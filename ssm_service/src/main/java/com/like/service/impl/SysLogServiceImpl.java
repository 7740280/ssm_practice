package com.like.service.impl;

import com.like.dao.ISysLogDao;
import com.like.domain.SysLog;
import com.like.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class SysLogServiceImpl implements ISysLogService
{
    @Autowired
    private ISysLogDao sysLogDao;

    @Override
    public void save(SysLog sysLog)
    {
        sysLogDao.save(sysLog);
    }
}
