package com.cbs.edu.eshop.dao;


import com.cbs.edu.eshop.entity.AbstractEntity;

import java.util.List;

public interface GenericDAO<T extends AbstractEntity> {
    T get(Integer id);

    T create(T entity);

    T update(T entity);

    void delete(Integer id);

    List<T> getAll();
}
