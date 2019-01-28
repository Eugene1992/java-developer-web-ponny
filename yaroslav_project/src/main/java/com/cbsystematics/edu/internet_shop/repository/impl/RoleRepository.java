package com.cbsystematics.edu.internet_shop.repository.impl;

import com.cbsystematics.edu.internet_shop.entity.Role;
import com.cbsystematics.edu.internet_shop.repository.IRoleRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class RoleRepository implements IRoleRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Role get(Integer id) {
        return null;
    }

    @Override
    public Role create(Role entity) {
        return null;
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
}
