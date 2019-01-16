package com.cbs.edu.eshop.dao.impl;

import com.cbs.edu.eshop.config.JPAUtil;
import com.cbs.edu.eshop.dao.IProductDAO;
import com.cbs.edu.eshop.entity.AbstractEntity;
import com.cbs.edu.eshop.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class IProductDAOImpl implements IProductDAO<Product> {

    private EntityManager entityManager;

    public IProductDAOImpl() {
        this.entityManager = JPAUtil.getEntityManager("com.cbs.edu.jpa");
    }

    @Override
    public Product get(Integer id) {
        return null;
    }

    @Override
    public Product create(Product entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(entity);
        transaction.commit();
        return entity;
    }

    @Override
    public Product update(Product entity) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Product> getAll() {
        return null;
    }
}
