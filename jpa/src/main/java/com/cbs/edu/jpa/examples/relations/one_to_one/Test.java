package com.cbs.edu.jpa.examples.relations.one_to_one;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by yede0517 on 12/11/2018.
 */
public class Test {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.cbs.edu.jpa");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        BookDetails bookDetails = new BookDetails();
        bookDetails.setGenre("Roman");
        bookDetails.setNumOfPages(587);
        entityManager.persist(bookDetails);

        BookPublisher bookPublisher = new BookPublisher();
        bookPublisher.setName("Orielly");
        entityManager.persist(bookPublisher);

        Book book = new Book();
        book.setTitle("War and Peace");
        book.setBookDetails(bookDetails);
        book.setBookPublisher(bookPublisher);
        entityManager.persist(book);

        bookPublisher.setBook(book);
        entityManager.persist(bookPublisher);

        BookPublisher foundedBookPublisher = entityManager.find(BookPublisher.class, 2);
        System.out.println(foundedBookPublisher);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
