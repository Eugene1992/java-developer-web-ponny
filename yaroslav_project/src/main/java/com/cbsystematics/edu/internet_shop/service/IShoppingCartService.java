package com.cbsystematics.edu.internet_shop.service;

import com.cbsystematics.edu.internet_shop.entities.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface IShoppingCartService {

    void addToCart(int productId, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    List<Product> getAllCartProducts(HttpServletRequest request);
}
