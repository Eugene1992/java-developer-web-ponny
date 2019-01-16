package com.cbsystematics.edu.internet_shop.service.impl;

import com.cbsystematics.edu.internet_shop.dao.OrderDAO;
import com.cbsystematics.edu.internet_shop.dao.impl.OrderDAOImpl;
import com.cbsystematics.edu.internet_shop.entities.Order;
import com.cbsystematics.edu.internet_shop.service.IOrderService;

import java.util.List;

public class OrderService implements IOrderService {

    private OrderDAO orderDAO;

    public OrderService() {
        this.orderDAO = new OrderDAOImpl();
    }


    @Override
    public List<Order> getAll() {
        return orderDAO.getAll();
    }

    @Override
    public Order get(Integer id) {
        return orderDAO.get(id);
    }

    @Override
    public void delete(Integer id) {
        orderDAO.delete(id);
    }

    @Override
    public void update(Order order) {
        orderDAO.update(order);
    }

    @Override
    public Order create(Order order) {
        orderDAO.create(order);
        return order;
    }
}
