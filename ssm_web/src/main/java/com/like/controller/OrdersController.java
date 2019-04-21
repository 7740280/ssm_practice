package com.like.controller;


import com.like.domain.Orders;
import com.like.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController
{

    @Autowired
    private IOrdersService iOrdersService;

    @RequestMapping("/findAll")
    public ModelAndView findAll()
    {
        ModelAndView mv = new ModelAndView();
        List<Orders> orders = iOrdersService.findAll();
        mv.addObject("orders", orders);
        mv.setViewName("ordersList");

        return mv;
    }

    @RequestMapping("/findById")
    public void findById()
    {

    }
}
