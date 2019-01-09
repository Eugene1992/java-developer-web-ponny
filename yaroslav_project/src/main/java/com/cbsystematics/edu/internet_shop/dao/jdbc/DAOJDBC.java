package com.cbsystematics.edu.internet_shop.dao.jdbc;

import com.cbsystematics.edu.internet_shop.entities.AbstractEntity;

import java.util.List;

public interface DAOJDBC<T extends AbstractEntity> {
    T get(Integer id);

    T create(T entity);

    T update(T entity);

    void delete(Integer idz);

    List<T> getAll();
}
