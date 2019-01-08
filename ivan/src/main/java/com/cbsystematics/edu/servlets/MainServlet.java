package com.cbsystematics.edu.servlets;

import com.cbsystematics.edu.entities.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static java.util.Arrays.asList;

public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = asList(
                new Product(0, "IPhone X 256 GB", "Phone", "This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.", 40_000),
                new Product(1, "IPhone X 256 GB", "Phone", "This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.", 40_000),
                new Product(2, "IPhone X 256 GB", "Phone", "This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.", 40_000),
                new Product(3, "IPhone X 256 GB", "Phone", "This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.", 40_000)
        );

        req.setAttribute("products", products);
        req.getRequestDispatcher("/main.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
