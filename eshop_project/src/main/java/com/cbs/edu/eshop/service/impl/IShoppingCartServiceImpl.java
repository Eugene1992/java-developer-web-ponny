package com.cbs.edu.eshop.service.impl;

import com.cbs.edu.eshop.entity.Product;
import com.cbs.edu.eshop.service.IProductService;
import com.cbs.edu.eshop.service.IShoppingCartService;
import com.sun.org.apache.xalan.internal.xsltc.cmdline.Compile;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IShoppingCartServiceImpl implements IShoppingCartService {

    private IProductService productService;

    public IShoppingCartServiceImpl() {
        this.productService = new IProductServiceImpl();
    }

    @Override
    public void addToCart(int productId, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product product = productService.getProduct(productId);

        response.addCookie(new Cookie("shopping_cart_products", product.getId().toString()));

        response.sendRedirect("/home");
    }

    @Override
    public List<Product> getAllCartProducts() {
        return null;
    }
}
