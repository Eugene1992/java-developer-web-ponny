package com.cbs.edu.eshop.repository.impl;

import com.cbs.edu.eshop.entity.User;
import com.cbs.edu.eshop.repository.IUserRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserRepository implements IUserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User get(Integer id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User create(User entity) {
        entityManager.persist(entity);
        return get(entity.getId());
    }

    @Override
    public User update(User entity) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAll() {
        return entityManager.createQuery("select u from User u").getResultList();
    }

    @Override
    public User getByUsername(String username) {
        return (User) entityManager
                .createQuery("select u from User u where u.username = :username")
                .setParameter("username", username)
                .getSingleResult();
    }
}
