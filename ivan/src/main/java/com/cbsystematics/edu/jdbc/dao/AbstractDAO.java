package com.cbsystematics.edu.jdbc.dao;

import com.cbsystematics.edu.jdbc.entities.AbstractEntity;
import com.cbsystematics.edu.jdbc.utils.dataBaseUtils.DataBaseConnection;

import javax.swing.*;
import java.sql.Connection;

public abstract class AbstractDAO<T extends AbstractEntity> implements DAO {

    protected Connection connection;

    public AbstractDAO(){
        connection = DataBaseConnection.getConnection();
    }


}
