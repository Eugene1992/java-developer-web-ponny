package com.cbs.edu.jpa.examples.querying.criteria;

import com.cbs.edu.jpa.examples.querying.Employee;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.cbs.edu.jpa");
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Employee> criteriaQuery = cb.createQuery(Employee.class);
        Root<Employee> root = criteriaQuery.from(Employee.class);

        criteriaQuery.select(root);

        TypedQuery<Employee> query = em.createQuery(criteriaQuery);

        List<Employee> resultList = query.getResultList();

        System.out.println(resultList);

        transaction.commit();
        em.close();
        emf.close();
    }
}
