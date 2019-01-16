package com.cbs.edu.eshop.service.impl;

import com.cbs.edu.eshop.dao.impl.IProductDAOImpl;
import com.cbs.edu.eshop.dto.CreateProductDTO;
import com.cbs.edu.eshop.entity.Product;
import com.cbs.edu.eshop.service.IProductService;

import java.util.List;

public class IProductServiceImpl implements IProductService {

    private IProductDAOImpl productDAO;

    public IProductServiceImpl() {
        this.productDAO = new IProductDAOImpl();
    }

    @Override
    public Product createProduct(CreateProductDTO userDTO) {

        final Product product = new Product(
                userDTO.getTitle(),
                userDTO.getImgUrl(),
                userDTO.getDescription(),
                userDTO.getCategory(),
                Integer.parseInt(userDTO.getPrice())
        );

        return productDAO.create(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return null;
    }

    @Override
    public Product getUser(Integer id) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public void deleteProduct(Integer id) {

    }
}
