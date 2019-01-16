package com.cbsystematics.edu.internet_shop.service.impl;

import com.cbsystematics.edu.internet_shop.dao.DiscountDAO;
import com.cbsystematics.edu.internet_shop.dao.impl.DiscountDAOImpl;
import com.cbsystematics.edu.internet_shop.entities.Discount;
import com.cbsystematics.edu.internet_shop.service.IDiscountService;

import java.util.List;


public class DiscountService implements IDiscountService {

    private DiscountDAO discountDAO;

    public DiscountService() {
        this.discountDAO = new DiscountDAOImpl();
    }

    @Override
    public List<Discount> getAll() {
        return discountDAO.getAll();
    }

    @Override
    public Discount get(Integer id) {
        return discountDAO.get(id);
    }

    @Override
    public void delete(Integer id) {
        discountDAO.delete(id);
    }

    @Override
    public void update(Discount discount) {
        discountDAO.update(discount);
    }

    @Override
    public Discount create(Discount discount) {
        discountDAO.create(discount);
        return discount;
    }



}
