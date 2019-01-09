package com.cbsystematics.edu.internet_shop.dao.jdbc.impl;

import com.cbsystematics.edu.internet_shop.config.Connector;
import com.cbsystematics.edu.internet_shop.dao.jdbc.UserDetailsDAO;
import com.cbsystematics.edu.internet_shop.entities.UserDetails;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCUserDetailsDAO implements UserDetailsDAO {

    private static final String INSERT_QUERY = "INSERT INTO p_user_details (id, first_name, last_name, email, phone) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM p_user_details";
    private static final String UPDATE_QUERY = "UPDATE p_user_details SET first_name = ?, last_name = ?, email = ?, phone = ? WHERE id = ?";
    private static final String GET_QUERY = "SELECT first_name, last_name, email, phone FROM p_user_details WHERE id = %s";
    private static final String DELETE_QUERY = "DELETE FROM p_user_details WHERE id = %s";


    @Override
    public UserDetails get(Integer id) {
        String sql = String.format(GET_QUERY, id);
        UserDetails userDetails = null;
        try {
            Statement statement = Connector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                userDetails = new UserDetails(id, firstName, lastName, email, phone);
            }
            Connector.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userDetails;
    }

    @Override
    public UserDetails create(UserDetails userDetails) {
        PreparedStatement statement;
        try {
            statement = Connector.getConnection().prepareStatement(INSERT_QUERY);
            statement.setInt(1, userDetails.getId());
            statement.setString(2, userDetails.getFirstName());
            statement.setString(3, userDetails.getLastName());
            statement.setString(4, userDetails.getEmail());
            statement.setString(5, userDetails.getPhone());
            statement.executeUpdate();
            Connector.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userDetails;
    }

    @Override
    public UserDetails update(UserDetails userDetails) {
        PreparedStatement statement;
        try {
            statement = Connector.getConnection().prepareStatement(UPDATE_QUERY);
            statement.setString(1, userDetails.getFirstName());
            statement.setString(2, userDetails.getLastName());
            statement.setString(3, userDetails.getEmail());
            statement.setString(4, userDetails.getPhone());
            statement.setInt(5, userDetails.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userDetails;
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
    public List<UserDetails> getAll() {
        List<UserDetails> userDetailsList = new ArrayList<>();
        try {
            Statement statement = Connector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_QUERY);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                userDetailsList.add(new UserDetails(id, firstName, lastName, email, phone));
            }
            Connector.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userDetailsList;
    }
}
