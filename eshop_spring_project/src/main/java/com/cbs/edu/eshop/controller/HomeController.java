package com.cbs.edu.eshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView home(ModelAndView modelAndView) {
        modelAndView.setViewName("home");

        return modelAndView;
    }
}
