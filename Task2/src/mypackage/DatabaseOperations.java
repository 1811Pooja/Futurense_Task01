package mypackage;

import java.sql.*;

public class DatabaseOperations {

    // Establishing Database Connection
    public static Connection establishConnection(String url, String username, String password) throws DatabaseConnectionException {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (SQLException e) {
            throw new DatabaseConnectionException("Failed to connect to the database");
        }
    }

    // Insert Data into Users Table
    public static void insertUserData(Connection connection, String username, String email) throws DataIntegrityViolationException {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Users (username, email) VALUES (?, ?)");
            statement.setString(1, username);
            statement.setString(2, email);
            statement.executeUpdate();
            System.out.println("Data inserted successfully.");
        } catch (SQLException e) {
            // Check for specific SQL error codes related to integrity violations
            if (e.getErrorCode() == 1) { // Oracle error code for unique constraint violation
                throw new DataIntegrityViolationException("Data integrity violation: Duplicate entry for username or email.");
            } else {
                System.err.println("Error while inserting data: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@//localhost:1521/XE";
        String username = "MyD";
        String password = "MyDB";

        try {
            // Register Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Establishing Database Connection
            Connection connection = establishConnection(url, username, password);
            // Sample Input Data
            String sampleUsername = "john_doe";
            String sampleEmail = "john@example.com";

            // Inserting Sample Data into Users Table
           insertUserData(connection, sampleUsername, sampleEmail);
          // insertUserData(connection, sampleUsername, sampleEmail);

            // Close the Connection
            connection.close();
        } catch (ClassNotFoundException e) {
            System.err.println("Oracle JDBC driver not found!");
        } catch (DatabaseConnectionException e) {
            System.err.println("Failed to connect to the Database" );
        } catch (DataIntegrityViolationException e) {
            System.err.println("Data Integrity Violation Exception: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
        }
    }
}