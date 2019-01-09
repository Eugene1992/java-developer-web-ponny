package com.cbsystematics.edu.internet_shop.service;

import com.cbsystematics.edu.internet_shop.dao.jdbc.ProductDAO;
import com.cbsystematics.edu.internet_shop.dao.jdbc.impl.JDBCProductDAO;
import com.cbsystematics.edu.internet_shop.entities.Product;

import java.util.List;

public class ServiceForProducts implements DAOService<Product> {

    public List<Product> getAll() {
        ProductDAO productDAO = new JDBCProductDAO();
        return productDAO.getAll();
    }

    public Product get(Integer id) {
        ProductDAO productDAO = new JDBCProductDAO();
        return productDAO.get(id);
    }

    public void delete(Integer id) {
        ProductDAO productDAO = new JDBCProductDAO();
        productDAO.delete(id);
    }

    public void update(Product product) {
        ProductDAO productDAO = new JDBCProductDAO();
        productDAO.update(product);
    }

    public Product create(Product product) {
        ProductDAO productDAO = new JDBCProductDAO();
        product.setId(getNextIdForNewElem(productDAO.getAll()));
        productDAO.create(product);
        return product;
    }
}
