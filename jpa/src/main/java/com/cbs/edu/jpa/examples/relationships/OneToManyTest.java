package com.cbs.edu.jpa.examples.relationships;

import com.cbs.edu.jpa.examples.relationships.entity.HomePet;
import com.cbs.edu.jpa.examples.relationships.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import static java.util.Arrays.asList;

public class OneToManyTest {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.cbs.edu.jpa");
        EntityManager entityManager = emf.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        User user = new User();
        user.setUsername("xxx");
        user.setPassword("qwerty");

        entityManager.persist(user);

        HomePet cat = new HomePet();
        cat.setName("Cat");
        cat.setUser(user);

        HomePet dog = new HomePet();
        dog.setName("Dog");
        dog.setUser(user);

        entityManager.persist(cat);
        entityManager.persist(dog);

        user.setHomePets(asList(cat, dog));
        entityManager.persist(user);

        User foundedUser = entityManager.find(User.class, 1);

        System.out.println(foundedUser);

        transaction.commit();
        entityManager.close();
        emf.close();
    }
}
