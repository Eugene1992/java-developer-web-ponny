package com.cbs.edu.jdbc.dao.impl;

import com.cbs.edu.jdbc.dao.AbstractDAO;
import com.cbs.edu.jdbc.dao.UserDAO;
import com.cbs.edu.jdbc.objects.User;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDAOImpl extends AbstractDAO  <User> implements UserDAO {

    @Override
    public User getByUsername(String username) {
        return null;
    }

    @Override
    public User get(Integer id) {
        return null;
    }

    @Override
    public User cteate(User entity) {
        return null;
    }

    @Override
    public User update(User entity) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<User> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT id, firstName, lastName,username,password,email FROM ";
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

}
