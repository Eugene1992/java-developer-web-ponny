package com.cbs.edu.eshop.controller;

import com.cbs.edu.eshop.dto.request.LoginRequestDto;
import com.cbs.edu.eshop.dto.request.UserCreationRequestDto;
import com.cbs.edu.eshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;


/**
 * getAll()             /users                                  GET
 * get()                /users/{id}                             GET
 * update()             /users/{id}                             PUT
 * delete()             /users/{id}                             DELETE
 * create()             /users                                  POST
 *
 * getUserRoles()       /users/{id}/roles                       GET
 * getUserDiscount      /users/{userId}/discounts/{discountId}  GET
 */
@Controller
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute UserCreationRequestDto userCreationRequestDto,
                               ModelAndView modelAndView) {
        modelAndView.setViewName("home");
        userService.create(userCreationRequestDto);

        return modelAndView;
    }
}
