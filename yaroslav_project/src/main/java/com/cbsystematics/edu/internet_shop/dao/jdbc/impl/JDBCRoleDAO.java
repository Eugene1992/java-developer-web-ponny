package com.cbsystematics.edu.internet_shop.dao.jdbc.impl;

import com.cbsystematics.edu.internet_shop.config.Connector;
import com.cbsystematics.edu.internet_shop.dao.jdbc.RoleDAO;
import com.cbsystematics.edu.internet_shop.entities.Role;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCRoleDAO implements RoleDAO {
    private static final String INSERT_QUERY = "INSERT INTO p_roles (id, role_name) VALUES (?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM p_roles";
    private static final String UPDATE_QUERY = "UPDATE p_roles SET role_name = ? WHERE id = ?";
    private static final String GET_QUERY = "SELECT role_name FROM p_roles WHERE id = %s";
    private static final String DELETE_QUERY = "DELETE FROM p_roles WHERE id = %s";

    private static final String GET_ID_BY_NAME_QUERY = "SELECT id FROM p_roles WHERE role_name = %s";


    @Override
    public Role get(Integer id) {
        String sql = String.format(GET_QUERY, id);
        Role role = null;
        try {
            Statement statement = Connector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String name = resultSet.getString("role_name");
                role = new Role(id, name);
            }
            Connector.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }

    @Override
    public Role create(Role role) {
        PreparedStatement statement;
        try {
            statement = Connector.getConnection().prepareStatement(INSERT_QUERY);
            statement.setInt(1, role.getId());
            statement.setString(2, role.getName());
            statement.executeUpdate();
            Connector.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }

    @Override
    public Role update(Role role) {
        PreparedStatement statement;
        try {
            statement = Connector.getConnection().prepareStatement(UPDATE_QUERY);
            statement.setString(1, role.getName());
            statement.setInt(2, role.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
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
    public List<Role> getAll() {
        List<Role> roles = new ArrayList<>();
        try {
            Statement statement = Connector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_QUERY);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("role_name");
                roles.add(new Role(id, name));
            }
            Connector.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }


    @Override
    public int getIdByRoleName(String roleName) {
        String sql = String.format(GET_ID_BY_NAME_QUERY, roleName);
        int id = 0;
        try {
            Statement statement = Connector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                id = resultSet.getInt("id");
            }
            Connector.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

}
