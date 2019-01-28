package com.cbsystematics.edu.internet_shop.repository.impl;

import com.cbsystematics.edu.internet_shop.entity.Product;
import com.cbsystematics.edu.internet_shop.repository.IProductRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ProductRepository implements IProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Product get(Integer id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public Product create(Product product) {
        entityManager.persist(product);
        return get(product.getId());
    }

    @Override
    public Product update(Product product) {
        entityManager.merge(product);
        return product;
    }

    @Override
    public void delete(Integer id) {
        Product product = entityManager.find(Product.class, id);
        entityManager.remove(product);
    }

    @Override
    public List<Product> getAll() {
        return entityManager.createQuery("select p from Product p")
                .getResultList();
    }
}
