package com.cbs.edu.jdbc.dao;

import com.cbs.edu.jdbc.objects.AbstractEntity;

import java.util.List;

public interface DAO<T extends AbstractEntity> {
    T get(Integer id);
    T cteate (T entity);
    T update (T entity);
    void delete(Integer id);
    List<T> getAll();
}
