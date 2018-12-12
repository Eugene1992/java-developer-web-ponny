package com.cbs.edu.jdbc.examples.structure.dao;

import com.cbs.edu.jdbc.examples.structure.entities.AbstractEntity;

import java.util.List;

public interface DAO<T extends AbstractEntity> {
    T get(Integer id);

    T create(T entity);

    T update(T entity);

    void delete(Integer id);

    List<T> getAll();
}
