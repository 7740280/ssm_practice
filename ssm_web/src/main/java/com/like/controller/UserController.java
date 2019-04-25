package com.like.controller;


import com.like.domain.Role;
import com.like.domain.UserInfo;
import com.like.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping("/findById")
    public ModelAndView find(@RequestParam(name = "id", required = true) Integer id)
    {
        UserInfo userInfo = userService.findById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("user", userInfo);
        mv.setViewName("userShow");

        return mv;
    }

    @RequestMapping("/findUserByIdAndAllRole")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id", required = true) Integer userId)
    {
        //获取当前用户
        UserInfo userInfo = userService.findById(userId);
        //获取没有的角色
        List<Role> roleList = userService.findOtherRoles(userId);

        ModelAndView mv = new ModelAndView();
        mv.addObject("user", userInfo);
        mv.addObject("roleList", roleList);
        mv.setViewName("userRoleAdd");

        return mv;
    }

    @RequestMapping("addRoleToUser")
    public String addRoleToUser(
            @RequestParam(name = "ids", required = true) Integer[] ids,
            @RequestParam(name = "userId", required = true) int userId
    )
    {
        userService.addRoleToUser(userId, ids);

        return "redirect:findAll";
    }
}
