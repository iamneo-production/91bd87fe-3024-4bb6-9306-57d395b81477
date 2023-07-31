package modal;

public class Librarian {
    private int librarianId;
    private String name;
    private String email;
    private String password;
	public int getLibrarianId() {
		return librarianId;
	}
	public void setLibrarianId(int librarianId) {
		this.librarianId = librarianId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Librarian() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Librarian(int librarianId, String name, String email, String password) {
		super();
		this.librarianId = librarianId;
		this.name = name;
		this.email = email;
		this.password = password;
	}
}
