package com.cbs.edu.eshop.servlets;

import com.cbs.edu.eshop.service.IProductService;
import com.cbs.edu.eshop.service.impl.IProductServiceImpl;

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
        this.productService = new IProductServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("products", productService.getAllProducts());
        req.getRequestDispatcher("/home.jsp").forward(req, resp);
    }
}
