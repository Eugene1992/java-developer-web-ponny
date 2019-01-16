package com.cbsystematics.edu.internet_shop.dao.impl;

import com.cbsystematics.edu.internet_shop.config.JPAUtil;
import com.cbsystematics.edu.internet_shop.dao.DiscountDAO;
import com.cbsystematics.edu.internet_shop.entities.Discount;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class DiscountDAOImpl implements DiscountDAO {

    private static final String GET_ALL_DISCOUNTS_QUERY = "select d from Discount d";
    private EntityManager em;

    public DiscountDAOImpl() {
        this.em = JPAUtil.getEntityManager("com.cbs.edu.jpa");
    }

    @Override
    public Discount get(Integer id) {
        return em.find(Discount.class, id);
    }

    @Override
    public Discount create(Discount discount) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            em.persist(discount);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return discount;
    }

    @Override
    public Discount update(Discount discount) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            Discount oldDiscount = em.find(Discount.class, discount.getId());
            oldDiscount.setName(discount.getName());
            oldDiscount.setAmount(discount.getAmount());
            em.merge(oldDiscount);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return discount;
    }

    @Override
    public void delete(Integer id) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            Discount discount = em.find(Discount.class, id);
            em.remove(discount);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    @Override
    public List<Discount> getAll() {
        Query query = em.createQuery(GET_ALL_DISCOUNTS_QUERY);
        return query.getResultList();
    }
}
