package com.cbsystematics.edu.internet_shop.dao.impl;

import com.cbsystematics.edu.internet_shop.dao.UserDetailsDAO;
import com.cbsystematics.edu.internet_shop.entities.UserDetails;

public class UserDetailsDAOImpl extends AbstractDAOImpl<UserDetails> implements UserDetailsDAO {

    private static final String GET_ALL_USERS_QUERY = "select u from UserDetails u";

//    EntityManager em = Connection.getEntityManager();
//
//
//    @Override
//    public UserDetails get(Integer id) {
//        EntityTransaction transaction = em.getTransaction();
//        transaction.begin();
//
//        UserDetails userDetails = em.find(UserDetails.class, id);
//
//        transaction.commit();
//        return userDetails;
//    }
//
//    @Override
//    public UserDetails create(UserDetails userDetails) {
//        EntityTransaction transaction = em.getTransaction();
//        transaction.begin();
//
//        em.persist(userDetails);
//
//        transaction.commit();
//        return userDetails;
//    }
//
//    @Override
//    public UserDetails update(UserDetails userDetails) {
//        EntityTransaction transaction = em.getTransaction();
//        transaction.begin();
//
//        em.merge(userDetails);
//
//        transaction.commit();
//        return userDetails;
//    }
//
//    @Override
//    public void delete(Integer id) {
//        EntityTransaction transaction = em.getTransaction();
//        transaction.begin();
//
//        UserDetails userDetails = em.find(UserDetails.class, id);
//        em.remove(userDetails);
//
//        transaction.commit();
//    }
//
//    @Override
//    public List<UserDetails> getAll() {
//        EntityTransaction transaction = em.getTransaction();
//        transaction.begin();
//
//        Query query = em.createQuery(GET_ALL_USERS_QUERY);
//        List userDetailsList = query.getResultList();
//
//        transaction.commit();
//        return userDetailsList;
//    }
}
