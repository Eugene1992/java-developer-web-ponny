package com.cbsystematics.edu.internet_shop.dao.jdbc.impl;

import com.cbsystematics.edu.internet_shop.config.JDBCConnector;
import com.cbsystematics.edu.internet_shop.dao.jdbc.RoleDAO;
import com.cbsystematics.edu.internet_shop.dao.jdbc.UserDAO;
import com.cbsystematics.edu.internet_shop.dao.jdbc.UserDetailsDAO;
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
    private static final String UPDATE_QUERY = "UPDATE p_users SET username = ?, password = ?, role_id = ? WHERE id = ?";
    private static final String GET_QUERY = "SELECT username, password, role_id, user_details_id FROM p_users WHERE id = %s";
    private static final String DELETE_QUERY = "DELETE FROM p_users WHERE id = %s";

    private static final String ID = "id";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String ROLE_ID = "role_id";
    private static final String USER_DETAILS_ID = "user_details_id";

    private UserDetailsDAO userDetailsDAO;
    private RoleDAO roleDAO;

    public JDBCUserDAO() {
        this.userDetailsDAO = new JDBCUserDetailsDAO();
        this.roleDAO = new JDBCRoleDAO();
    }


    @Override
    public User get(Integer id) {
        String sql = String.format(GET_QUERY, id);
        User user = null;
        try {
            Statement statement = JDBCConnector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String username = resultSet.getString(USERNAME);
                String password = resultSet.getString(PASSWORD);
                int roleId = resultSet.getInt(ROLE_ID);
                int userDetailsId = resultSet.getInt(USER_DETAILS_ID);
                user = new User(id, username, password, roleId, userDetailsId);
            }
            JDBCConnector.close();
            user.setUserDetails(userDetailsDAO.get(id));
            user.setRole(roleDAO.get(user.getRoleId()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User create(User user) {
        PreparedStatement statement;
        try {
            user.getUserDetails().setId(user.getId());
            userDetailsDAO.create(user.getUserDetails());
            int roleId = roleDAO.getIdByRoleName(user.getRole().getName());
            user.setRoleId(roleId);
            statement = JDBCConnector.getConnection().prepareStatement(INSERT_QUERY);
            statement.setInt(1, user.getId());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getPassword());
            statement.setInt(4, user.getRoleId());
            statement.setInt(5, user.getId());
            statement.executeUpdate();
            JDBCConnector.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User update(User user) {
        PreparedStatement statement;
        try {
            user.getUserDetails().setId(user.getId());
            userDetailsDAO.update(user.getUserDetails());
            int roleId = roleDAO.getIdByRoleName(user.getRole().getName());
            user.setRoleId(roleId);
            statement = JDBCConnector.getConnection().prepareStatement(UPDATE_QUERY);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setInt(3, user.getRoleId());
            statement.setInt(4, user.getId());
            statement.executeUpdate();
            JDBCConnector.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void delete(Integer id) {
        String sql = String.format(DELETE_QUERY, id);
        try {
            PreparedStatement statement = JDBCConnector.getConnection().prepareStatement(sql);
            statement.executeUpdate();
            JDBCConnector.close();
            userDetailsDAO.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try {
            Statement statement = JDBCConnector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_QUERY);
            while (resultSet.next()) {
                int id = resultSet.getInt(ID);
                String username = resultSet.getString(USERNAME);
                String password = resultSet.getString(PASSWORD);
                int roleId = resultSet.getInt(ROLE_ID);
                int userDetailsId = resultSet.getInt(USER_DETAILS_ID);
                User user = new User(id, username, password, roleId, userDetailsId);
                user.setUserDetails(userDetailsDAO.get(user.getId()));
                user.setRole(roleDAO.get(user.getRoleId()));
                users.add(user);
            }
            JDBCConnector.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

}
