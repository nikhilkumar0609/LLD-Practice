package LibraryManagementSystem;

public class BookCopy {
	private String bookCopyId;
	private Book book;
	private int rackNumber;
	private boolean isBorrowed;
	
	public BookCopy(String bookCopyId, Book book, int rackNumber) {
		this.bookCopyId = bookCopyId;
		this.book = book;
		this.rackNumber = rackNumber;
		this.isBorrowed = false;
	}

	//Getters and Setters
	public String getBookCopyId() {
		return bookCopyId;
	}

	public void setBookCopyId(String bookCopyId) {
		this.bookCopyId = bookCopyId;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getRackNumber() {
		return rackNumber;
	}

	public void setRackNumber(int rackNumber) {
		this.rackNumber = rackNumber;
	}

	public boolean isBorrowed() {
		return isBorrowed;
	}

	public void setBorrowed(boolean isBorrowed) {
		this.isBorrowed = isBorrowed;
	}

	// Method to borrow the book copy
    public void borrowBook() {
        isBorrowed = true;
    }

    // Method to return the book copy
    public void returnBook() {
        isBorrowed = false;
    }

	@Override
	public String toString() {
		return "BookCopy [bookCopyId=" + bookCopyId + ", book=" + book + ", rackNumber=" + rackNumber + ", isBorrowed="
				+ isBorrowed + "]";
	}
	
    
	
}
