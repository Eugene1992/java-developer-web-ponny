package com.cbs.edu.eshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "/registration")
public class RegistrationController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView create(ModelAndView modelAndView) {
        modelAndView.setViewName("new_user_register_form");

        return modelAndView;
    }
}