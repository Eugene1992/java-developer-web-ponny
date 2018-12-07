package com.cbs.edu.jdbc;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.*;

@AllArgsConstructor
@Data
public class BaseConnection {
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://ec2-54-75-231-3.eu-west-1.compute.amazonaws.com:5432/d6uec6io8jv4i5?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
    static final String USER = "ifbgsxaraayrww";
    static final String PASS = "568b98fa7c19c03f26ca6639bd55f44fa7ffea82833b811b5d77c2cf3acf0ebc";

    private String sqlQuery;

    public ResultSet returnQueryResult() {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            return stmt.executeQuery(sqlQuery);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
