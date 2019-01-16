package com.cbsystematics.edu.internet_shop.dao.impl;

import com.cbsystematics.edu.internet_shop.config.JPAUtil;
import com.cbsystematics.edu.internet_shop.dao.ProductDAO;
import com.cbsystematics.edu.internet_shop.entities.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {

    private static final String GET_ALL_PRODUCTS_QUERY = "select p from Product p";
    private EntityManager em;

    public ProductDAOImpl() {
        this.em = JPAUtil.getEntityManager("com.cbs.edu.jpa");
    }

    @Override
    public Product get(Integer id) {
        return em.find(Product.class, id);
    }

    @Override
    public Product create(Product product) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            em.persist(product);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return product;
    }

    @Override
    public Product update(Product product) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Product oldProduct = em.find(Product.class, product.getId());
            oldProduct.setTitle(product.getTitle());
            oldProduct.setDescription(product.getDescription());
            oldProduct.setPrice(product.getPrice());
            oldProduct.setCategory(product.getCategory());

            em.merge(oldProduct);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return product;
    }

    @Override
    public void delete(Integer id) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            Product product = em.find(Product.class, id);
            em.remove(product);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    @Override
    public List<Product> getAll() {
        Query query = em.createQuery(GET_ALL_PRODUCTS_QUERY);
        return query.getResultList();
    }
}
