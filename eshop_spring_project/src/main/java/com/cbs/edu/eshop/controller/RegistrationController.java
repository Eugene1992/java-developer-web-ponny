package com.cbs.edu.eshop.controller;

import com.cbs.edu.eshop.dto.request.UserCreationRequestDto;
import com.cbs.edu.eshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/registration")
public class RegistrationController {

    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView create(ModelAndView modelAndView) {
        modelAndView.setViewName("new_user_register_form");

        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute UserCreationRequestDto userCreationRequestDto,
                               ModelAndView modelAndView) {
        modelAndView.setViewName("home");
        userService.create(userCreationRequestDto);

        return modelAndView;
    }
}