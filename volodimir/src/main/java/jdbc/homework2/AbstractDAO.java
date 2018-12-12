package jdbc.homework2;

import jdbc.connection_factory.ConnectionFactory;
import jdbc.homework1.dao.DAO;
import jdbc.homework1.entities.AbstractEntity;

import java.sql.Connection;

public abstract class AbstractDAO<T extends AbstractEntity> implements DAO<T> {

    protected Connection connection;

    public AbstractDAO() {
        connection = ConnectionFactory.getConnection();
    }

}
