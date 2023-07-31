package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modal.Book;
import utlity.ConnectionManager;

public class BookDAO {
    private Connection dbConn;

    public BookDAO() {
        try {
            dbConn = ConnectionManager.getConnection();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }

    // Method to add a new book to the database
    public void addBook(Book book) {
        String insertQuery = "INSERT INTO books (title, author, status) VALUES (?, ?, ?)";
        try (PreparedStatement ps = dbConn.prepareStatement(insertQuery)) {
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getStatus());

            ps.executeUpdate();
            System.out.println("Book added successfully.");
        } catch (SQLException e) {
            System.out.println("Error adding book: " + e.getMessage());
        }
    }

    // Method to retrieve a book by its ID from the database
    public Book getBookById(int bookId) {
        String selectQuery = "SELECT * FROM books WHERE book_id = ?";
        try (PreparedStatement ps = dbConn.prepareStatement(selectQuery)) {
            ps.setInt(1, bookId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String title = rs.getString("title");
                String author = rs.getString("author");
                String status = rs.getString("status");

                return new Book(bookId, title, author, status);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving book: " + e.getMessage());
        }
        return null; // Book not found in the database
    }

    // Method to retrieve all books from the database
    public List<Book> getAllBooks() {
        List<Book> bookList = new ArrayList<>();
        String selectQuery = "SELECT * FROM books";
        try (PreparedStatement ps = dbConn.prepareStatement(selectQuery)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int bookId = rs.getInt("book_id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String status = rs.getString("status");

                Book book = new Book(bookId, title, author, status);
                bookList.add(book);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving books: " + e.getMessage());
        }
        return bookList;
    }

    // Method to update a book in the database
    public void updateBook(Book book) {
        String updateQuery = "UPDATE books SET title = ?, author = ?, status = ? WHERE book_id = ?";
        try (PreparedStatement ps = dbConn.prepareStatement(updateQuery)) {
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getStatus());
            ps.setInt(4, book.getBookId());

            ps.executeUpdate();
            System.out.println("Book information updated successfully.");
        } catch (SQLException e) {
            System.out.println("Error updating book: " + e.getMessage());
        }
    }

    // Method to delete a book from the database
    public void deleteBook(int bookId) {
        String deleteQuery = "DELETE FROM books WHERE book_id = ?";
        try (PreparedStatement ps = dbConn.prepareStatement(deleteQuery)) {
            ps.setInt(1, bookId);

            ps.executeUpdate();
            System.out.println("Book deleted successfully.");
        } catch (SQLException e) {
            System.out.println("Error deleting book: " + e.getMessage());
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
