package jdbc;

import jdbc.homework1.entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Connecting {
    // JDBS driver name and datebase URL
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "impl:postgresql://ec2-54-228-251-254.eu-west-1.compute.amazonaws.com:5432/d3kqlpsdudhcij?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";

    //Database credentials
    static final String USER = "ioydnioodesglo";
    static final String PASS = "7d4b2c9cf7793e2cf54d66a1ade76fcb81fe6b549996a722c9acbf2aa9ff8093";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // STEP 2: Register JDBS Driver
            Class.forName(JDBC_DRIVER);

            // STEP 3: Open a connection
            System.out.print("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT id, first_name, last_name, age, salary FROM employees";
            ResultSet rs = stmt.executeQuery(sql);

            List<User> employees = new ArrayList<>();
            // STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("id");
                int age = rs.getInt("age");
                int salary = rs.getInt("salary");
                String first = rs.getString("first_name");
                String last = rs.getString("last_name");

//                employees.add(new User(id, first, last, age, salary));
            }
            // STEP 6: Clean up environment
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException se) {
            // Handle errors for JDBS
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }//nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
