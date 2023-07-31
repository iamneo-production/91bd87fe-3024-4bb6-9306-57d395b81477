package modal;

public class Book {
    private int bookId;
    private String title;
    private String author;
    private String status;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(int bookId, String title, String author, String status) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.status = status;
	}

    // Constructor, getters, setters
}