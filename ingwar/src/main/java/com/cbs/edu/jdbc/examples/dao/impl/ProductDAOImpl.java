package com.cbs.edu.jdbc.examples.dao.impl;

import com.cbs.edu.jdbc.examples.dao.AbstractDAO;
import com.cbs.edu.jdbc.examples.dao.ProductDAO;
import com.cbs.edu.jdbc.objects.Product;

public class ProductDAOImpl extends AbstractDAO<Product> implements ProductDAO {

    @Override
    public Product getBySerialNumber(String number) {
        return null;
    }

    @Override
    public Product get(Integer id) {
        return null;
    }

    @Override
    public Product cteate(Product entity) {
        return null;
    }

    @Override
    public Product update(Product entity) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
