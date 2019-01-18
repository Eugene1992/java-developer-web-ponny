package com.cbs.edu.eshop.servlets;

import com.cbs.edu.eshop.entity.Product;
import com.cbs.edu.eshop.service.IShoppingCartService;
import com.cbs.edu.eshop.service.impl.IShoppingCartServiceImpl;

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
        this.shoppingCartService = new IShoppingCartServiceImpl();
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

        req.getRequestDispatcher("/").forward(req, resp);
    }
}
