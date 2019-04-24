package com.like.controller;


import com.like.domain.UserInfo;
import com.like.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController
{
    @Autowired
    private IUserService userService;

    @RequestMapping("/findAll")
    public ModelAndView findAll()
    {
        List<UserInfo> infoList = userService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("userList", infoList);
        mv.setViewName("userList");

        return mv;
    }

    @RequestMapping("/save")
    public String save(UserInfo userInfo)
    {
        userService.save(userInfo);

        return "forward:findAll";
    }
}
