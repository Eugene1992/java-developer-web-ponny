package com.cbsystematics.edu.eshop.dao;

import com.cbsystematics.edu.eshop.config.ConnectionFactory;
import com.cbsystematics.edu.eshop.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class IUserDAOImpl implements IUserDAO<User> {

    private EntityManager entityManager;

    public IUserDAOImpl() {
        this.entityManager = ConnectionFactory.getEntityManager();
    }

    @Override
    public User get(Integer id) {
        return entityManager.find(User.class,id);
    }

    @Override
    public User create(User user) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(user);
        transaction.commit();
        return user;
    }

    @Override
    public User update(User user) {
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
