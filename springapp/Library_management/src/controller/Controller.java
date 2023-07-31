package controller;

import java.util.List;
import java.util.Scanner;
import DAO.*;
import modal.*;

public class Controller {
    private Scanner scanner;
    private BookDAO bookDAO;
    private UserDAO userDAO;
    private LibrarianDAO librarianDAO;
    private TransactionDAO transactionDAO;
    private BillDAO billDAO;

    public Controller() {
        scanner = new Scanner(System.in);
        bookDAO = new BookDAO();
        userDAO = new UserDAO();
        librarianDAO = new LibrarianDAO();
        transactionDAO = new TransactionDAO();
        billDAO = new BillDAO();
    }

    public void start() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nLIBRARY MANAGEMENT SYSTEM");
            System.out.println("1. User Login");
            System.out.println("2. Librarian Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    userLogin();
                    break;
                case 2:
                    librarianLogin();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
        System.out.println("Thank you for using the Library Management System. Goodbye!");
    }

    private void userLogin() {
        System.out.print("\nEnter User ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        User user = userDAO.getUserById(userId);
        if (user != null) {
            System.out.println("\nWelcome, " + user.getName() + "!");
            userMenu(user);
        } else {
            System.out.println("User with ID " + userId + " not found.");
        }
    }

    private void librarianLogin() {
        System.out.print("\nEnter Librarian ID: ");
        int librarianId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        Librarian librarian = librarianDAO.getLibrarianById(librarianId);
        if (librarian != null) {
            System.out.println("\nWelcome, Librarian " + librarian.getName() + "!");
            librarianMenu();
        } else {
            System.out.println("Librarian with ID " + librarianId + " not found.");
        }
    }

    private void userMenu(User user) {
        boolean logout = false;
        while (!logout) {
            System.out.println("\nUSER MENU");
            System.out.println("1. View All Books");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. View My Transactions");
            System.out.println("5. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    viewAllBooks();
                    break;
                case 2:
                    borrowBook(user.getUserId());
                    break;
                case 3:
                    returnBook(user.getUserId());
                    break;
                case 4:
                    viewMyTransactions(user.getUserId());
                    break;
                case 5:
                    logout = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void librarianMenu() {
        boolean logout = false;
        while (!logout) {
            System.out.println("\nLIBRARIAN MENU");
            System.out.println("1. View All Books");
            System.out.println("2. Add Book");
            System.out.println("3. Update Book");
            System.out.println("4. Delete Book");
            System.out.println("5. View All Users");
            System.out.println("6. Add User");
            System.out.println("7. Update User");
            System.out.println("8. Delete User");
            System.out.println("9. View All Transactions");
            System.out.println("10. Generate Bill");
            System.out.println("11. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    viewAllBooks();
                    break;
                case 2:
                    addBook();
                    break;
                case 3:
                    updateBook();
                    break;
                case 4:
                    deleteBook();
                    break;
                case 5:
                    viewAllUsers();
                    break;
                case 6:
                    addUser();
                    break;
                case 7:
                    updateUser();
                    break;
                case 8:
                    deleteUser();
                    break;
                case 9:
                    viewAllTransactions();
                    break;
                case 10:
                    generateBill();
                    break;
                case 11:
                    logout = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void viewAllBooks() {
        List<Book> books = bookDAO.getAllBooks();
        if (books.isEmpty()) {
            System.out.println("No books found in the library.");
        } else {
            System.out.println("\nBOOKS IN THE LIBRARY");
            System.out.println("Book ID\tTitle\tAuthor\tStatus");
            for (Book book : books) {
                System.out.println(book.getBookId() + "\t" + book.getTitle() + "\t" + book.getAuthor() + "\t" + book.getStatus());
            }
        }
    }

    private void addBook() {
        System.out.print("\nEnter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        Book book = new Book(0, title, author, "Available");
        bookDAO.addBook(book);
    }


    private void updateBook() {
        System.out.print("\nEnter Book ID to update: ");
        int bookId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        Book book = bookDAO.getBookById(bookId);
        if (book == null) {
            System.out.println("Book with ID " + bookId + " not found.");
            return;
        }

        System.out.print("Enter new Title: ");
        String newTitle = scanner.nextLine();
        System.out.print("Enter new Author: ");
        String newAuthor = scanner.nextLine();

        book.setTitle(newTitle);
        book.setAuthor(newAuthor);
        bookDAO.updateBook(book);
    }

    private void deleteBook() {
        System.out.print("\nEnter Book ID to delete: ");
        int bookId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        bookDAO.deleteBook(bookId);
    }

    private void viewAllUsers() {
        List<User> users = userDAO.getAllUsers();
        if (users.isEmpty()) {
            System.out.println("No users found in the system.");
        } else {
            System.out.println("\nUSERS IN THE SYSTEM");
            System.out.println("User ID\tName\tEmail");
            for (User user : users) {
                System.out.println(user.getUserId() + "\t" + user.getName() + "\t" + user.getEmail());
            }
        }
    }

    private void addUser() {
        System.out.print("\nEnter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        User user = new User(0,name, email);
        userDAO.addUser(user);
    }

    private void updateUser() {
        System.out.print("\nEnter User ID to update: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        User user = userDAO.getUserById(userId);
        if (user == null) {
            System.out.println("User with ID " + userId + " not found.");
            return;
        }

        System.out.print("Enter new Name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter new Email: ");
        String newEmail = scanner.nextLine();

        user.setName(newName);
        user.setEmail(newEmail);
        userDAO.updateUser(user);
    }

    private void deleteUser() {
        System.out.print("\nEnter User ID to delete: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        userDAO.deleteUser(userId);
    }

    private void borrowBook(int userId) {
        System.out.print("\nEnter Book ID to borrow: ");
        int bookId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        Book book = bookDAO.getBookById(bookId);
        if (book == null) {
            System.out.println("Book with ID " + bookId + " not found.");
            return;
        }

        if (book.getStatus().equals("Available")) {
            book.setStatus("Borrowed");
            bookDAO.updateBook(book);

            // Assuming the issue date is the current date (you can use a proper date format if needed)
            String issueDate = java.time.LocalDate.now().toString();

            // Create a new Transaction object using the specified constructor
            Transaction transaction = new Transaction(0, bookId, userId, issueDate, null);
            transactionDAO.addTransaction(transaction);

            System.out.println("Book with ID " + bookId + " has been borrowed.");
        } else {
            System.out.println("Book with ID " + bookId + " is not available for borrowing.");
        }
    }

    private void returnBook(int userId) {
        System.out.print("\nEnter Book ID to return: ");
        int bookId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        Book book = bookDAO.getBookById(bookId);
        if (book == null) {
            System.out.println("Book with ID " + bookId + " not found.");
            return;
        }

        if (book.getStatus().equals("Borrowed")) {
            book.setStatus("Available");
            bookDAO.updateBook(book);

            Transaction transaction = transactionDAO.getTransaction(userId, bookId);
            if (transaction != null) {
                String returnDate = java.time.LocalDate.now().toString();
                transaction.setReturnDate(returnDate);
                transactionDAO.updateTransaction(transaction);

                // Assuming the fine amount is calculated elsewhere and stored in the variable "fineAmount"
                double fineAmount = calculateFine(transaction);

                // Create a new Bill object using the specified constructor
                Bill bill = new Bill(0, userId, bookId, transaction.getIssueDate(), returnDate, fineAmount);
                billDAO.addBill(bill);

                System.out.println("Book with ID " + bookId + " has been returned.");
            }
        } else {
            System.out.println("Book with ID " + bookId + " is not borrowed by you.");
        }
    }


    private void viewMyTransactions(int userId) {
        List<Transaction> transactions = transactionDAO.getTransactionsByUserId(userId);
        if (transactions.isEmpty()) {
            System.out.println("No transactions found for user with ID " + userId + ".");
        } else {
            System.out.println("\nMY TRANSACTIONS");
            System.out.println("Transaction ID\tBook ID\tIssue Date\tReturn Date");
            for (Transaction transaction : transactions) {
                System.out.println(transaction.getTransactionId() + "\t" + transaction.getBookId() + "\t" +
                                   transaction.getIssueDate() + "\t" + transaction.getReturnDate());
            }
        }
    }

    private void viewAllTransactions() {
        List<Transaction> transactions = transactionDAO.getAllTransactions();
        if (transactions.isEmpty()) {
            System.out.println("No transactions found in the system.");
        } else {
            System.out.println("\nALL TRANSACTIONS");
            System.out.println("Transaction ID\tUser ID\tBook ID\tIssue Date\tReturn Date");
            for (Transaction transaction : transactions) {
                System.out.println(transaction.getTransactionId() + "\t" + transaction.getUserId() + "\t" +
                                   transaction.getBookId() + "\t" + transaction.getIssueDate() + "\t" + transaction.getReturnDate());
            }
        }
    }

    private double calculateFine(Transaction transaction) {
        // Implement your fine calculation logic here (if applicable)
        // For example, calculate fine based on return date and issue date
        return 0.0;
    }

    private void generateBill() {
        System.out.print("\nEnter User ID for generating bill: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        List<Bill> bills = billDAO.getBillsByUserId(userId);
        if (bills.isEmpty()) {
            System.out.println("No bills found for user with ID " + userId + ".");
        } else {
            System.out.println("\nBILL DETAILS");
            System.out.println("Bill ID\tUser ID\tBook ID\tIssue Date\tReturn Date\tFine Amount");
            for (Bill bill : bills) {
                System.out.println(bill.getBillId() + "\t" + bill.getUserId() + "\t" + bill.getBookId() + "\t" +
                                   bill.getIssueDate() + "\t" + bill.getReturnDate() + "\t" + bill.getFineAmount());
            }
        }
    }
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.start();
    }
}
