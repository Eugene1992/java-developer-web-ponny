package com.cbs.edu.eshop.servlets;

import com.cbs.edu.eshop.dto.CreateProductDTO;
import com.cbs.edu.eshop.service.IProductService;
import com.cbs.edu.eshop.service.impl.IProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/products")
public class ProductServlet extends HttpServlet {

    private IProductService productService;

    public ProductServlet() {
        this.productService = new IProductServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action.equals("create")) {
            req.getRequestDispatcher("/new_product_form.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action.equals("create")) {
            String title = req.getParameter("title");
            String description = req.getParameter("description");
            String imgUrl = req.getParameter("img_url");
            String category = req.getParameter("category");
            String price = req.getParameter("price");

            CreateProductDTO productDTO = new CreateProductDTO(title, description, imgUrl, category, price);

            productService.createProduct(productDTO);
        }

        resp.sendRedirect("/admin/products");
    }
}
