package com.cbs.edu.jdbc.examples.structure.dao.impl;

import com.cbs.edu.jdbc.examples.structure.dao.AbstractDAO;
import com.cbs.edu.jdbc.examples.structure.dao.ProductDAO;
import com.cbs.edu.jdbc.examples.structure.entities.Product;

public class ProductDAOImpl extends AbstractDAO<Product> implements ProductDAO {
    @Override
    public Product getBySerialNumber(Integer number) {
        return null;
    }

    @Override
    public Product get(Integer id) {
        return null;
    }

    @Override
    public Product create(Product entity) {
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
