package com.cbsystematics.edu.internet_shop.dao.hibernate.impl;

import com.cbsystematics.edu.internet_shop.config.Connection;
import com.cbsystematics.edu.internet_shop.dao.hibernate.DAO;
import com.cbsystematics.edu.internet_shop.entities.AbstractEntity;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class AbstractDAOImpl<T extends AbstractEntity> implements DAO<T> {

    private EntityManager em = Connection.getEntityManager();


    private static final String GET_ALL_QUERY = "select * from %S";


    @Override
    public T get(Integer id, Class<T> clazz) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        T t = em.find(clazz, id);

        transaction.commit();
        return t;
    }

    @Override
    public T create(T elem) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(elem);

        transaction.commit();
        return elem;
    }

    @Override
    public T update(T elem) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.merge(elem);

        transaction.commit();
        return elem;
    }

    @Override
    public void delete(Integer id, Class<T> clazz) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        T elem = em.find(clazz, id);
        em.remove(elem);

        transaction.commit();
    }

    @Override
    public List<T> getAll(Class<T> clazz) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        System.out.println("===============" + clazz.getSimpleName());
        //Query query = em.createNativeQuery(String.format(GET_ALL_QUERY, clazz.getAnnotation(Table.class).name()));
        //List resultList = query.getResultList();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = cb.createQuery(clazz);
        Root<T> root = criteriaQuery.from(clazz);
        criteriaQuery.select(root);
        TypedQuery<T> typedQuery = em.createQuery(criteriaQuery);
        List<T> resultList = typedQuery.getResultList();

        transaction.commit();
        return resultList;
    }
}
