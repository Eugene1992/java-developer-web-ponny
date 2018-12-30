package com.cbsystematics.edu.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Test {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.cbs.edu.hibernate");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

//        transaction.begin();
//
//        User user = new User(1, "new_user", "qwerty");
//        entityManager.persist(user);
//
//        transaction.commit();
//
//        entityManager.close();
//        entityManagerFactory.close();
    }
}
