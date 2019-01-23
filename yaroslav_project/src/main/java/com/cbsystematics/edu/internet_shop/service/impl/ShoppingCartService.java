package com.cbsystematics.edu.internet_shop.service.impl;

import com.cbsystematics.edu.internet_shop.entities.Product;
import com.cbsystematics.edu.internet_shop.service.IProductService;
import com.cbsystematics.edu.internet_shop.service.IShoppingCartService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartService implements IShoppingCartService {

    private IProductService productService;

    public ShoppingCartService() {
        this.productService = new ProductService();
    }

    @Override
    public void addToCart(int productId, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product product = productService.get(productId);

        response.addCookie(new Cookie("shopping_cart_products", product.getId().toString()));

        response.sendRedirect("/home");
    }

    @Override
    public List<Product> getAllCartProducts(HttpServletRequest request) {
        List<Product> products = new ArrayList<>();

        return products;
    }
}
