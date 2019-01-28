package com.cbs.edu.eshop.controller;

import com.cbs.edu.eshop.dto.request.LoginRequestDto;
import com.cbs.edu.eshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
/*
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView home(ModelAndView modelAndView,
                             @ModelAttribute LoginRequestDto loginRequestDto) {
        System.out.println(loginRequestDto);
        modelAndView.setViewName("home");
        modelAndView.addObject("username", "Yevhenii");

        return modelAndView;
    }*/
}
