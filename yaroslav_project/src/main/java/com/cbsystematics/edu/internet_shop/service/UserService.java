package com.cbsystematics.edu.internet_shop.service;

import com.cbsystematics.edu.internet_shop.dao.jdbc.UserDAO;
import com.cbsystematics.edu.internet_shop.dao.jdbc.impl.JDBCUserDAO;
import com.cbsystematics.edu.internet_shop.entities.User;

import java.util.List;

public class UserService extends AbstractService implements IUserService {

    private UserDAO userDAO;

    public UserService() {
        this.userDAO = new JDBCUserDAO();
    }

    @Override
    public List<User> getAll() {
        return userDAO.getAll();
    }

    @Override
    public User get(Integer id) {
        return userDAO.get(id);
    }

    @Override
    public void delete(Integer id) {
        userDAO.delete(id);
    }

    @Override
    public void update(User user) {
        userDAO.update(user);
    }

    @Override
    public User create(User user) {
        user.setId(getNextIdForNewElem(userDAO.getAll()));
        userDAO.create(user);
        return user;
    }

}
