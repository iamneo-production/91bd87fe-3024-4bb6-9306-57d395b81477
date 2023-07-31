package modal;

public class Bill {
    private int billId;
    private int userId;
    private int bookId;
    private String issueDate;
    private String returnDate;
    private double fineAmount;
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
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
	public double getFineAmount() {
		return fineAmount;
	}
	public void setFineAmount(double fineAmount) {
		this.fineAmount = fineAmount;
	}
	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bill(int billId, int userId, int bookId, String issueDate, String returnDate, double fineAmount) {
		super();
		this.billId = billId;
		this.userId = userId;
		this.bookId = bookId;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
		this.fineAmount = fineAmount;
	}

}