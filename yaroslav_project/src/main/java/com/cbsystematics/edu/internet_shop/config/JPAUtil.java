package com.cbsystematics.edu.internet_shop.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static EntityManagerFactory emFactory;
    private static EntityManager entityManager;

    public static EntityManager getEntityManager(String name) {
        if (emFactory == null) {
            try {
                emFactory = Persistence.createEntityManagerFactory(name);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        entityManager = emFactory.createEntityManager();

        return entityManager;
    }

    public static EntityManager getEntityManager() {
        return entityManager;
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return emFactory;
    }

    public static void close() {
        entityManager.close();
        emFactory.close();
    }
}