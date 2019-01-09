package com.cbsystematics.edu.internet_shop.service;

import com.cbsystematics.edu.internet_shop.dao.jdbc.UserDAO;
import com.cbsystematics.edu.internet_shop.dao.jdbc.impl.JDBCUserDAO;
import com.cbsystematics.edu.internet_shop.entities.Role;
import com.cbsystematics.edu.internet_shop.entities.User;
import com.cbsystematics.edu.internet_shop.entities.UserDetails;

import java.util.List;

public class ServiceForUsers implements DAOService<User> {

    private ServiceForUserDetails serviceForUserDetails = new ServiceForUserDetails();
    private ServiceForRole serviceForRole = new ServiceForRole();

    public List<User> getAll() {
        UserDAO userDAO = new JDBCUserDAO();
        List<User> users = userDAO.getAll();
        for (User user : users) {
            UserDetails userDetails = serviceForUserDetails.get(user.getUserDetailsId());
            Role role = serviceForRole.get(user.getRoleId());
            user.setUserDetails(userDetails);
            user.setRole(role);
        }
        return users;
    }

    public User get(Integer id) {
        UserDAO userDAO = new JDBCUserDAO();
        User user = userDAO.get(id);
        UserDetails userDetails = serviceForUserDetails.get(user.getUserDetailsId());
        Role role = serviceForRole.get(user.getRoleId());
        user.setRole(role);
        user.setUserDetails(userDetails);
        return user;
    }

    public void delete(Integer id) {
        UserDAO userDAO = new JDBCUserDAO();
        int userDetailsId = userDAO.get(id).getUserDetailsId();
        userDAO.delete(id);
        serviceForUserDetails.delete(userDetailsId);
    }

    public void update(User user) {
        UserDAO userDAO = new JDBCUserDAO();
        UserDetails userDetails = user.getUserDetails();
        userDetails.setId(userDAO.getDetailsIdById(user.getId()));
        serviceForUserDetails.update(userDetails);
        user.setUserDetailsId(user.getUserDetails().getId());
        int roleId = serviceForRole.getIdByName(user.getRole().getName());
        user.setRoleId(roleId);
        userDAO.update(user);
    }

    public User create(User user) {
        UserDAO userDAO = new JDBCUserDAO();
        user.setId(getNextIdForNewElem(userDAO.getAll()));
        serviceForUserDetails.create(user.getUserDetails());
        int roleId = serviceForRole.getIdByName(user.getRole().getName());
        user.setRoleId(roleId);
        user.setUserDetailsId(user.getUserDetails().getId());
        userDAO.create(user);
        return user;
    }

}
