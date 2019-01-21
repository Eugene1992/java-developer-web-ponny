package com.cbsystematics.edu.internet_shop.servlets;


import com.cbsystematics.edu.internet_shop.entities.Discount;
import com.cbsystematics.edu.internet_shop.service.impl.DiscountService;
import com.cbsystematics.edu.internet_shop.service.IDiscountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/admin/discounts",
        initParams = {
                @WebInitParam(name = "discountPaginationSize", value = "10")
        })
public class DiscountServlet extends HttpServlet {

    private IDiscountService service = new DiscountService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reqParameter = req.getParameter("action");
        if (reqParameter != null && !reqParameter.isEmpty()) {
            switch (reqParameter) {
                case "create": {
                    req.getRequestDispatcher("/new_discount.jsp").forward(req, resp);
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
                        Discount updDiscount = service.get(Integer.parseInt(idParam));
                        req.setAttribute("updDiscount", updDiscount);
                        req.getRequestDispatcher("/new_discount.jsp").forward(req, resp);
                    }
                    break;
                }
            }
        }

        req.setAttribute("discounts", service.getAll());
        req.getRequestDispatcher("/admin.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        double amount = Double.parseDouble(req.getParameter("amount"));

        int id;
        Discount discount;
        String idParam = req.getParameter("id");
        if (idParam != null && !idParam.isEmpty()) {
            id = Integer.parseInt(idParam);
            discount = new Discount(id, name, amount);
            service.update(discount);
        } else {
            discount = new Discount(name, amount);
            service.create(discount);
        }

        req.setAttribute("discounts", service.getAll());
        resp.sendRedirect("/admin");
    }
}
