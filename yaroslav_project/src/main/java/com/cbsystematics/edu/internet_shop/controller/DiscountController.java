package com.cbsystematics.edu.internet_shop.controller;

import com.cbsystematics.edu.internet_shop.entity.Discount;
import com.cbsystematics.edu.internet_shop.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/discounts")
public class DiscountController {

    private final DiscountService discountService;

    @Autowired
    public DiscountController(DiscountService discountService) {
        this.discountService = discountService;
    }

    @RequestMapping(value = "/discounts/add", method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute Discount discount,
                               ModelAndView modelAndView) {
        modelAndView.setViewName("home");
        if (discount.getId() == null) {
            discountService.create(discount);
        } else {
            discountService.update(discount);
        }

        return modelAndView;
    }


    @RequestMapping(value = "/discounts", method = RequestMethod.GET)
    public ModelAndView getAll(ModelAndView modelAndView) {
        modelAndView.setViewName("home");
        for (Discount discount : discountService.getAll()) {
            System.out.println(discount);
        }
        modelAndView.addObject("users", discountService.getAll());
        return modelAndView;
    }


    @RequestMapping(value = "/discounts/{id}", method = RequestMethod.GET)
    public ModelAndView get(ModelAndView modelAndView,
                            @PathVariable(value = "id") Integer id) {
        modelAndView.setViewName("home");
        discountService.get(id);
        return modelAndView;
    }


    @RequestMapping(value = "/discounts/{id}", method = RequestMethod.DELETE)
    public ModelAndView delete(ModelAndView modelAndView,
                               @PathVariable(value = "id") Integer id) {
        modelAndView.setViewName("home");
        discountService.delete(id);
        return modelAndView;
    }


    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    public ModelAndView update(@ModelAttribute Discount discount,
                               ModelAndView modelAndView) {
        modelAndView.setViewName("home");
        discountService.update(discount);
        return modelAndView;
    }
}
