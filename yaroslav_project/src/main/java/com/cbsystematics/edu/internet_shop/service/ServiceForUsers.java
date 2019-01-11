package com.cbsystematics.edu.internet_shop.service;

import com.cbsystematics.edu.internet_shop.dao.jdbc.UserDAO;
import com.cbsystematics.edu.internet_shop.dao.jdbc.impl.JDBCUserDAO;
import com.cbsystematics.edu.internet_shop.entities.Role;
import com.cbsystematics.edu.internet_shop.entities.User;
import com.cbsystematics.edu.internet_shop.entities.UserDetails;

import java.util.List;

public class ServiceForUsers extends AbstractService implements IUserService {

    private UserDetailsService userDetailsService = new UserDetailsService();
    private RoleService roleService = new RoleService();

    @Override
    public List<User> getAll() {
        UserDAO userDAO = new JDBCUserDAO();
        List<User> users = userDAO.getAll();
        for (User user : users) {
            UserDetails userDetails = userDetailsService.get(user.getUserDetailsId());
            Role role = roleService.get(user.getRoleId());
            user.setUserDetails(userDetails);
            user.setRole(role);
        }
        return users;
    }

    @Override
    public User get(Integer id) {
        UserDAO userDAO = new JDBCUserDAO();
        User user = userDAO.get(id);
        UserDetails userDetails = userDetailsService.get(user.getUserDetailsId());
        Role role = roleService.get(user.getRoleId());
        user.setRole(role);
        user.setUserDetails(userDetails);
        return user;
    }

    @Override
    public void delete(Integer id) {
        UserDAO userDAO = new JDBCUserDAO();
        int userDetailsId = userDAO.get(id).getUserDetailsId();
        userDAO.delete(id);
        userDetailsService.delete(userDetailsId);
    }

    @Override
    public void update(User user) {
        UserDAO userDAO = new JDBCUserDAO();
        UserDetails userDetails = user.getUserDetails();
        userDetails.setId(userDAO.getDetailsIdById(user.getId()));
        userDetailsService.update(userDetails);
        user.setUserDetailsId(user.getUserDetails().getId());
        int roleId = roleService.getIdByName(user.getRole().getName());
        user.setRoleId(roleId);
        userDAO.update(user);
    }

    @Override
    public User create(User user) {
        UserDAO userDAO = new JDBCUserDAO();
        user.setId(getNextIdForNewElem(userDAO.getAll()));
        userDetailsService.create(user.getUserDetails());
        int roleId = roleService.getIdByName(user.getRole().getName());
        user.setRoleId(roleId);
        user.setUserDetailsId(user.getUserDetails().getId());
        userDAO.create(user);
        return user;
    }

}
