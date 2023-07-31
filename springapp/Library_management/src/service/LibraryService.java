package service;

import java.util.List;
import DAO.*;
import modal.*;

public class LibraryService {
    private BookDAO bookDAO;
    private UserDAO userDAO;
    private LibrarianDAO librarianDAO;
    private TransactionDAO transactionDAO;
    private BillDAO billDAO;

    public LibraryService() {
        bookDAO = new BookDAO();
        userDAO = new UserDAO();
        librarianDAO = new LibrarianDAO();
        transactionDAO = new TransactionDAO();
        billDAO = new BillDAO();
    }

    // Book-related methods
    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }

    public Book getBookById(int bookId) {
        return bookDAO.getBookById(bookId);
    }

    public void addBook(Book book) {
        bookDAO.addBook(book);
    }

    public void updateBook(Book book) {
        bookDAO.updateBook(book);
    }

    public void deleteBook(int bookId) {
        bookDAO.deleteBook(bookId);
    }

    // User-related methods
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    public User getUserById(int userId) {
        return userDAO.getUserById(userId);
    }

    public void addUser(User user) {
        userDAO.addUser(user);
    }

    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    public void deleteUser(int userId) {
        userDAO.deleteUser(userId);
    }

    // Librarian-related methods
    public Librarian getLibrarianById(int librarianId) {
        return librarianDAO.getLibrarianById(librarianId);
    }

    // Transaction-related methods
    public void addTransaction(Transaction transaction) {
        transactionDAO.addTransaction(transaction);
    }

    public List<Transaction> getTransactionsByUserId(int userId) {
        return transactionDAO.getTransactionsByUserId(userId);
    }

    public List<Transaction> getAllTransactions() {
        return transactionDAO.getAllTransactions();
    }

    public Transaction getTransaction(int userId, int bookId) {
        return transactionDAO.getTransaction(userId, bookId);
    }

    public void updateTransaction(Transaction transaction) {
        transactionDAO.updateTransaction(transaction);
    }

    // Bill-related methods
    public void addBill(Bill bill) {
        billDAO.addBill(bill);
    }

    public List<Bill> getBillsByUserId(int userId) {
        return billDAO.getBillsByUserId(userId);
    }

    public void closeConnection() {
        bookDAO.closeConnection();
        userDAO.closeConnection();
        librarianDAO.closeConnection();
        transactionDAO.closeConnection();
        billDAO.closeConnection();
    }
}
