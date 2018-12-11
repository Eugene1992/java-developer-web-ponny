package com.cbs.edu.jdbc.dao;

import com.cbs.edu.jdbc.config.ConnectionFactory;
import com.cbs.edu.jdbc.objects.AbstractEntity;


import java.sql.Connection;
import java.util.List;

public abstract class AbstractDAO<T extends AbstractEntity> implements DAO<T>  {

    protected Connection connection;

    public AbstractDAO() {
        connection = ConnectionFactory.getConnection();
    }

    @Override
    public List<T> getAll() {
        return null;
    }
}
