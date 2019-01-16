package com.cbsystematics.edu.internet_shop.service.impl;

import com.cbsystematics.edu.internet_shop.dao.ProductDAO;
import com.cbsystematics.edu.internet_shop.dao.impl.ProductDAOImpl;
import com.cbsystematics.edu.internet_shop.entities.Product;
import com.cbsystematics.edu.internet_shop.service.IProductService;

import java.util.List;

public class ProductService implements IProductService {

    private ProductDAO productDAO;

    public ProductService() {
        this.productDAO = new ProductDAOImpl();
    }

    @Override
    public List<Product> getAll() {
        return productDAO.getAll();
    }

    @Override
    public Product get(Integer id) {
        return productDAO.get(id);
    }

    @Override
    public void delete(Integer id) {
        productDAO.delete(id);
    }

    @Override
    public void update(Product product) {
        productDAO.update(product);
    }

    @Override
    public Product create(Product product) {
        productDAO.create(product);
        return product;
    }
}
