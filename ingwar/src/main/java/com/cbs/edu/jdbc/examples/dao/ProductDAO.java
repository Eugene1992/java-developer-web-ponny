package com.cbs.edu.jdbc.examples.dao;

import com.cbs.edu.jdbc.objects.Product;

public interface ProductDAO extends DAO<Product> {
    Product getBySerialNumber(String number);
}
