package com.cbsystematics.edu.internet_shop.dao.impl;

import com.cbsystematics.edu.internet_shop.config.JPAUtil;
import com.cbsystematics.edu.internet_shop.dao.UserDetailsDAO;
import com.cbsystematics.edu.internet_shop.entities.UserDetails;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class UserDetailsDAOImpl implements UserDetailsDAO {

    private static final String GET_ALL_USERS_QUERY = "select u from UserDetails u";
    private EntityManager em;

    public UserDetailsDAOImpl() {
        this.em = JPAUtil.getEntityManager("com.cbs.edu.jpa");
    }


    @Override
    public UserDetails get(Integer id) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        UserDetails userDetails = em.find(UserDetails.class, id);

        transaction.commit();
        return userDetails;
    }

    @Override
    public UserDetails create(UserDetails userDetails) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            em.persist(userDetails);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return userDetails;
    }

    @Override
    public UserDetails update(UserDetails userDetails) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            UserDetails oldUserDetails = em.find(UserDetails.class, userDetails.getId());
            oldUserDetails.setFirstName(userDetails.getFirstName());
            oldUserDetails.setLastName(userDetails.getLastName());
            oldUserDetails.setEmail(userDetails.getEmail());
            oldUserDetails.setPhone(userDetails.getPhone());
            em.merge(oldUserDetails);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return userDetails;
    }

    @Override
    public void delete(Integer id) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            UserDetails userDetails = em.find(UserDetails.class, id);
            em.remove(userDetails);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    @Override
    public List<UserDetails> getAll() {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Query query = em.createQuery(GET_ALL_USERS_QUERY);
        List userDetailsList = query.getResultList();

        transaction.commit();
        return userDetailsList;
    }
}
