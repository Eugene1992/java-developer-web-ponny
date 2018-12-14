package com.cbs.edu.jpa.examples.relationships;

import com.cbs.edu.jpa.examples.relationships.entity.User;
import com.cbs.edu.jpa.examples.relationships.entity.UserDetails;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class OneToOneTest {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.cbs.edu.jpa");
        EntityManager entityManager = emf.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        User user = new User();
        user.setUsername("xxx");
        user.setPassword("qwerty");

        UserDetails userDetails = new UserDetails();
        userDetails.setNickname("XXX");

        entityManager.persist(userDetails);

        user.setUserDetails(userDetails);

        entityManager.persist(user);

        userDetails.setUser(user);
        entityManager.persist(userDetails);

        User foundedUser = entityManager.find(User.class, 2);
        System.out.println(foundedUser);

        UserDetails foundedUserDetails = entityManager.find(UserDetails.class, 1);
        System.out.println(foundedUserDetails);

        transaction.commit();
        entityManager.close();
        emf.close();
    }
}
