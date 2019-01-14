package com.cbs.edu.eshop.dao.impl;

import com.cbs.edu.eshop.config.JPAUtil;
import com.cbs.edu.eshop.dao.IRoleDAO;
import com.cbs.edu.eshop.entity.Role;

import javax.persistence.EntityManager;
import java.util.List;

public class IRoleDAOImpl implements IRoleDAO<Role> {

    private EntityManager entityManager;

    public IRoleDAOImpl() {
        this.entityManager = JPAUtil.getEntityManager("com.cbs.edu.jpa");
    }

    @Override
    public Role get(Integer id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public Role create(Role entity) {
        throw new UnsupportedOperationException("Cannot manually create new system user role");
    }

    @Override
    public Role update(Role entity) {
        throw new UnsupportedOperationException("Cannot manually update new system user role");
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Cannot manually delete new system user role");
    }

    @Override
    public List<Role> getAll() {
        return entityManager.createQuery("select r from Role r").getResultList();
    }
}