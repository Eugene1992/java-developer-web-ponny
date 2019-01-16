package com.cbsystematics.edu.internet_shop.dao.impl;

import com.cbsystematics.edu.internet_shop.config.JPAUtil;
import com.cbsystematics.edu.internet_shop.dao.RoleDAO;
import com.cbsystematics.edu.internet_shop.entities.Role;

import javax.persistence.EntityManager;
import java.util.List;

public class RoleDAOImpl implements RoleDAO {

    private static final String GET_ALL_PRODUCTS_QUERY = "select r from Role r";
    private EntityManager em;

    public RoleDAOImpl() {
        this.em = JPAUtil.getEntityManager("com.cbs.edu.jpa");
    }

    @Override
    public Role getRoleByName(String name) {
        return (Role) em.createQuery("select r from Role r where r.name =:name")
                .setParameter("name", name)
                .getSingleResult();
    }

    @Override
    public Role get(Integer id) {
        return em.find(Role.class, id);
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
        return em.createQuery(GET_ALL_PRODUCTS_QUERY).getResultList();
    }

}
