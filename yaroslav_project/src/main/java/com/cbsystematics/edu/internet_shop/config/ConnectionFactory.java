package com.cbsystematics.edu.internet_shop.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {

    private EntityManagerFactory emf;
    private EntityManager em;

    public ConnectionFactory() {
        this.emf = Persistence.createEntityManagerFactory("com.cbs.edu.jpa");
        this.em = emf.createEntityManager();
    }

    public EntityManager getEntityManager(){
        return em;
    }

    public void close() {
        em.close();
        emf.close();
    }
}
