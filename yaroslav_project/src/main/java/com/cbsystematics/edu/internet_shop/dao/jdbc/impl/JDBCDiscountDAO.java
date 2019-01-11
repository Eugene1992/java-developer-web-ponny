package com.cbsystematics.edu.internet_shop.dao.jdbc.impl;

import com.cbsystematics.edu.internet_shop.config.JDBCConnector;
import com.cbsystematics.edu.internet_shop.dao.jdbc.DiscountDAO;
import com.cbsystematics.edu.internet_shop.entities.Discount;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCDiscountDAO implements DiscountDAO {
    private static final String INSERT_QUERY = "INSERT INTO p_discounts (id, discount_name, amount) VALUES (?, ?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM p_discounts";
    private static final String UPDATE_QUERY = "UPDATE p_discounts SET discount_name = ?, amount = ? WHERE id = ?";
    private static final String GET_QUERY = "SELECT discount_name, amount FROM p_discounts WHERE id = %s";
    private static final String DELETE_QUERY = "DELETE FROM p_discounts WHERE id = %s";

    private static final String AMOUNT = "amount";
    private static final String NAME = "discount_name";
    private static final String ID = "id";

    @Override
    public Discount get(Integer id) {
        String sql = String.format(GET_QUERY, id);
        Discount discount = null;
        try {
            Statement statement = JDBCConnector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String name = resultSet.getString(NAME);
                double amount = resultSet.getInt(AMOUNT);
                discount = new Discount(id, name, amount);
            }
            JDBCConnector.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return discount;
    }

    @Override
    public Discount create(Discount discount) {
        PreparedStatement statement;
        try {
            statement = JDBCConnector.getConnection().prepareStatement(INSERT_QUERY);
            statement.setInt(1, discount.getId());
            statement.setString(2, discount.getName());
            statement.setDouble(3, discount.getAmount());
            statement.executeUpdate();
            JDBCConnector.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return discount;
    }

    @Override
    public Discount update(Discount discount) {
        PreparedStatement statement;
        try {
            statement = JDBCConnector.getConnection().prepareStatement(UPDATE_QUERY);
            statement.setString(1, discount.getName());
            statement.setDouble(2, discount.getAmount());
            statement.setInt(3, discount.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return discount;
    }

    @Override
    public void delete(Integer id) {
        String sql = String.format(DELETE_QUERY, id);
        try {
            PreparedStatement statement = JDBCConnector.getConnection().prepareStatement(sql);
            statement.executeUpdate();
            JDBCConnector.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Discount> getAll() {
        List<Discount> discounts = new ArrayList<>();
        try {
            Statement statement = JDBCConnector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_QUERY);
            while (resultSet.next()) {
                int id = resultSet.getInt(ID);
                String discountName = resultSet.getString(NAME);
                double amount = resultSet.getInt(AMOUNT);
                discounts.add(new Discount(id, discountName, amount));
            }
            JDBCConnector.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return discounts;
    }
}
