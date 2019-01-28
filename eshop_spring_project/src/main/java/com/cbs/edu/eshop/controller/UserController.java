package com.cbs.edu.eshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


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

}
