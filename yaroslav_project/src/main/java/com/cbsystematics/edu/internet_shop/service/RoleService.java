package com.cbsystematics.edu.internet_shop.service;

import com.cbsystematics.edu.internet_shop.dao.jdbc.RoleDAO;
import com.cbsystematics.edu.internet_shop.dao.jdbc.impl.JDBCRoleDAO;
import com.cbsystematics.edu.internet_shop.entities.Role;

import java.util.List;
import java.util.NoSuchElementException;

public class RoleService extends AbstractService implements IRoleService {

    private RoleDAO roleDAO;

    public RoleService() {
        this.roleDAO = new JDBCRoleDAO();
    }


    @Override
    public List<Role> getAll() {
        return roleDAO.getAll();
    }

    @Override
    public Role get(Integer id) {
        return roleDAO.get(id);
    }

    @Override
    public void delete(Integer id) {
        roleDAO.delete(id);
    }

    @Override
    public void update(Role role) {
        roleDAO.update(role);
    }

    @Override
    public Role create(Role role) {
        role.setId(getNextIdForNewElem(roleDAO.getAll()));
        roleDAO.create(role);
        return role;
    }


    public int getIdByName(String name) {
        RoleDAO roleDAO = new JDBCRoleDAO();
        List<Role> roles = roleDAO.getAll();
        for (Role role : roles) {
            if(role.getName().equals(name)){
                return role.getId();
            }
        }
        throw new NoSuchElementException("No such role name");
        //return roleDAO.getIdByRoleName(name);
    }

}
