package com.cbsystematics.edu.internet_shop.servlets;

import com.cbsystematics.edu.internet_shop.entities.Product;
import com.cbsystematics.edu.internet_shop.service.IShoppingCartService;
import com.cbsystematics.edu.internet_shop.service.impl.ShoppingCartService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/shopping-cart")
public class ShoppingCartServlet extends HttpServlet {

    private IShoppingCartService shoppingCartService;

    public ShoppingCartServlet() {
        this.shoppingCartService = new ShoppingCartService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action.equals("add")) {
            int productId = Integer.parseInt(req.getParameter("id"));
            shoppingCartService.addToCart(productId, req, resp);
        }

        List<Product> allCartProducts = shoppingCartService.getAllCartProducts();
        req.setAttribute("shopping_cart_products", allCartProducts);

        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
