package com.cbsystematics.edu.jdbc.dao;

import com.cbsystematics.edu.jdbc.entities.AbstractEntity;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T extends AbstractEntity> {
    T get(Integer id) throws SQLException;

    T create(T entity);

    T update(T entity);

    void delete(Integer id);

    List<T> getAll();
}
