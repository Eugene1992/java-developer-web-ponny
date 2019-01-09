package com.cbs.edu.jdbc.examples.dao.impl;

import com.cbs.edu.jdbc.examples.dao.AbstractDAO;
import com.cbs.edu.jdbc.examples.dao.UserDAO;
import com.cbs.edu.jdbc.objects.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDAOImpl extends AbstractDAO  <User> implements UserDAO {

    private static final String GET_ALL_USERS_QUERY_KEY = "dao.user.getAll";

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
            String query = getQuery(GET_ALL_USERS_QUERY_KEY);
            ResultSet resultSet = statement.executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

}
