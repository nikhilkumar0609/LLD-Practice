package LibraryManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class LibraryManagement {
	private List<BookCopy> bookCopies;
    private List<User> users;
    private int rackCount;
    
    public LibraryManagement() {
    	this.bookCopies = new ArrayList<>();
    	this.users = new ArrayList<>();
    	this.rackCount = 0;
    }
    
    //create user
    public void createUser(String userId, String userName) {
    	User user = new User(userId, userName);
    	users.add(user);
    }
    
    //add BookCopy to Library
    public void addBookCopy(BookCopy bookCopy) {
    	bookCopies.add(bookCopy);
    }
    
    //remove BookCopy from Library
    public void removeBookCopy(BookCopy bookCopy) {
    	bookCopies.remove(bookCopy);
    }
    
    //user to borrow a book copy
    public void borrowBookCopy(String userId, String bookId) {
    	User user = findUserById(userId);
    	if(user != null) {
    		BookCopy bookCopy = findBookCopyBorrowByBookId(bookId);
    		if(bookCopy != null) {
    			user.borrowBookCopy(bookCopy);
    			System.out.println("Book Copy Borrowed.");
    		}else {
    			System.out.println("Book copy not found or not borrowed.");
    		}
    	}
    }
    
  //user to return a book copy
    public void returnBookCopy(String userId, String bookId) {
    	User user = findUserById(userId);
    	if(user != null) {
    		BookCopy bookCopy = findBookCopyReturnByBookId(bookId);
    		if(bookCopy != null) {
    			user.returnBookCopy(bookCopy);
    			System.out.println("Book Copy Returned.");
    		}else {
    			System.out.println("Book copy not found.");
    		}
    	}
    }
    
    //print the book copy ids of all the books borrowed
    public void printBookCopyId(String userId) {
    	User user = findUserById(userId);
    	List<BookCopy> bookCopyList = user.getBorrowedBooks();
    	for(BookCopy bookCopy : bookCopyList) {
    		System.out.println("Books borrowed by " + userId + " is " + bookCopy.getBookCopyId() + " and Title is " + bookCopy.getBook().getTitle());
    	}
    }
    
    // Method to search for books by various properties
    public List<BookCopy> searchBooks(String query) {
        List<BookCopy> result = new ArrayList<>();
        for (BookCopy bookCopy : bookCopies) {
            Book book = bookCopy.getBook();
            if (String.valueOf(book.getBookId()).equals(query) ||
                    book.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                    book.getAuthor().toLowerCase().contains(query.toLowerCase()))  {
                result.add(bookCopy);
            }
        }
        return result;
    }
    
    //Helper function
    private User findUserById(String userId) {
    	return users.stream()
                .filter(user -> user.getUserId().equals(userId))
                .findFirst()
                .orElse(null);
	}
    
    private BookCopy findBookCopyBorrowByBookId(String bookId) {
    	return bookCopies.stream().filter(bookCopy -> bookCopy.getBook().getBookId().equals(bookId)  && !bookCopy.isBorrowed())
    			.findFirst()
    			.orElse(null);
    }

    private BookCopy findBookCopyReturnByBookId(String bookId) {
    	return bookCopies.stream().filter(bookCopy -> bookCopy.getBook().getBookId().equals(bookId)  && bookCopy.isBorrowed())
    			.findFirst()
    			.orElse(null);
    }
    
	//Getters and Setters
	public List<BookCopy> getBookCopies() {
		return bookCopies;
	}

	public void setBookCopies(List<BookCopy> bookCopies) {
		this.bookCopies = bookCopies;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public int getRackCount() {
		return rackCount;
	}

	public void setRackCount(int rackCount) {
		this.rackCount = rackCount;
	}
    
}
