package com.cbsystematics.edu.internet_shop.servlets;

import com.cbsystematics.edu.internet_shop.service.IProductService;
import com.cbsystematics.edu.internet_shop.service.impl.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    private IProductService productService;

    public HomeServlet() {
        this.productService = new ProductService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("products", productService.getAll());
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
