package com.cbsystematics.edu.jdbc.dao.impl;

import com.cbsystematics.edu.jdbc.dao.AbstractDAO;
import com.cbsystematics.edu.jdbc.dao.DAO;
import com.cbsystematics.edu.jdbc.entities.AbstractEntity;
import com.cbsystematics.edu.jdbc.entities.User;
import com.cbsystematics.edu.jdbc.utils.dataBaseUtils.DataBaseElementsParser;
import com.cbsystematics.edu.jdbc.utils.reflectionUtils.objectUtils.ObjectParser;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDAO extends AbstractDAO<User> implements DAO {
    @Override
    public AbstractEntity get(Integer id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM"
                + new DataBaseElementsParser(this).getTableName()
                + "WHERE id="
                + ObjectParser.getFieldsAnnotatedNameAndValuesMap(this).get("id"));
        statement.execute();

        return null;
    }

    @Override
    public AbstractEntity create(AbstractEntity entity) {
        return null;
    }

    @Override
    public AbstractEntity update(AbstractEntity entity) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List getAll() {
        return null;
    }
}
