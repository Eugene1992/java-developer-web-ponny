package com.cbs.edu.eshop.dao;

import com.cbs.edu.eshop.config.ConnectionFactory;
import com.cbs.edu.eshop.config.JPAUtil;
import com.cbs.edu.eshop.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class IUserDAOImpl implements IUserDAO<User> {

    private EntityManager entityManager;

    public IUserDAOImpl() {
        this.entityManager = JPAUtil.getEntityManager("com.cbs.edu.jpa");
    }

    @Override
    public User get(Integer id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User create(User entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(entity);
        transaction.commit();
        return entity;
    }

    @Override
    public User update(User entity) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<User> getAll() {
        return entityManager.createQuery("select u from User u").getResultList();
    }
}
