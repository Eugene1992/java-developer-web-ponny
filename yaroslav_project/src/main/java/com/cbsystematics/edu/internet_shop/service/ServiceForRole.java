package com.cbsystematics.edu.internet_shop.service;

import com.cbsystematics.edu.internet_shop.dao.jdbc.RoleDAO;
import com.cbsystematics.edu.internet_shop.dao.jdbc.impl.JDBCRoleDAO;
import com.cbsystematics.edu.internet_shop.entities.Role;

import java.util.List;

public class ServiceForRole implements DAOService<Role> {

    public List<Role> getAll() {
        RoleDAO roleDAO = new JDBCRoleDAO();
        return roleDAO.getAll();
    }

    public Role get(Integer id) {
        RoleDAO roleDAO = new JDBCRoleDAO();
        return roleDAO.get(id);
    }

    public void delete(Integer id) {
        RoleDAO roleDAO = new JDBCRoleDAO();
        roleDAO.delete(id);
    }

    public void update(Role role) {
        RoleDAO roleDAO = new JDBCRoleDAO();
        roleDAO.update(role);
    }

    public Role create(Role role) {
        RoleDAO roleDAO = new JDBCRoleDAO();
        role.setId(getNextIdForNewElem(roleDAO.getAll()));
        roleDAO.create(role);
        return role;
    }

}
