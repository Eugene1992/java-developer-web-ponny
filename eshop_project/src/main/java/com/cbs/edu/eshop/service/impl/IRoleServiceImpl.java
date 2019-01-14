package com.cbs.edu.eshop.service.impl;

import com.cbs.edu.eshop.dao.impl.IRoleDAOImpl;
import com.cbs.edu.eshop.entity.Role;
import com.cbs.edu.eshop.service.IRoleService;

import java.util.List;

public class IRoleServiceImpl implements IRoleService {

    private IRoleDAOImpl roleDAO;

    public IRoleServiceImpl() {
        this.roleDAO = new IRoleDAOImpl();
    }

    @Override
    public Role getRoleByName(String name) {
        return roleDAO.getRoleByName(name);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleDAO.getAll();
    }
}