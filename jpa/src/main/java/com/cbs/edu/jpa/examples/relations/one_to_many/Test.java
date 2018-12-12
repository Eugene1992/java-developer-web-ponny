package com.cbs.edu.jpa.examples.relations.one_to_many;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import static java.util.Arrays.asList;

public class Test {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.cbs.edu.jpa");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Song song1 = new Song();
        song1.setTitle("Song #1");

        Song song2 = new Song();
        song2.setTitle("Song #2");

        entityManager.persist(song1);
        entityManager.persist(song2);

        Album album = new Album();
        album.setTitle("Album #1");

        album.setSongs(asList(song1, song2));

        entityManager.persist(album);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
