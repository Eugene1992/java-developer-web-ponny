package com.cbsystematics.edu.internet_shop.service.impl;

import com.cbsystematics.edu.internet_shop.dao.UserDAO;
import com.cbsystematics.edu.internet_shop.dao.impl.UserDAOImpl;
import com.cbsystematics.edu.internet_shop.entities.User;
import com.cbsystematics.edu.internet_shop.service.IUserService;

import java.util.List;

public class UserService implements IUserService {

    private UserDAO userDAO;
    private RoleService roleService;
    private UserDetailsService userDetailsService;

    public UserService() {
        this.userDAO = new UserDAOImpl();
        this.roleService = new RoleService();
        this.userDetailsService = new UserDetailsService();
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAll();
    }

    @Override
    public User getUser(Integer id) {
        return userDAO.get(id);
    }

    @Override
    public void deleteUser(Integer id) {
        userDetailsService.delete(userDAO.getUserDetailsIdByUserId(id));
        userDAO.delete(id);
    }

    @Override
    public User getByUsernameAndPassword(String username, String password) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        int userDetailsId = userDAO.getUserDetailsIdByUserId(user.getId());
        userDetailsService.update(userDetailsService.get(userDetailsId));
        userDAO.update(user);
        return user;
    }

    @Override
    public User createUser(User user) {
        //userDetailsService.create(user.getUserDetails());
        userDAO.create(user);
        return user;
    }

}
