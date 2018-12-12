package com.cbs.edu.jdbc.examples.structure.dao;

import com.cbs.edu.jdbc.examples.structure.entities.Product;

public interface ProductDAO extends DAO<Product>{
    Product getBySerialNumber(Integer number);
}