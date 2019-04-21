package com.like.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("orders")
public class OrdersController
{



    @RequestMapping("findAll")
    public String findAll()
    {
        return "hello";
    }

    @RequestMapping("findById")
    public void findById()
    {

    }
}
