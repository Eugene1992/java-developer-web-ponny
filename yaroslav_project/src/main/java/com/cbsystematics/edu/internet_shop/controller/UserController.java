package com.cbsystematics.edu.internet_shop.controller;

import com.cbsystematics.edu.internet_shop.dto.request.UserCreationRequestDto;
import com.cbsystematics.edu.internet_shop.entity.User;
import com.cbsystematics.edu.internet_shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute UserCreationRequestDto userCreationRequestDto,
                               ModelAndView modelAndView) {
        modelAndView.setViewName("home");
        if (userCreationRequestDto.getId() == null) {
            userService.create(userCreationRequestDto);
        } else {
            userService.update(userCreationRequestDto);
        }

        return modelAndView;
    }


    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView getAll(ModelAndView modelAndView) {
        modelAndView.setViewName("home");
        for (User user : userService.getAll()) {
            System.out.println(user.getUsername());
        }
        modelAndView.addObject("users", userService.getAll());
        return modelAndView;
    }


    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public ModelAndView get(ModelAndView modelAndView,
                            @PathVariable(value = "id") Integer id) {
        modelAndView.setViewName("home");
        userService.get(id);
        return modelAndView;
    }


    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public ModelAndView delete(ModelAndView modelAndView,
                               @PathVariable(value = "id") Integer id) {
        modelAndView.setViewName("home");
        userService.delete(id);
        return modelAndView;
    }


    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    public ModelAndView update(@ModelAttribute UserCreationRequestDto userCreationRequestDto,
                               ModelAndView modelAndView) {
        modelAndView.setViewName("home");
        userService.update(userCreationRequestDto);
        return modelAndView;
    }
}
