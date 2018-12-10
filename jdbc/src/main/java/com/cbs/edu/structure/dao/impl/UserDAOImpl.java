package com.cbs.edu.structure.dao.impl;

import com.cbs.edu.structure.dao.AbstractDAO;
import com.cbs.edu.structure.dao.UserDAO;
import com.cbs.edu.structure.entities.Product;
import com.cbs.edu.structure.entities.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class UserDAOImpl extends AbstractDAO<User> implements UserDAO {

    private static final String
            GET_ALL_USERS_QUERY_KEY = "dao.user.getAll";

    @Override
    public User getByUsername(String username) {
        return null;
    }

    @Override
    public User get(Integer id) {
        return null;
    }

    @Override
    public User create(User entity) {
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
        List<User> users = null;
        Statement statement;
        try {
            statement = connection.createStatement();
            String query = getQuery(GET_ALL_USERS_QUERY_KEY);
            ResultSet resultSet = statement.executeQuery(query);
            users = new LinkedList<>();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String username = resultSet.getString("username");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                users.add(new User(id, firstName, lastName, username, password, email));
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }
}
