package com.cbsystematics.edu.internet_shop.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.cbs.edu.jpa");
    private static EntityManager em = emf.createEntityManager();


    public static EntityManager getEntityManager(){
        return em;
    }


    public static void close() {
        em.close();
        emf.close();
    }
}
