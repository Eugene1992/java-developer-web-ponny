package com.cbsystematics.edu.jdbc.utils.dataBaseUtils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseConnection {

    private static Connection connection;
    private static final String
            HEROKU_DB_PROPERTIES_FILE_PATH = "database/heroku_database_connection.properties",
            DRIVER = "driver",
            URL = "url",
            USER = "username",
            PASSWORD = "password";

    static {
        Properties properties = new Properties();
        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(HEROKU_DB_PROPERTIES_FILE_PATH));
            Class.forName(properties.getProperty(DRIVER));
            connection = DriverManager.getConnection(
                    properties.getProperty(URL),
                    properties.getProperty(USER),
                    properties.getProperty(PASSWORD));
        } catch (IOException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    private DataBaseConnection() {
    }


}
