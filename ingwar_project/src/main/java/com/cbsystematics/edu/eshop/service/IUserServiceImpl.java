package com.cbsystematics.edu.eshop.service;

import com.cbsystematics.edu.eshop.dao.IUserDAOImpl;
import com.cbsystematics.edu.eshop.entities.User;

import java.util.List;

public class IUserServiceImpl implements IUserService {

    private IUserDAOImpl userDAO;

    public IUserServiceImpl() {
        this.userDAO = new IUserDAOImpl();
    }

    @Override
    public User createUser(User user) {
        return userDAO.create(user);
    }

    @Override
    public User updateUser(User user) {
        return userDAO.update(user);
    }

    @Override
    public User getUser(Integer id) {
        return userDAO.get(id);
    }

    @Override
    public void deleteUser(Integer id) {
        userDAO.delete(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAll();
    }
}
