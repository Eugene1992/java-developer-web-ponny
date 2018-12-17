package com.cbs.edu.jpa.examples.querying.sql;

import com.cbs.edu.jpa.examples.querying.Employee;

import javax.persistence.*;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.cbs.edu.jpa");
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Query nativeQuery = em.createNativeQuery("SELECT * FROM postgres.public.employees WHERE first_name = ?1", Employee.class);
        nativeQuery.setParameter(1, "Wesley");

        List<Employee> resultList = nativeQuery.getResultList();

        for (Employee employee : resultList) {
            System.out.println(employee);
        }

        transaction.commit();
        em.close();
        emf.close();
    }
}
