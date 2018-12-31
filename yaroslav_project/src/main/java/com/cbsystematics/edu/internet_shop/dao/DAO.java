package com.cbsystematics.edu.internet_shop.dao;



import com.cbsystematics.edu.internet_shop.entities.AbstractEntity;

import java.util.List;

public interface DAO<T extends AbstractEntity> {
    T get(Integer id, Class<T> clazz);

    T create(T entity);

    T update(T entity);

    void delete(Integer id, Class<T> clazz);

    List<T> getAll(Class<T> clazz);

}
