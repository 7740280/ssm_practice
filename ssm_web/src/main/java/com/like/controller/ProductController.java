package com.like.controller;


import com.like.domain.Product;
import com.like.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController
{
    @Autowired
    private IProductService productService;

    @RequestMapping("/findAll")
    public ModelAndView findAll() throws Exception
    {
        List<Product> productList = productService.findAll();
        ModelAndView  vm          = new ModelAndView();
        vm.addObject("productList", productList);
        vm.setViewName("productList");
        return vm;
    }

    @RequestMapping("/save")
    public String save(Product product) throws Exception
    {
        productService.save(product);
        return "redirect:findAll";
    }
}
