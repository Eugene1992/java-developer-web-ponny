package com.cbsystematics.edu.internet_shop.service;

import com.cbsystematics.edu.internet_shop.entities.Discount;

import java.util.List;

public interface IDiscountService {

    List<Discount> getAll();

    Discount get(Integer id);

    void delete(Integer id);

    void update(Discount discount);

    Discount create(Discount discount);

}
