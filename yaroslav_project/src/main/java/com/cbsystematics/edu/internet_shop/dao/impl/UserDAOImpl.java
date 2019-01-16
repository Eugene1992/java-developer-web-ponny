package com.cbsystematics.edu.internet_shop.dao.impl;


import com.cbsystematics.edu.internet_shop.config.JPAUtil;
import com.cbsystematics.edu.internet_shop.dao.UserDAO;
import com.cbsystematics.edu.internet_shop.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;


public class UserDAOImpl implements UserDAO {

    private static final String GET_ALL_USERS_QUERY = "select u from User u";
    private EntityManager em;

    public UserDAOImpl() {
        this.em = JPAUtil.getEntityManager("com.cbs.edu.jpa");
    }

    @Override
    public User get(Integer id) {
        return em.find(User.class, id);
    }

    @Override
    public User create(User user) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            em.persist(user);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return user;
    }

    @Override
    public User update(User user) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            User oldUser = em.find(User.class, user.getId());
            oldUser.setPassword(user.getPassword());
            oldUser.setUsername(user.getUsername());
            oldUser.setRole(user.getRole());
            oldUser.setUserDetails(user.getUserDetails());
            em.merge(user);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return user;
    }

    @Override
    public void delete(Integer id) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            User user = em.find(User.class, id);
            em.remove(user);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    @Override
    public List<User> getAll() {
        Query query = em.createQuery(GET_ALL_USERS_QUERY);
        return query.getResultList();
    }

    @Override
    public int getUserDetailsIdByUserId(Integer id) {
        User user = em.find(User.class, id);
        return user.getUserDetails().getId();
    }
}
