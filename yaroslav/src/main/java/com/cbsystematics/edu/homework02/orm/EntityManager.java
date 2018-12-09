package com.cbsystematics.edu.homework02.orm;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EntityManager {

    public <T> List<T> getAll(Class<T> clazz) {
        List<T> list = new ArrayList<>();
        try {
            String sql = Methods.getSqlQueryGetAll(clazz);
            Statement statement = Connector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                T t = clazz.newInstance();
                Methods.setAllValuesToFields(t, resultSet);
                list.add(t);
            }
            resultSet.close();
            statement.close();
            Connector.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return list;
    }

    public <T> T create(T t) {
        String sql;
        PreparedStatement statement;
        try {
            sql = Methods.getSqlQueryForCreate(t);
            statement = Connector.getConnection().prepareStatement(sql);
            statement.executeUpdate();
            statement.close();
            Connector.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    public <T> T update(T t) {
        String sql = null;
        PreparedStatement statement;
        try {
            sql = Methods.getSqlQueryForUpdate(t);
            statement = Connector.getConnection().prepareStatement(sql);
            statement.executeUpdate();
            statement.close();
            Connector.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(sql);
        return t;
    }

    public <T, I> void delete(I id, Class<T> clazz) {
        String sql;
        try {
            sql = Methods.getSqlQueryForDelete(id, clazz);
            System.out.println(sql);
            PreparedStatement statement = Connector.getConnection().prepareStatement(sql);
            statement.executeUpdate();
            statement.close();
            Connector.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public <T, I> T get(I id, Class<T> clazz) {
        T t = null;
        try {
            String sql = Methods.getSqlQueryForGet(id, clazz);
            Statement statement = Connector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            t = clazz.newInstance();
            while (resultSet.next()) {
                Methods.setAllValuesToFields(t, resultSet);
            }
            resultSet.close();
            statement.close();
            Connector.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }


}
