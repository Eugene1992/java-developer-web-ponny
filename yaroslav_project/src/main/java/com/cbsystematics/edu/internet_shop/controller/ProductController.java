package com.cbsystematics.edu.internet_shop.controller;

import com.cbsystematics.edu.internet_shop.dto.request.ProductCreationRequestDto;
import com.cbsystematics.edu.internet_shop.entity.Product;
import com.cbsystematics.edu.internet_shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute ProductCreationRequestDto productCreationRequestDto,
                               ModelAndView modelAndView) {
        modelAndView.setViewName("home");
        productService.create(productCreationRequestDto);
        return modelAndView;
    }


    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ModelAndView getAll(ModelAndView modelAndView) {
        modelAndView.setViewName("home");
        productService.getAll();
        return modelAndView;
    }


    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public ModelAndView get(ModelAndView modelAndView,
                            @PathVariable(value = "id") Integer id) {
        modelAndView.setViewName("home");
        productService.get(id);
        return modelAndView;
    }


    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public ModelAndView delete(ModelAndView modelAndView,
                            @PathVariable(value = "id") Integer id) {
        modelAndView.setViewName("home");
        productService.delete(id);
        return modelAndView;
    }


    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public ModelAndView update(@ModelAttribute Product product,
                               ModelAndView modelAndView) {
        modelAndView.setViewName("home");
        productService.update(product);
        return modelAndView;
    }
}
