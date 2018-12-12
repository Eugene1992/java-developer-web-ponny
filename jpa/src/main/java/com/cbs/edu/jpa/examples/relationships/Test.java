package com.cbs.edu.jpa.examples.relationships;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Test {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.cbs.edu.jpa");
        EntityManager entityManager = emf.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        User user = new User();
        user.setUsername("root");
        user.setPassword("root");

        entityManager.persist(user);

        transaction.commit();

        EntityTransaction transaction1 = entityManager.getTransaction();
        transaction1.begin();
        user.setPassword("qwerty");
        entityManager.persist(user);
        transaction1.commit();

        entityManager.close();
        emf.close();
    }
}
