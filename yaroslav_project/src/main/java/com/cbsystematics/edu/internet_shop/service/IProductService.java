package com.cbsystematics.edu.internet_shop.service;

import com.cbsystematics.edu.internet_shop.entities.Product;

import java.util.List;

public interface IProductService {

    List<Product> getAll();

    Product get(Integer id);

    void delete(Integer id);

    void update(Product product);

    Product create(Product product);
}
