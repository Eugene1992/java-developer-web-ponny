package com.cbsystematics.edu.internet_shop.service;

import com.cbsystematics.edu.internet_shop.dto.request.ProductCreationRequestDto;
import com.cbsystematics.edu.internet_shop.entity.Product;
import com.cbsystematics.edu.internet_shop.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final IProductRepository productRepository;

    @Autowired
    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product get(Integer id) {
        return productRepository.get(id);
    }

    public Product create(ProductCreationRequestDto productDTO) {
        Product product = new Product(
                productDTO.getTitle(),
                productDTO.getDescription(),
                productDTO.getCategory(),
                productDTO.getPrice(),
                productDTO.getImgUrl()
        );
        return productRepository.create(product);
    }

    public Product update(Product product) {
        return productRepository.update(product);
    }

    public void delete(Integer id) {
        productRepository.delete(id);
    }

    public List<Product> getAll() {
        return productRepository.getAll();
    }
}
