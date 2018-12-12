package com.cbs.edu.jdbc.examples.structure.dao;

import com.cbs.edu.jdbc.examples.structure.config.ConnectionFactory;
import com.cbs.edu.jdbc.examples.structure.entities.AbstractEntity;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Properties;

public abstract class AbstractDAO<T extends AbstractEntity> implements DAO<T> {

    protected Connection connection;
    private Properties queryProperties;

    private static final String QUERY_PROPERTIES_FILE_PATH = "queries.properties";

    public AbstractDAO() {
        connection = ConnectionFactory.getConnection();
        try {
            queryProperties = new Properties();
            queryProperties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(QUERY_PROPERTIES_FILE_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<T> getAll() {
        return null;
    }

    public String getQuery(String key) {
        return queryProperties.getProperty(key);
    }
}
