package com.cbsystematics.edu.internet_shop.dao.hibernate.impl;


import com.cbsystematics.edu.internet_shop.dao.hibernate.UserDAO;
import com.cbsystematics.edu.internet_shop.entities.User;

public class UserDAOImpl extends AbstractDAOImpl<User> implements UserDAO {

//    @Override
//    public User get(Integer id) {
//        EntityTransaction transaction = em.getTransaction();
//        transaction.begin();
//
//        User user = em.find(User.class, id);
//
//        transaction.commit();
//        return user;
//    }
//
//    @Override
//    public User create(User user) {
//        EntityTransaction transaction = em.getTransaction();
//        transaction.begin();
//
//        em.persist(user);
//
//        transaction.commit();
//        return user;
//    }
//
//    @Override
//    public User update(User user) {
//        EntityTransaction transaction = em.getTransaction();
//        transaction.begin();
//
//        em.merge(user);
//
//        transaction.commit();
//        return user;
//    }
//
//    @Override
//    public void delete(Integer id) {
//        EntityTransaction transaction = em.getTransaction();
//        transaction.begin();
//
//        User user = Connection.getEntityManager().find(User.class, id);
//        em.remove(user);
//
//        transaction.commit();
//    }
//
//    @Override
//    public List<User> getAll() {
//        EntityTransaction transaction = em.getTransaction();
//        transaction.begin();
//
//        Query query = em.createQuery(GET_ALL_USERS_QUERY);
//        List users = query.getResultList();
//
//        transaction.commit();
//        return users;
//    }
}
