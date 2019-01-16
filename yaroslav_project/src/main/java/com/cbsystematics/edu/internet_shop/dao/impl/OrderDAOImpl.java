package com.cbsystematics.edu.internet_shop.dao.impl;

import com.cbsystematics.edu.internet_shop.config.JPAUtil;
import com.cbsystematics.edu.internet_shop.dao.OrderDAO;
import com.cbsystematics.edu.internet_shop.entities.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {

    private static final String GET_ALL_ORDERS_QUERY = "select o from Order o";
    private EntityManager em;

    public OrderDAOImpl() {
        this.em = JPAUtil.getEntityManager("com.cbs.edu.jpa");
    }

    @Override
    public Order get(Integer id) {
        return em.find(Order.class, id);
    }

    @Override
    public Order create(Order order) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(order);

        transaction.commit();
        return order;
    }

    @Override
    public Order update(Order order) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            Order oldOrder = em.find(Order.class, order.getId());
            oldOrder.setOrderStatus(order.getOrderStatus());
            oldOrder.setProducts(order.getProducts());
            em.merge(oldOrder);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return order;
    }

    @Override
    public void delete(Integer id) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Order order = em.find(Order.class, id);
        em.remove(order);

        transaction.commit();
    }

    @Override
    public List<Order> getAll() {
        Query query = em.createQuery(GET_ALL_ORDERS_QUERY);
        return query.getResultList();
    }
}
