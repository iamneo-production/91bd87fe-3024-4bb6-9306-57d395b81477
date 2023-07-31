package modal;


public class Transaction {
    private int transactionId;
    private int bookId;
    private int userId;
    private String issueDate;
    private String returnDate;
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transaction(int transactionId, int bookId, int userId, String issueDate, String returnDate) {
		super();
		this.transactionId = transactionId;
		this.bookId = bookId;
		this.userId = userId;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
	}

    // Constructor, getters, setters
}
