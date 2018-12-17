package com.cbs.edu.jpa.examples.querying.criteria;

import com.cbs.edu.jpa.examples.querying.Employee;
import com.cbs.edu.jpa.examples.querying.criteria.ParamTest.ProductFilter.PriceFilter;
import lombok.Data;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

public class ParamTest {
    public static void main(String[] args) throws Exception {
        ProductFilter productFilter = new ProductFilter();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.cbs.edu.jpa");
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Employee> criteriaQuery = cb.createQuery(Employee.class);
        Root<Employee> root = criteriaQuery.from(Employee.class);

        criteriaQuery
                .select(root);

        List<Predicate> predicates = new ArrayList<>();

        if (nonNull(productFilter)) {
            String tittle = productFilter.getTittle();
            if (nonNull(tittle)) {
                predicates.add(cb.equal(root.get("tittle"), tittle));
            }

            PriceFilter priceFilter = productFilter.getPriceFilter();
            if (nonNull(priceFilter)) {
                Integer from = priceFilter.getFrom();
                Integer to = priceFilter.getTo();

                if (nonNull(from) && nonNull(to)) {
                    if (to > from) {
                        predicates.add(cb.between(root.get("price"), from, to));
                    } else {
                        throw new Exception();
                    }
                } else {
                    if (nonNull(from)) {
                        predicates.add(cb.gt(root.get("price"), from));
                    }
                    if (nonNull(to)) {
                        predicates.add(cb.lt(root.get("price"), to));
                    }
                }
            }
            criteriaQuery.where(predicates.toArray(new Predicate[]{}));
        }

        TypedQuery<Employee> query = em.createQuery(criteriaQuery);

        List<Employee> resultList = query.getResultList();

        System.out.println(resultList);

        transaction.commit();
        em.close();
        emf.close();
    }

    @Data
    static class ProductFilter {
        private String tittle;
        private PriceFilter priceFilter;

        @Data
        static class PriceFilter {
            private Integer from;
            private Integer to;
        }
    }
}
