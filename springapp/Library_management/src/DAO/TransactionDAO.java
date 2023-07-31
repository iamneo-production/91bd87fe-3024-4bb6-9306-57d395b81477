package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modal.Transaction;
import utlity.ConnectionManager;

public class TransactionDAO {
 private Connection dbConn;

 public TransactionDAO() {
     try {
         dbConn = ConnectionManager.getConnection();
     } catch (ClassNotFoundException | SQLException e) {
         System.out.println("Error connecting to the database: " + e.getMessage());
     }
 }

 // Method to add a new transaction to the database
 public void addTransaction(Transaction transaction) {
     String insertQuery = "INSERT INTO transactions (transaction_id, user_id, book_id, issue_date, return_date) " +
                          "VALUES (?, ?, ?, ?, ?)";
     try (PreparedStatement ps = dbConn.prepareStatement(insertQuery)) {
         ps.setInt(1, transaction.getTransactionId());
         ps.setInt(2, transaction.getUserId());
         ps.setInt(3, transaction.getBookId());
         ps.setString(4, transaction.getIssueDate());
         ps.setString(5, transaction.getReturnDate());

         ps.executeUpdate();
         System.out.println("Transaction added successfully.");
     } catch (SQLException e) {
         System.out.println("Error adding transaction: " + e.getMessage());
     }
 }

 // Method to retrieve transactions by user ID from the database
 public List<Transaction> getTransactionsByUserId(int userId) {
     List<Transaction> transactionList = new ArrayList<>();
     String selectQuery = "SELECT * FROM transactions WHERE user_id = ?";
     try (PreparedStatement ps = dbConn.prepareStatement(selectQuery)) {
         ps.setInt(1, userId);
         ResultSet rs = ps.executeQuery();

         while (rs.next()) {
             int transactionId = rs.getInt("transaction_id");
             int bookId = rs.getInt("book_id");
             String issueDate = rs.getString("issue_date");
             String returnDate = rs.getString("return_date");

             Transaction transaction = new Transaction(transactionId, userId, bookId, issueDate, returnDate);
             transactionList.add(transaction);
         }
     } catch (SQLException e) {
         System.out.println("Error retrieving transactions: " + e.getMessage());
     }
     return transactionList;
 }

 // Method to retrieve transactions by book ID from the database
 public List<Transaction> getTransactionsByBookId(int bookId) {
     List<Transaction> transactionList = new ArrayList<>();
     String selectQuery = "SELECT * FROM transactions WHERE book_id = ?";
     try (PreparedStatement ps = dbConn.prepareStatement(selectQuery)) {
         ps.setInt(1, bookId);
         ResultSet rs = ps.executeQuery();

         while (rs.next()) {
             int transactionId = rs.getInt("transaction_id");
             int userId = rs.getInt("user_id");
             String issueDate = rs.getString("issue_date");
             String returnDate = rs.getString("return_date");

             Transaction transaction = new Transaction(transactionId, userId, bookId, issueDate, returnDate);
             transactionList.add(transaction);
         }
     } catch (SQLException e) {
         System.out.println("Error retrieving transactions: " + e.getMessage());
     }
     return transactionList;
 }

 // Method to retrieve all transactions from the database
 public List<Transaction> getAllTransactions() {
     List<Transaction> transactionList = new ArrayList<>();
     String selectQuery = "SELECT * FROM transactions";
     try (PreparedStatement ps = dbConn.prepareStatement(selectQuery)) {
         ResultSet rs = ps.executeQuery();

         while (rs.next()) {
             int transactionId = rs.getInt("transaction_id");
             int userId = rs.getInt("user_id");
             int bookId = rs.getInt("book_id");
             String issueDate = rs.getString("issue_date");
             String returnDate = rs.getString("return_date");

             Transaction transaction = new Transaction(transactionId, userId, bookId, issueDate, returnDate);
             transactionList.add(transaction);
         }
     } catch (SQLException e) {
         System.out.println("Error retrieving transactions: " + e.getMessage());
     }
     return transactionList;
 }

 // Method to update transaction information in the database
 public void updateTransaction(Transaction transaction) {
     String updateQuery = "UPDATE transactions SET user_id = ?, book_id = ?, issue_date = ?, return_date = ? " +
                          "WHERE transaction_id = ?";
     try (PreparedStatement ps = dbConn.prepareStatement(updateQuery)) {
         ps.setInt(1, transaction.getUserId());
         ps.setInt(2, transaction.getBookId());
         ps.setString(3, transaction.getIssueDate());
         ps.setString(4, transaction.getReturnDate());
         ps.setInt(5, transaction.getTransactionId());

         ps.executeUpdate();
         System.out.println("Transaction information updated successfully.");
     } catch (SQLException e) {
         System.out.println("Error updating transaction: " + e.getMessage());
     }
 }
//Method to retrieve a transaction by userId and bookId from the database
public Transaction getTransaction(int userId, int bookId) {
  String selectQuery = "SELECT * FROM transactions WHERE user_id = ? AND book_id = ?";
  try (PreparedStatement ps = dbConn.prepareStatement(selectQuery)) {
      ps.setInt(1, userId);
      ps.setInt(2, bookId);
      ResultSet rs = ps.executeQuery();

      if (rs.next()) {
          int transactionId = rs.getInt("transaction_id");
          String issueDate = rs.getString("issue_date");
          String returnDate = rs.getString("return_date");

          return new Transaction(transactionId, userId, bookId, issueDate, returnDate);
      }
  } catch (SQLException e) {
      System.out.println("Error retrieving transaction: " + e.getMessage());
  }
  return null; // Transaction not found in the database
}


 // Method to delete a transaction from the database
 public void deleteTransaction(int transactionId) {
     String deleteQuery = "DELETE FROM transactions WHERE transaction_id = ?";
     try (PreparedStatement ps = dbConn.prepareStatement(deleteQuery)) {
         ps.setInt(1, transactionId);

         ps.executeUpdate();
         System.out.println("Transaction deleted successfully.");
     } catch (SQLException e) {
         System.out.println("Error deleting transaction: " + e.getMessage());
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
