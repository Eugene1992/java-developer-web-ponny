package com.cbsystematics.edu.internet_shop.service;

import com.cbsystematics.edu.internet_shop.dao.jdbc.ProductDAO;
import com.cbsystematics.edu.internet_shop.dao.jdbc.impl.JDBCProductDAO;
import com.cbsystematics.edu.internet_shop.entities.Product;

import java.util.List;

public class ProductService extends AbstractService implements IProductService {

    private ProductDAO productDAO;

    public ProductService() {
        this.productDAO = new JDBCProductDAO();
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
        product.setId(getNextIdForNewElem(productDAO.getAll()));
        productDAO.create(product);
        return product;
    }
}
