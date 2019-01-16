package com.cbsystematics.edu.internet_shop.service.impl;

import com.cbsystematics.edu.internet_shop.dao.RoleDAO;
import com.cbsystematics.edu.internet_shop.dao.impl.RoleDAOImpl;
import com.cbsystematics.edu.internet_shop.entities.Role;
import com.cbsystematics.edu.internet_shop.service.IRoleService;

import java.util.List;


public class RoleService implements IRoleService {

    private RoleDAO roleDAO;

    public RoleService() {
        this.roleDAO = new RoleDAOImpl();
    }


    @Override
    public Role getRoleByName(String name) {
        return null;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleDAO.getAll();
    }
}
