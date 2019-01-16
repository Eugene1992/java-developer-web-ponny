package com.cbsystematics.edu.internet_shop.service;

import com.cbsystematics.edu.internet_shop.entities.Order;

import java.util.List;

public interface IOrderService {

    List<Order> getAll();

    Order get(Integer id);

    void delete(Integer id);

    void update(Order order);

    Order create(Order order);
}
