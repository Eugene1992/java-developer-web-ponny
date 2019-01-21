package com.cbsystematics.edu.internet_shop.servlets;


import com.cbsystematics.edu.internet_shop.entities.Product;
import com.cbsystematics.edu.internet_shop.service.IProductService;
import com.cbsystematics.edu.internet_shop.service.impl.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/admin/products",
        initParams = {
                @WebInitParam(name = "productPaginationSize", value = "10")
        })
public class ProductServlet extends HttpServlet {

    private IProductService service = new ProductService();

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
                        service.delete(Integer.parseInt(idParam));
                    }
                    break;
                }
                case "update": {
                    String idParam = req.getParameter("id");
                    if(idParam != null && !idParam.isEmpty()) {
                        Product updProduct = service.get(Integer.parseInt(idParam));
                        req.setAttribute("updProduct", updProduct);
                        req.getRequestDispatcher("/new_product.jsp").forward(req, resp);
                    }
                    break;
                }
            }
        }

        req.setAttribute("products", service.getAll());
        req.getRequestDispatcher("/admin.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        Integer price = Integer.valueOf(req.getParameter("price"));
        String category = req.getParameter("category");
        String imgUrl = req.getParameter("imgUrl");

        int id;
        Product product;
        String idParam = req.getParameter("id");
        if (idParam != null && !idParam.isEmpty()) {
            id = Integer.parseInt(idParam);
            product = new Product(id, title, description, category, price, imgUrl);
            service.update(product);
        } else {
            product = new Product(title, description, category, price, imgUrl);
            service.create(product);
        }

        req.setAttribute("products", service.getAll());
        resp.sendRedirect("/admin");
    }
}
