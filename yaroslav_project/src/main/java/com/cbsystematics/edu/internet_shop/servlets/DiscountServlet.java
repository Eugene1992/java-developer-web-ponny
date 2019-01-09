package com.cbsystematics.edu.internet_shop.servlets;


import com.cbsystematics.edu.internet_shop.entities.Discount;
import com.cbsystematics.edu.internet_shop.service.DAOService;
import com.cbsystematics.edu.internet_shop.service.ServiceForDiscounts;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DiscountServlet extends HttpServlet {

    private static DAOService service = new ServiceForDiscounts();
    private static final List<Discount> discounts = service.getAll();
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
                        Discount deleteDiscount = (Discount) service.getElemByDatabaseId(idParam, discounts);
                        discounts.remove(deleteDiscount);
                        service.delete(deleteDiscount.getId());
                    }
                    break;
                }
                case "update": {
                    String idParam = req.getParameter("id");
                    if(idParam != null && !idParam.isEmpty()) {
                        Discount updDiscount = (Discount) service.getElemByDatabaseId(idParam, discounts);
                        req.setAttribute("updDiscount", updDiscount);
                        req.getRequestDispatcher("/new_discount.jsp").forward(req, resp);
                    }
                    break;
                }
            }
        }

        req.setAttribute("discounts", discounts);
        req.getRequestDispatcher("/discounts.jsp").forward(req, resp);
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
            discounts.set(service.getListIdByDatabaseId(idParam, discounts), discount);
            service.update(discount);
        } else {
            discount = new Discount(0, name, amount);
            discount = (Discount) service.create(discount);
            discounts.add(discount);
        }

        req.setAttribute("discounts", discounts);
        req.getRequestDispatcher("/discounts.jsp").forward(req, resp);
    }
}
