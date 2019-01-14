package com.cbs.edu.eshop;

import com.cbs.edu.eshop.config.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager("com.cbs.edu.jpa");
    }
}
