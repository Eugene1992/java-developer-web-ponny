package com.cbsystematics.edu.internet_shop.repository;

import com.cbsystematics.edu.internet_shop.entity.AbstractEntity;

import java.util.List;

public interface GenericRepository<T extends AbstractEntity> {

    T get(Integer id);

    T create(T entity);

    T update(T entity);

    void delete(Integer id);

    List<T> getAll();
}
