package com.like.service.impl;

import com.like.dao.IUserDao;
import com.like.domain.Role;
import com.like.domain.UserInfo;
import com.like.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService, UserDetailsService
{
    @Autowired
    private IUserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        UserInfo userInfo = userDao.findByUsername(username);
        //处理自己的userInfo对象封装成UserDetails对象
//        User user = new User(userInfo.getUsername(),"{noop}" + userInfo.getPassword(), getAuthority(userInfo.getRoles()));
        User user = new User(userInfo.getUsername(), "{noop}" + userInfo.getPassword(), userInfo.getStatus() == 0 ? false : true, true, true, true, getAuthority(userInfo.getRoles()));

        return user;
    }

    //返回一个list集合,结合中装入的是角色描述
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles)
    {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }

        return list;
    }
}
