package com.cbsystematics.edu.internet_shop.service;

import com.cbsystematics.edu.internet_shop.dao.jdbc.DiscountDAO;
import com.cbsystematics.edu.internet_shop.dao.jdbc.impl.JDBCDiscountDAO;
import com.cbsystematics.edu.internet_shop.entities.Discount;

import java.util.List;

public class ServiceForDiscounts implements DAOService<Discount> {

    public List<Discount> getAll() {
        DiscountDAO discountDAO = new JDBCDiscountDAO();
        return discountDAO.getAll();
    }

    public Discount get(Integer id) {
        DiscountDAO discountDAO = new JDBCDiscountDAO();
        return discountDAO.get(id);
    }

    public void delete(Integer id) {
        DiscountDAO discountDAO = new JDBCDiscountDAO();
        discountDAO.delete(id);
    }

    public void update(Discount discount) {
        DiscountDAO productDAO = new JDBCDiscountDAO();
        productDAO.update(discount);
    }

    public Discount create(Discount discount) {
        DiscountDAO discountDAO = new JDBCDiscountDAO();
        discount.setId(getNextIdForNewElem(discountDAO.getAll()));
        discountDAO.create(discount);
        return discount;
    }

}
