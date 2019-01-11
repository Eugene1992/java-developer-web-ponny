package com.cbsystematics.edu.internet_shop.service;

import com.cbsystematics.edu.internet_shop.dao.jdbc.UserDetailsDAO;
import com.cbsystematics.edu.internet_shop.dao.jdbc.impl.JDBCUserDetailsDAO;
import com.cbsystematics.edu.internet_shop.entities.UserDetails;

import java.util.List;

public class UserDetailsService extends AbstractService implements IUserDetailsService {

    private UserDetailsDAO userDetailsDAO;

    public UserDetailsService() {
        this.userDetailsDAO = new JDBCUserDetailsDAO();
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
        userDetails.setId(getNextIdForNewElem(userDetailsDAO.getAll()));
        userDetailsDAO.create(userDetails);
        return userDetails;
    }

}
