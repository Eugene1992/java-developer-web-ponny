package com.cbsystematics.edu.internet_shop.servlets;


import com.cbsystematics.edu.internet_shop.entities.Product;
import com.cbsystematics.edu.internet_shop.service.DAOService;
import com.cbsystematics.edu.internet_shop.service.ServiceForProducts;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProductServlet extends HttpServlet {

    private static DAOService service = new ServiceForProducts();
    private static final List<Product> products = service.getAll();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reqParameter = req.getParameter("action");
        if (reqParameter != null && !reqParameter.isEmpty()) {
            switch (reqParameter) {
                case "create": {
                    req.getRequestDispatcher("/new_product.jsp").forward(req, resp);
                    break;
                }
                case "delete": {
                    String idParam = req.getParameter("id");
                    if(idParam != null && !idParam.isEmpty()) {
                        Product deleteProduct = (Product) service.getElemByDatabaseId(idParam, products);
                        products.remove(deleteProduct);
                        service.delete(deleteProduct.getId());
                    }
                    break;
                }
                case "update": {
                    String idParam = req.getParameter("id");
                    if(idParam != null && !idParam.isEmpty()) {
                        Product updProduct = (Product) service.getElemByDatabaseId(idParam, products);
                        req.setAttribute("updProduct", updProduct);
                        req.getRequestDispatcher("/new_product.jsp").forward(req, resp);
                    }
                    break;
                }
            }
        }

        req.setAttribute("products", products);
        req.getRequestDispatcher("/products.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        Integer price = Integer.valueOf(req.getParameter("price"));
        String category = req.getParameter("category");

        int id;
        Product product;
        String idParam = req.getParameter("id");
        if (idParam != null && !idParam.isEmpty()) {
            id = Integer.parseInt(idParam);
            product = new Product(id, title, description, category, price);
            products.set(service.getListIdByDatabaseId(idParam, products), product);
            service.update(product);
        } else {
            product = new Product(0, title, description, category, price);
            product = (Product) service.create(product);
            products.add(product);
        }

        req.setAttribute("products", products);
        req.getRequestDispatcher("/products.jsp").forward(req, resp);
    }
}
