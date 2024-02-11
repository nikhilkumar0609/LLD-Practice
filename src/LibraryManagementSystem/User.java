package LibraryManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class User {
	private String userId;
	private String userName;
	private List<BookCopy> borrowedBooks;
	
	public User(String userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.borrowedBooks = new ArrayList<>();
	}
	
	//Method to borrow BookCopy
	public void borrowBookCopy(BookCopy bookCopy) {
		borrowedBooks.add(bookCopy);
		bookCopy.borrowBook();
	}
	
	//Method to return BookCopy
		public void returnBookCopy(BookCopy bookCopy) {
			borrowedBooks.remove(bookCopy);
			bookCopy.returnBook();
		}

	//Getters and Setters
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<BookCopy> getBorrowedBooks() {
		return borrowedBooks;
	}

	public void setBorrowedBooks(List<BookCopy> borrowedBooks) {
		this.borrowedBooks = borrowedBooks;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", borrowedBooks=" + borrowedBooks + "]";
	}
	
	
}
