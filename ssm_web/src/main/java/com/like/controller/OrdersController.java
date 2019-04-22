package com.like.controller;


import com.github.pagehelper.PageInfo;
import com.like.domain.Orders;
import com.like.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController
{

    @Autowired
    private IOrdersService iOrdersService;

// 未分页版
//    @RequestMapping("/findAll")
//    public ModelAndView findAll()
//    {
//        ModelAndView mv = new ModelAndView();
//        List<Orders> orders = iOrdersService.findAll();
//        mv.addObject("orders", orders);
//        mv.setViewName("ordersList");
//
//        return mv;
//    }

    @RequestMapping("/findAll")
    public ModelAndView findAll(
            @RequestParam(name = "page", required = true, defaultValue = "1") int page,
            @RequestParam(name = "size", required = true, defaultValue = "4") int size
    )
    {
        ModelAndView mv = new ModelAndView();
        List<Orders> orders = iOrdersService.findAll(page, size);
        //pageinfo 就是分页的bean
        PageInfo<Orders> pageInfo = new PageInfo<>(orders);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("orders-page-list");

        return mv;
    }

    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam(name = "id",required = true)int id)
    {
        Orders orders = iOrdersService.findById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");

        return mv;
    }
}
