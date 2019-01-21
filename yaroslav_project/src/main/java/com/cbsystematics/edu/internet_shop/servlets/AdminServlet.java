package com.cbsystematics.edu.internet_shop.servlets;

import com.cbsystematics.edu.internet_shop.service.IDiscountService;
import com.cbsystematics.edu.internet_shop.service.IProductService;
import com.cbsystematics.edu.internet_shop.service.IUserService;
import com.cbsystematics.edu.internet_shop.service.impl.DiscountService;
import com.cbsystematics.edu.internet_shop.service.impl.ProductService;
import com.cbsystematics.edu.internet_shop.service.impl.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

    private IProductService productService;
    private IUserService userService;
    private IDiscountService discountService;

    public AdminServlet() {
        this.productService = new ProductService();
        this.userService = new UserService();
        this.discountService = new DiscountService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("products", productService.getAll());
        req.setAttribute("users", userService.getAll());
        req.setAttribute("discounts", discountService.getAll());
        req.getRequestDispatcher("/admin.jsp").forward(req, resp);
    }
}
