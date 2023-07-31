package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modal.User;
import utlity.ConnectionManager;

public class UserDAO {
    private Connection dbConn;

    public UserDAO() {
        try {
            dbConn = ConnectionManager.getConnection();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }

    // Method to add a new user to the database
    public void addUser(User user) {
        String insertQuery = "INSERT INTO users (name, email) VALUES (?, ?)";
        try (PreparedStatement ps = dbConn.prepareStatement(insertQuery)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());

            ps.executeUpdate();
            System.out.println("User added successfully.");
        } catch (SQLException e) {
            System.out.println("Error adding user: " + e.getMessage());
        }
    }

    // Method to retrieve a user by their ID from the database
    public User getUserById(int userId) {
        String selectQuery = "SELECT * FROM users WHERE user_id = ?";
        try (PreparedStatement ps = dbConn.prepareStatement(selectQuery)) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");

                return new User(userId, name, email);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving user: " + e.getMessage());
        }
        return null; // User not found in the database
    }

    // Method to retrieve all users from the database
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        String selectQuery = "SELECT * FROM users";
        try (PreparedStatement ps = dbConn.prepareStatement(selectQuery)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int userId = rs.getInt("user_id");
                String name = rs.getString("name");
                String email = rs.getString("email");

                User user = new User(userId, name, email);
                userList.add(user);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving users: " + e.getMessage());
        }
        return userList;
    }

    // Method to update a user in the database
    public void updateUser(User user) {
        String updateQuery = "UPDATE users SET name = ?, email = ? WHERE user_id = ?";
        try (PreparedStatement ps = dbConn.prepareStatement(updateQuery)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setInt(3, user.getUserId());

            ps.executeUpdate();
            System.out.println("User information updated successfully.");
        } catch (SQLException e) {
            System.out.println("Error updating user: " + e.getMessage());
        }
    }

    // Method to delete a user from the database
    public void deleteUser(int userId) {
        String deleteQuery = "DELETE FROM users WHERE user_id = ?";
        try (PreparedStatement ps = dbConn.prepareStatement(deleteQuery)) {
            ps.setInt(1, userId);

            ps.executeUpdate();
            System.out.println("User deleted successfully.");
        } catch (SQLException e) {
            System.out.println("Error deleting user: " + e.getMessage());
        }
    }

    // Method to close the database connection
    public void closeConnection() {
        try {
            if (dbConn != null) {
                dbConn.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            System.out.println("Error closing database connection: " + e.getMessage());
        }
    }
}
