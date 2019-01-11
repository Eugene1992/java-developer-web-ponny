package com.cbsystematics.edu.internet_shop.dao.hibernate.impl;

import com.cbsystematics.edu.internet_shop.dao.hibernate.RoleDAO;
import com.cbsystematics.edu.internet_shop.entities.Role;

public class RoleDAOImpl extends AbstractDAOImpl<Role> implements RoleDAO {


//    private static final String GET_ALL_USERS_QUERY = "select r from Role r";
//
//    private EntityManager em = ConnectionFactory.getEntityManager();
//
//    @Override
//    public Role get(Integer id) {
//        EntityTransaction transaction = em.getTransaction();
//        transaction.begin();
//
//        Role role = em.find(Role.class, id);
//
//        transaction.commit();
//        return role;
//    }
//
//    @Override
//    public Role create(Role role) {
//        EntityTransaction transaction = em.getTransaction();
//        transaction.begin();
//
//        em.persist(role);
//
//        transaction.commit();
//        return role;
//    }
//
//    @Override
//    public Role update(Role role) {
//        EntityTransaction transaction = em.getTransaction();
//        transaction.begin();
//
//        em.merge(role);
//
//        transaction.commit();
//        return role;
//    }
//
//    @Override
//    public void delete(Integer id) {
//        EntityTransaction transaction = em.getTransaction();
//        transaction.begin();
//
//        Role role = em.find(Role.class, id);
//        em.remove(role);
//
//        transaction.commit();
//    }
//
//    @Override
//    public List<Role> getAll() {
//        EntityTransaction transaction = em.getTransaction();
//        transaction.begin();
//
//        Query query = em.createQuery(GET_ALL_USERS_QUERY);
//        List roles = query.getResultList();
//
//        transaction.commit();
//        return roles;
//    }

}
