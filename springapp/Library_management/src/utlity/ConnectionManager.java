package utlity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    // JDBC connection parameters
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mini_project";
    private static final String USER = "root";
    private static final String PASSWORD = "Dharani2d@";

    // Method to get a database connection
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        // Register the new driver class
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Create and return the database connection
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }
}
