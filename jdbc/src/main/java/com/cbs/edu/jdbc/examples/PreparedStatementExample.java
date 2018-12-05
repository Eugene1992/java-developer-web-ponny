package com.cbs.edu.jdbc.examples;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PreparedStatementExample {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://ec2-54-228-251-254.eu-west-1.compute.amazonaws.com:5432/d3kqlpsdudhcij?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";

    //  Database credentials
    static final String USER = "nykgmqvvdcegwm";
    static final String PASS = "bf201d90be9b4ae104d4aaa76ac8f63c8482ad8ff94f4d010f25f861066f8690";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.prepareStatement("INSERT INTO employees(first_name, last_name, age, email, gender, salary, id) VALUES(?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, "Tom");
            stmt.setString(2, "Tomson");
            stmt.setInt(3, 22);
            stmt.setString(4, "Tom21@gmail.com");
            stmt.setString(5, "Male");
            stmt.setInt(6, 22000);
            stmt.setInt(7, 51);

            stmt.execute();

            //STEP 6: Clean-up environment
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }//end main
}//end FirstExample