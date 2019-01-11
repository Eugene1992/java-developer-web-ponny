package com.cbsystematics.edu.internet_shop.dao.jdbc.impl;

import com.cbsystematics.edu.internet_shop.config.JDBCConnector;
import com.cbsystematics.edu.internet_shop.dao.jdbc.ProductDAO;
import com.cbsystematics.edu.internet_shop.entities.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class JDBCProductDAO implements ProductDAO {

    private static final String INSERT_QUERY = "INSERT INTO p_products (id, title, description, price, category) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM p_products";
    private static final String UPDATE_QUERY = "UPDATE p_products SET title = ?, description = ?, category = ?, price = ? WHERE id = ?";
    private static final String GET_QUERY = "SELECT title, description, category, price FROM p_products WHERE id = %s";
    private static final String DELETE_QUERY = "DELETE FROM p_products WHERE id = %s";

    private static final String TITLE = "title";
    private static final String DESCRIPTION = "description";
    private static final String PRICE = "price";
    private static final String CATEGORY = "category";
    private static final String ID = "id";


    @Override
    public Product get(Integer id) {
        String sql = String.format(GET_QUERY, id);
        Product product = null;
        try {
            Statement statement = JDBCConnector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String title = resultSet.getString(TITLE);
                String description = resultSet.getString(DESCRIPTION);
                int price = resultSet.getInt(PRICE);
                String category = resultSet.getString(CATEGORY);
                product = new Product(id, title, description, category, price);
            }
            JDBCConnector.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public Product create(Product product) {
        PreparedStatement statement;
        try {
            statement = JDBCConnector.getConnection().prepareStatement(INSERT_QUERY);
            statement.setInt(1, product.getId());
            statement.setString(2, product.getTitle());
            statement.setString(3, product.getDescription());
            statement.setInt(4, product.getPrice());
            statement.setString(5, product.getCategory());
            statement.executeUpdate();
            JDBCConnector.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public Product update(Product product) {
        PreparedStatement statement;
        try {
            statement = JDBCConnector.getConnection().prepareStatement(UPDATE_QUERY);
            statement.setString(1, product.getTitle());
            statement.setString(2, product.getDescription());
            statement.setString(3, product.getCategory());
            statement.setInt(4, product.getPrice());
            statement.setInt(5, product.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
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
    public List<Product> getAll() {
        List<Product> students = new ArrayList<>();
        try {
            Statement statement = JDBCConnector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_QUERY);
            while (resultSet.next()) {
                int id = resultSet.getInt(ID);
                String title = resultSet.getString(TITLE);
                String description = resultSet.getString(DESCRIPTION);
                int price = resultSet.getInt(PRICE);
                String category = resultSet.getString(CATEGORY);
                students.add(new Product(id, title, description, category, price));
            }
            JDBCConnector.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}
