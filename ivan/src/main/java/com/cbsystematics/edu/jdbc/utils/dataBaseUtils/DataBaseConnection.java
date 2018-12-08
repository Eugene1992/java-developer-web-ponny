package com.cbsystematics.edu.jdbc.utils.dataBaseUtils;

import com.cbsystematics.edu.jdbc.properties.DataBaseProperties;
import com.cbsystematics.edu.jdbc.utils.Logs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBaseConnection {

    static Connection currentConnection;
    static PreparedStatement preparedStatement;

    static {
        Connection conn;
        try {
            //Register JDBC driver
            Class.forName(DataBaseProperties.JDBC_DRIVER.getPropertyValue());

            //Open a connection
            System.out.println(Logs.DATA_BASE_CONNECTION.getLogText());

            conn = DriverManager.getConnection(DataBaseProperties.DATA_BASE_URL.getPropertyValue(),
                    DataBaseProperties.USER.getPropertyValue(),
                    DataBaseProperties.PASSWORD.getPropertyValue());

            currentConnection = conn;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


}
