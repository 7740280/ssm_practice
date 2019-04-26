package com.like.controller;

import com.like.domain.Permission;
import com.like.domain.Role;
import com.like.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController
{
    @Autowired
    private IRoleService roleService;

    @RequestMapping("/findAll")
    public ModelAndView findAll()
    {
        ModelAndView mv = new ModelAndView();
        List<Role> roleList = roleService.findAll();
        mv.addObject("roleList", roleList);
        mv.setViewName("roleList");

        return mv;
    }

    @RequestMapping("/save")
    public String save(Role role)
    {
        roleService.save(role);
        return "redirect:findAll";
    }

    @RequestMapping("/addOtherPermission")
    public ModelAndView addOtherPermission(@RequestParam(name = "id", required = true) Integer roleId)
    {
        List<Permission> permissionList = roleService.addOtherPermission(roleId);
        Role role = roleService.findById(roleId);
        ModelAndView mv = new ModelAndView();
        mv.addObject("role", role);
        mv.addObject("permissionList", permissionList);
        mv.setViewName("rolePermissionAdd");

        return mv;
    }


    @RequestMapping("/addPermissionToRole")
    public String addPermissionToRole(
            @RequestParam(name = "roleId", required = true) Integer roleId,
            @RequestParam(name = "ids", required = true) Integer[] ids
    )
    {
        roleService.addPermission(roleId,ids);
        return "redirect:findAll";
    }
}
