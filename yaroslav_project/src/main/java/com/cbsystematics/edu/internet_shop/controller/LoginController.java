package com.cbsystematics.edu.internet_shop.controller;

import com.cbsystematics.edu.internet_shop.dto.request.LoginRequestDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView home(ModelAndView modelAndView,
                             @ModelAttribute LoginRequestDto loginRequestDto) {
        System.out.println(loginRequestDto);
        modelAndView.setViewName("home");
        return modelAndView;
    }
}
