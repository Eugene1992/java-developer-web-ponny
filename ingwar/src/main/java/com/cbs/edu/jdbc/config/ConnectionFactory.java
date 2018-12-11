package com.cbs.edu.jdbc.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {
    private static final String DB_PROPERTIES_FILE_PASS = "db.properties",
            DRIVER = "driver",
            URL = "url",
            USERNAME = "username",
            PASSWORD = "password";
    private static Connection connection;
    private static Properties configProperties;

    static {
        configProperties = new Properties();
        try {
            configProperties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(DB_PROPERTIES_FILE_PASS));
            Class.forName(configProperties.getProperty(DRIVER));
            connection = DriverManager.getConnection(
                    configProperties.getProperty(URL),
                    configProperties.getProperty(USERNAME),
                    configProperties.getProperty(PASSWORD)
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ConnectionFactory() {
    }

    public static Connection getConnection() {
        return connection;
    }
}
