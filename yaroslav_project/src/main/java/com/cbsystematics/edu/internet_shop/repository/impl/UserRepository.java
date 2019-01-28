package com.cbsystematics.edu.internet_shop.repository.impl;

import com.cbsystematics.edu.internet_shop.entity.User;
import com.cbsystematics.edu.internet_shop.repository.IUserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UserRepository implements IUserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getByUsernameAndPassword(String username, String password) {
        return null;
    }

    @Override
    public User get(Integer id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User create(User user) {
        entityManager.persist(user.getUserDetails());
        entityManager.persist(user);
        return get(user.getId());
    }

    @Override
    public User update(User user) {
        entityManager.merge(user);
        return user;
    }

    @Override
    public void delete(Integer id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public List<User> getAll() {
        return entityManager.createQuery("select u from User u")
                .getResultList();
    }
}
