package com.cbs.edu.jpa.examples.querying.jpql;

import com.cbs.edu.jpa.examples.querying.Employee;

import javax.persistence.*;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.cbs.edu.jpa");
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

//        Query query = em.createQuery("from Employee");
//        Query query = em.createQuery("from Employee e where e.firstName like 'M%'");
        em.createQuery("from Employee e where e.firstName like 'M%' and e.age > :age")
                .setParameter("age", 50)
                .getResultList()
                .stream()
                .forEach(System.out::println);

        transaction.commit();
        em.close();
        emf.close();
    }
}
