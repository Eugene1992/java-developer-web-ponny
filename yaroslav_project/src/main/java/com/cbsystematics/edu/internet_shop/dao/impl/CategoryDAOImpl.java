package com.cbsystematics.edu.internet_shop.dao.impl;

import com.cbsystematics.edu.internet_shop.config.JPAUtil;
import com.cbsystematics.edu.internet_shop.dao.CategoryDAO;
import com.cbsystematics.edu.internet_shop.entities.Category;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class CategoryDAOImpl implements CategoryDAO {

    private static final String GET_ALL_CATEGORY_QUERY = "select p from Product p";
    private EntityManager em;

    public CategoryDAOImpl() {
        this.em = JPAUtil.getEntityManager("com.cbs.edu.jpa");
    }

    @Override
    public Category get(Integer id) {
        return em.find(Category.class, id);
    }

    @Override
    public Category create(Category category) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            em.persist(category);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return category;
    }

    @Override
    public Category update(Category category) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            Category oldCategory = em.find(Category.class, category.getId());
            oldCategory.setName(category.getName());
            oldCategory.setDescription(category.getDescription());
            em.merge(oldCategory);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return category;
    }

    @Override
    public void delete(Integer id) {
        EntityTransaction transaction = em.getTransaction();
            try {
            transaction.begin();

            Category category = em.find(Category.class, id);
            em.remove(category);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    @Override
    public List<Category> getAll() {
        Query query = em.createQuery(GET_ALL_CATEGORY_QUERY);
        return query.getResultList();
    }
}
