package com.cbsystematics.edu.jdbc.dao;

import java.util.List;

public interface DAO<T> {
    T getEntity(Integer entityId);

    T createEntity(T entity);

    T updateEntity(T entity);

    void deleteEntity(Integer entityId);

    List<T> getAllEntities();
}
