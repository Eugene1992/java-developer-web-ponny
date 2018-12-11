package com.cbs.edu.structure.dao;

import com.cbs.edu.structure.entities.Product;

public interface ProductDAO extends DAO<Product>{
    Product getBySerialNumber(Integer number);
}