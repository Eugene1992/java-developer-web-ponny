package com.cbs.edu.jdbc.examples;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FirstExample {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://ec2-54-228-251-254.eu-west-1.compute.amazonaws.com:5432/d3kqlpsdudhcij?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";

    //  Database credentials
    static final String USER = "nykgmqvvdcegwm";
    static final String PASS = "bf201d90be9b4ae104d4aaa76ac8f63c8482ad8ff94f4d010f25f861066f8690";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT id, first_name, last_name, age, salary FROM employees";
            ResultSet rs = stmt.executeQuery(sql);

            List<Employee> employees = new ArrayList<>();
            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("id");
                int age = rs.getInt("age");
                int salary = rs.getInt("salary");
                String first = rs.getString("first_name");
                String last = rs.getString("last_name");

                employees.add(new Employee(id, first, last, age, salary));
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();

            employees.stream().forEachOrdered(employee -> System.out.println(employee.getId() + ": " + employee));
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