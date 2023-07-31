package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modal.Bill;
import utlity.ConnectionManager;

public class BillDAO {
 private Connection dbConn;

 public BillDAO() {
     try {
         dbConn = ConnectionManager.getConnection();
     } catch (ClassNotFoundException | SQLException e) {
         System.out.println("Error connecting to the database: " + e.getMessage());
     }
 }

 // Method to add a new bill to the database
//Method to add a new bill to the database
public void addBill(Bill bill) {
  String insertQuery = "INSERT INTO bills (user_id, book_id, issue_date, return_date, fine_amount) VALUES (?, ?, ?, ?, ?)";
  try (PreparedStatement ps = dbConn.prepareStatement(insertQuery)) {
      ps.setInt(1, bill.getUserId());
      ps.setInt(2, bill.getBookId());
      ps.setString(3, bill.getIssueDate());
      ps.setString(4, bill.getReturnDate());
      ps.setDouble(5, bill.getFineAmount());

      ps.executeUpdate();
      System.out.println("Bill added successfully.");
  } catch (SQLException e) {
      System.out.println("Error adding bill: " + e.getMessage());
  }
}


 // Method to retrieve bills by user ID from the database
 public List<Bill> getBillsByUserId(int userId) {
     List<Bill> billList = new ArrayList<>();
     String selectQuery = "SELECT * FROM bills WHERE user_id = ?";
     try (PreparedStatement ps = dbConn.prepareStatement(selectQuery)) {
         ps.setInt(1, userId);
         ResultSet rs = ps.executeQuery();

         while (rs.next()) {
             int billId = rs.getInt("bill_id");
             int bookId = rs.getInt("book_id");
             String issueDate = rs.getString("issue_date");
             String returnDate = rs.getString("return_date");
             double fineAmount = rs.getDouble("fine_amount");

             Bill bill = new Bill(billId, userId, bookId, issueDate, returnDate, fineAmount);
             billList.add(bill);
         }
     } catch (SQLException e) {
         System.out.println("Error retrieving bills: " + e.getMessage());
     }
     return billList;
 }

 // Method to retrieve bills by book ID from the database
 public List<Bill> getBillsByBookId(int bookId) {
     List<Bill> billList = new ArrayList<>();
     String selectQuery = "SELECT * FROM bills WHERE book_id = ?";
     try (PreparedStatement ps = dbConn.prepareStatement(selectQuery)) {
         ps.setInt(1, bookId);
         ResultSet rs = ps.executeQuery();

         while (rs.next()) {
             int billId = rs.getInt("bill_id");
             int userId = rs.getInt("user_id");
             String issueDate = rs.getString("issue_date");
             String returnDate = rs.getString("return_date");
             double fineAmount = rs.getDouble("fine_amount");

             Bill bill = new Bill(billId, userId, bookId, issueDate, returnDate, fineAmount);
             billList.add(bill);
         }
     } catch (SQLException e) {
         System.out.println("Error retrieving bills: " + e.getMessage());
     }
     return billList;
 }

 // Method to retrieve all bills from the database
 public List<Bill> getAllBills() {
     List<Bill> billList = new ArrayList<>();
     String selectQuery = "SELECT * FROM bills";
     try (PreparedStatement ps = dbConn.prepareStatement(selectQuery)) {
         ResultSet rs = ps.executeQuery();

         while (rs.next()) {
             int billId = rs.getInt("bill_id");
             int userId = rs.getInt("user_id");
             int bookId = rs.getInt("book_id");
             String issueDate = rs.getString("issue_date");
             String returnDate = rs.getString("return_date");
             double fineAmount = rs.getDouble("fine_amount");

             Bill bill = new Bill(billId, userId, bookId, issueDate, returnDate, fineAmount);
             billList.add(bill);
         }
     } catch (SQLException e) {
         System.out.println("Error retrieving bills: " + e.getMessage());
     }
     return billList;
 }

 // Method to update bill information in the database
 public void updateBill(Bill bill) {
     String updateQuery = "UPDATE bills SET user_id = ?, book_id = ?, issue_date = ?, return_date = ?, fine_amount = ? " +
                          "WHERE bill_id = ?";
     try (PreparedStatement ps = dbConn.prepareStatement(updateQuery)) {
         ps.setInt(1, bill.getUserId());
         ps.setInt(2, bill.getBookId());
         ps.setString(3, bill.getIssueDate());
         ps.setString(4, bill.getReturnDate());
         ps.setDouble(5, bill.getFineAmount());
         ps.setInt(6, bill.getBillId());

         ps.executeUpdate();
         System.out.println("Bill information updated successfully.");
     } catch (SQLException e) {
         System.out.println("Error updating bill: " + e.getMessage());
     }
 }

 // Method to delete a bill from the database
 public void deleteBill(int billId) {
     String deleteQuery = "DELETE FROM bills WHERE bill_id = ?";
     try (PreparedStatement ps = dbConn.prepareStatement(deleteQuery)) {
         ps.setInt(1, billId);

         ps.executeUpdate();
         System.out.println("Bill deleted successfully.");
     } catch (SQLException e) {
         System.out.println("Error deleting bill: " + e.getMessage());
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
