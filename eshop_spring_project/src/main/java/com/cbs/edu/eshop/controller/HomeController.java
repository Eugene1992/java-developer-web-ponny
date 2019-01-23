package com.cbs.edu.eshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public ModelAndView home(ModelAndView modelAndView,
                             @RequestParam(value = "action", required = false) String action,
                             @PathVariable(value = "id") Integer id) {
        System.out.println(action);
        System.out.println(id);
        modelAndView.setViewName("home");
        modelAndView.addObject("username", "Yevhenii");

        return modelAndView;
    }
}
