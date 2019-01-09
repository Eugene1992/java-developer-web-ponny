package com.cbsystematics.edu.internet_shop.service;

import com.cbsystematics.edu.internet_shop.dao.jdbc.UserDetailsDAO;
import com.cbsystematics.edu.internet_shop.dao.jdbc.impl.JDBCUserDetailsDAO;
import com.cbsystematics.edu.internet_shop.entities.UserDetails;

import java.util.List;

public class ServiceForUserDetails implements DAOService<UserDetails> {
    @Override
    public List<UserDetails> getAll() {
        UserDetailsDAO userDetailsDAO = new JDBCUserDetailsDAO();
        return userDetailsDAO.getAll();
    }

    @Override
    public UserDetails get(Integer id) {
        UserDetailsDAO userDetailsDAO = new JDBCUserDetailsDAO();
        return userDetailsDAO.get(id);
    }

    @Override
    public void delete(Integer id) {
        UserDetailsDAO userDetailsDAO= new JDBCUserDetailsDAO();
        userDetailsDAO.delete(id);
    }

    @Override
    public void update(UserDetails userDetails) {
        UserDetailsDAO userDetailsDAO = new JDBCUserDetailsDAO();
        userDetailsDAO.update(userDetails);
    }

    @Override
    public UserDetails create(UserDetails userDetails) {
        UserDetailsDAO userDetailsDAO = new JDBCUserDetailsDAO();
        userDetails.setId(getNextIdForNewElem(userDetailsDAO.getAll()));
        userDetailsDAO.create(userDetails);
        return userDetails;
    }

}
