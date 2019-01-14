package com.cbs.edu.eshop.listeners;

import com.cbs.edu.eshop.config.JPAUtil;
import com.cbs.edu.eshop.entity.RoleEnum;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Arrays;

public class OnStartupListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        EntityManager entityManager = JPAUtil.getEntityManager("com.cbs.edu.jpa");
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Arrays.stream(RoleEnum.values())
                .forEach(role -> {
                    entityManager.persist(role.getRole());
                });

        transaction.commit();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
