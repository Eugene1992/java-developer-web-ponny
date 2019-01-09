package com.cbs.edu.jdbc.examples.dao;

import com.cbs.edu.jdbc.config.ConnectionFactory;
import com.cbs.edu.jdbc.objects.AbstractEntity;


import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Properties;

public abstract class AbstractDAO<T extends AbstractEntity> implements DAO<T>  {

    protected Connection connection;
    private static final String QUERY_PROPERTIES_FILE_PASS = "queries.properties";
    private static Properties queryProperties;

    public AbstractDAO() {
        connection = ConnectionFactory.getConnection();
        try {
            queryProperties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(QUERY_PROPERTIES_FILE_PASS));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<T> getAll() {
        return null;
    }

    public String getQuery(String key){
        return queryProperties.getProperty(key);
    }
}
