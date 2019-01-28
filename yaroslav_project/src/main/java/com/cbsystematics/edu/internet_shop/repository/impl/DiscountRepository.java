package com.cbsystematics.edu.internet_shop.repository.impl;

import com.cbsystematics.edu.internet_shop.entity.Discount;
import com.cbsystematics.edu.internet_shop.repository.IDiscountRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class DiscountRepository implements IDiscountRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Discount get(Integer id) {
        return entityManager.find(Discount.class, id);
    }

    @Override
    public Discount create(Discount discount) {
        entityManager.persist(discount);
        return get(discount.getId());
    }

    @Override
    public Discount update(Discount discount) {
        entityManager.merge(discount);
        return discount;
    }

    @Override
    public void delete(Integer id) {
        Discount discount = entityManager.find(Discount.class, id);
        entityManager.remove(discount);
    }

    @Override
    public List<Discount> getAll() {
        return entityManager.createQuery("select d from Discount d")
                .getResultList();
    }
}
