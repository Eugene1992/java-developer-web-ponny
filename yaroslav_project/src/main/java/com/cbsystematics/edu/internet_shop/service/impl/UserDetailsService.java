package com.cbsystematics.edu.internet_shop.service.impl;

import com.cbsystematics.edu.internet_shop.dao.UserDetailsDAO;
import com.cbsystematics.edu.internet_shop.dao.impl.UserDetailsDAOImpl;
import com.cbsystematics.edu.internet_shop.entities.UserDetails;
import com.cbsystematics.edu.internet_shop.service.IUserDetailsService;

import java.util.List;

public class UserDetailsService implements IUserDetailsService {

    private UserDetailsDAO userDetailsDAO;

    public UserDetailsService() {
        this.userDetailsDAO = new UserDetailsDAOImpl();
    }

    @Override
    public List<UserDetails> getAll() {
        return userDetailsDAO.getAll();
    }

    @Override
    public UserDetails get(Integer id) {
        return userDetailsDAO.get(id);
    }

    @Override
    public void delete(Integer id) {
        userDetailsDAO.delete(id);
    }

    @Override
    public void update(UserDetails userDetails) {
        userDetailsDAO.update(userDetails);
    }

    @Override
    public UserDetails create(UserDetails userDetails) {
        userDetailsDAO.create(userDetails);
        return userDetails;
    }

}
