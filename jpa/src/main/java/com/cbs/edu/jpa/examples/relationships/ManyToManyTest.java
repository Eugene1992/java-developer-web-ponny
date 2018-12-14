package com.cbs.edu.jpa.examples.relationships;

import com.cbs.edu.jpa.examples.relationships.entity.City;
import com.cbs.edu.jpa.examples.relationships.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import java.util.HashSet;

import static java.util.Arrays.asList;

public class ManyToManyTest {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.cbs.edu.jpa");
        EntityManager entityManager = emf.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        User user1 = new User();
        user1.setUsername("User #1");

        User user2 = new User();
        user2.setUsername("User #2");

        entityManager.persist(user1);
        entityManager.persist(user2);

        City kiev = new City();
        kiev.setName("Kiev");
        kiev.setUsers(asList(user1, user2));

        entityManager.persist(kiev);

        City lviv = new City();
        lviv.setName("Lviv");
        lviv.setUsers(asList(user1));

        entityManager.persist(lviv);

        City berlin = new City();
        berlin.setName("Berlin");
        berlin.setUsers(asList(user2));

        entityManager.persist(berlin);

        user1.setCities(new HashSet<>(asList(kiev, berlin)));
        entityManager.persist(user1);

        user2.setCities(new HashSet<>(asList(berlin, lviv)));
        entityManager.persist(user2);

        transaction.commit();
        entityManager.close();
        emf.close();
    }
}
