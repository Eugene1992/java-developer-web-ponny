package com.cbsystematics.edu.internet_shop.controller;

import com.cbsystematics.edu.internet_shop.service.DiscountService;
import com.cbsystematics.edu.internet_shop.service.ProductService;
import com.cbsystematics.edu.internet_shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    private final UserService userService;
    private final ProductService productService;
    private final DiscountService discountService;

    @Autowired
    public AdminController(UserService userService, ProductService productService, DiscountService discountService) {
        this.userService = userService;
        this.productService = productService;
        this.discountService = discountService;
    }


    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView home(ModelAndView modelAndView) {
        modelAndView.addObject("users", userService.getAll());
        modelAndView.addObject("products", productService.getAll());
        modelAndView.addObject("discounts", discountService.getAll());
        modelAndView.setViewName("admin");

        return modelAndView;
    }
}
