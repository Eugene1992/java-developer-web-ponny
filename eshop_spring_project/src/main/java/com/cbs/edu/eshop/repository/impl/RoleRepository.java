package com.cbs.edu.eshop.repository.impl;

import com.cbs.edu.eshop.entity.Role;
import com.cbs.edu.eshop.repository.IRoleRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class RoleRepository implements IRoleRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Role get(Integer id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public Role create(Role entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public Role update(Role entity) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Role> getAll() {
        return null;
    }

    @Override
    public Role getByName(String name) {
        return (Role) entityManager.createQuery("select r from Role r where r.name = :name")
                .setParameter("name", name)
                .getSingleResult();
    }
}
