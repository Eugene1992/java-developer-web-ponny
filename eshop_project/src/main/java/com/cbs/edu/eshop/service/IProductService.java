package com.cbs.edu.eshop.service;

import com.cbs.edu.eshop.dto.CreateProductDTO;
import com.cbs.edu.eshop.entity.Product;

import java.util.List;

public interface IProductService {
    Product createProduct(CreateProductDTO user);

    Product updateProduct(Product product);

    Product getProduct(Integer id);

    List<Product> getAllProducts();

    void deleteProduct(Integer id);
}
