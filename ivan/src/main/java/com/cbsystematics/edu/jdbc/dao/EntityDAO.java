package com.cbsystematics.edu.jdbc.dao;

import com.cbsystematics.edu.jdbc.properties.DataBaseProperties;
import com.cbsystematics.edu.jdbc.utils.Logs;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EntityDAO<T> implements DAO<T>{

    @Override
    public T getEntity(Integer id) {
        return null;
    }

    @Override
    public T createEntity(T user) {
        return null;
    }

    @Override
    public T updateEntity(T user) {
        return null;
    }

    @Override
    public void deleteEntity(Integer id) {

    }

    @Override
    public List<T> getAllEntities() {
        return null;
    }
}
