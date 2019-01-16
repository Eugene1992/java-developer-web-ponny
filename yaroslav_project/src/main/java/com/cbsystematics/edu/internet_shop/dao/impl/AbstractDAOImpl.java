package com.cbsystematics.edu.internet_shop.dao.impl;

import com.cbsystematics.edu.internet_shop.entities.AbstractEntity;

public class AbstractDAOImpl<T extends AbstractEntity> {

//    protected EntityManager entityManager;
//
//
//    AbstractDAOImpl() {
//        this.entityManager = this.em = JPAUtil.getEntityManager("com.cbs.edu.jpa");
//    }
//
//
//    private static final String GET_ALL_QUERY = "select * from %S";
//
//    @Override
//    public T get(Integer id, Class<T> clazz) {
//        T t = entityManager.find(clazz, id);
//        return t;
//    }
//
//    @Override
//    public T create(T elem) {
//        EntityTransaction transaction = entityManager.getTransaction();
//        transaction.begin();
//
//        entityManager.persist(elem);
//
//        transaction.commit();
//        return elem;
//    }
//
//    @Override
//    public T update(T elem) {
//        EntityTransaction transaction = entityManager.getTransaction();
//        transaction.begin();
//
//        entityManager.merge(elem);
//
//        transaction.commit();
//        return elem;
//    }
//
//    @Override
//    public void delete(Integer id, Class<T> clazz) {
//        EntityTransaction transaction = entityManager.getTransaction();
//        transaction.begin();
//
//        T elem = entityManager.find(clazz, id);
//        entityManager.remove(elem);
//
//        transaction.commit();
//    }
//
//    @Override
//    public List<T> getAll(Class<T> clazz) {
//
//        System.out.println("===============" + clazz.getSimpleName());
//        //Query query = em.createNativeQuery(String.format(GET_ALL_QUERY, clazz.getAnnotation(Table.class).name()));
//        //List resultList = query.getResultList();
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<T> criteriaQuery = cb.createQuery(clazz);
//        Root<T> root = criteriaQuery.from(clazz);
//        criteriaQuery.select(root);
//        TypedQuery<T> typedQuery = entityManager.createQuery(criteriaQuery);
//
//        return typedQuery.getResultList();
//    }

}
