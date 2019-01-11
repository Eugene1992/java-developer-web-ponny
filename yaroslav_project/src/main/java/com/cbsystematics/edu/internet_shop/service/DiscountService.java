package com.cbsystematics.edu.internet_shop.service;

import com.cbsystematics.edu.internet_shop.dao.jdbc.DiscountDAO;
import com.cbsystematics.edu.internet_shop.dao.jdbc.impl.JDBCDiscountDAO;
import com.cbsystematics.edu.internet_shop.entities.Discount;

import java.util.List;

public class DiscountService extends AbstractService implements IDiscountService {

    private DiscountDAO discountDAO;

    public DiscountService() {
        this.discountDAO = new JDBCDiscountDAO();
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
        discount.setId(getNextIdForNewElem(discountDAO.getAll()));
        discountDAO.create(discount);
        return discount;
    }

}
