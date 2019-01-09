package com.cbsystematics.edu.internet_shop.dao.jdbc.impl;

import com.cbsystematics.edu.internet_shop.config.Connector;
import com.cbsystematics.edu.internet_shop.dao.jdbc.UserDAO;
import com.cbsystematics.edu.internet_shop.entities.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCUserDAO implements UserDAO {

    private static final String INSERT_QUERY = "INSERT INTO p_users (id, username, password, role_id, user_details_id) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM p_users";
    private static final String UPDATE_QUERY = "UPDATE p_users SET username = ?, password = ?, role_id = ?, user_details_id = ? WHERE id = ?";
    private static final String GET_QUERY = "SELECT username, password, role_id, user_details_id FROM p_users WHERE id = %s";
    private static final String DELETE_QUERY = "DELETE FROM p_users WHERE id = %s";

    private static final String GET_DETAILS_ID_BY_ID_QUERY = "SELECT user_details_id FROM p_users WHERE id = %s";


    @Override
    public User get(Integer id) {
        String sql = String.format(GET_QUERY, id);
        User user = null;
        try {
            Statement statement = Connector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                int roleId = resultSet.getInt("role_id");
                int userDetailsId = resultSet.getInt("user_details_id");
                user = new User(id, username, password, roleId, userDetailsId);
            }
            Connector.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User create(User user) {
        PreparedStatement statement;
        try {
            statement = Connector.getConnection().prepareStatement(INSERT_QUERY);
            statement.setInt(1, user.getId());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getPassword());
            statement.setInt(4, user.getRoleId());
            statement.setInt(5, user.getUserDetailsId());
            statement.executeUpdate();
            Connector.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User update(User user) {
        PreparedStatement statement;
        try {
            statement = Connector.getConnection().prepareStatement(UPDATE_QUERY);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setInt(3, user.getRoleId());
            statement.setInt(4, user.getUserDetailsId());
            statement.setInt(5, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void delete(Integer id) {
        String sql = String.format(DELETE_QUERY, id);
        try {
            PreparedStatement statement = Connector.getConnection().prepareStatement(sql);
            statement.executeUpdate();
            Connector.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try {
            Statement statement = Connector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_QUERY);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                int roleId = resultSet.getInt("role_id");
                int userDetailsId = resultSet.getInt("user_details_id");
                users.add(new User(id, username, password, roleId, userDetailsId));
            }
            Connector.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public int getDetailsIdById(Integer id) {
        String sql = String.format(GET_DETAILS_ID_BY_ID_QUERY, id);
        int userDetailsId = 0;
        try {
            Statement statement = Connector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                userDetailsId = resultSet.getInt("user_details_id");
             }
            Connector.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userDetailsId;
    }
}
