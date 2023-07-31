package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modal.Librarian;
import utlity.ConnectionManager;

public class LibrarianDAO {
    private Connection dbConn;

    public LibrarianDAO() {
        try {
            dbConn = ConnectionManager.getConnection();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }

    // Method to add a new librarian to the database
    public void addLibrarian(Librarian librarian) {
        String insertQuery = "INSERT INTO librarians (librarian_id, name, email, password) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = dbConn.prepareStatement(insertQuery)) {
            ps.setInt(1, librarian.getLibrarianId());
            ps.setString(2, librarian.getName());
            ps.setString(3, librarian.getEmail());
            ps.setString(4, librarian.getPassword());

            ps.executeUpdate();
            System.out.println("Librarian added successfully.");
        } catch (SQLException e) {
            System.out.println("Error adding librarian: " + e.getMessage());
        }
    }

    // Method to retrieve a librarian by ID from the database
    public Librarian getLibrarianById(int librarianId) {
        Librarian librarian = null;
        String selectQuery = "SELECT * FROM librarians WHERE librarian_id = ?";
        try (PreparedStatement ps = dbConn.prepareStatement(selectQuery)) {
            ps.setInt(1, librarianId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("password");

                librarian = new Librarian(librarianId, name, email, password);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving librarian: " + e.getMessage());
        }
        return librarian;
    }

    // Method to retrieve a librarian by email and password from the database
    public Librarian getLibrarianByEmailAndPassword(String email, String password) {
        Librarian librarian = null;
        String selectQuery = "SELECT * FROM librarians WHERE email = ? AND password = ?";
        try (PreparedStatement ps = dbConn.prepareStatement(selectQuery)) {
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int librarianId = rs.getInt("librarian_id");
                String name = rs.getString("name");

                librarian = new Librarian(librarianId, name, email, password);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving librarian: " + e.getMessage());
        }
        return librarian;
    }

    // Method to retrieve all librarians from the database
    public List<Librarian> getAllLibrarians() {
        List<Librarian> librarianList = new ArrayList<>();
        String selectQuery = "SELECT * FROM librarians";
        try (PreparedStatement ps = dbConn.prepareStatement(selectQuery)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int librarianId = rs.getInt("librarian_id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("password");

                Librarian librarian = new Librarian(librarianId, name, email, password);
                librarianList.add(librarian);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving librarians: " + e.getMessage());
        }
        return librarianList;
    }

    // Method to update librarian information in the database
    public void updateLibrarian(Librarian librarian) {
        String updateQuery = "UPDATE librarians SET name = ?, email = ?, password = ? WHERE librarian_id = ?";
        try (PreparedStatement ps = dbConn.prepareStatement(updateQuery)) {
            ps.setString(1, librarian.getName());
            ps.setString(2, librarian.getEmail());
            ps.setString(3, librarian.getPassword());
            ps.setInt(4, librarian.getLibrarianId());

            ps.executeUpdate();
            System.out.println("Librarian information updated successfully.");
        } catch (SQLException e) {
            System.out.println("Error updating librarian: " + e.getMessage());
        }
    }

    // Method to delete a librarian from the database
    public void deleteLibrarian(int librarianId) {
        String deleteQuery = "DELETE FROM librarians WHERE librarian_id = ?";
        try (PreparedStatement ps = dbConn.prepareStatement(deleteQuery)) {
            ps.setInt(1, librarianId);

            ps.executeUpdate();
            System.out.println("Librarian deleted successfully.");
        } catch (SQLException e) {
            System.out.println("Error deleting librarian: " + e.getMessage());
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
