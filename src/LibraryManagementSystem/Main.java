package LibraryManagementSystem;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		LibraryManagement library = new LibraryManagement();
		library.createUser("1", "Nikhil");
		library.createUser("2", "Rupam");
		library.createUser("3", "Puchhku");
		library.createUser("4", "Dhakkan");
		
		Book book1 = new Book("1", "Java", "Durgesh");
		Book book2 = new Book("2", "Cpp", "Babbar");
		Book book3 = new Book("3", "Dsa", "Striver");
		
		BookCopy bookCopy1 = new BookCopy("1", book1, 1);
		BookCopy bookCopy2 = new BookCopy("2", book3, 2);
		BookCopy bookCopy3 = new BookCopy("3", book2, 3);
		BookCopy bookCopy4 = new BookCopy("4", book3, 4);
		BookCopy bookCopy5 = new BookCopy("5", book2, 5);
		BookCopy bookCopy6 = new BookCopy("6", book3, 6);
		BookCopy bookCopy7 = new BookCopy("7", book1, 7);
		BookCopy bookCopy8 = new BookCopy("8", book2, 8);
		BookCopy bookCopy9 = new BookCopy("9", book1, 9);
		
		library.addBookCopy(bookCopy1);
		library.addBookCopy(bookCopy2);
		library.addBookCopy(bookCopy3);
		library.addBookCopy(bookCopy4);
		library.addBookCopy(bookCopy5);
		library.addBookCopy(bookCopy6);
		library.addBookCopy(bookCopy7);
		library.addBookCopy(bookCopy8);
		library.addBookCopy(bookCopy9);
		
		library.borrowBookCopy("1", "2");
		library.borrowBookCopy("2", "2");
		library.borrowBookCopy("3", "2");
		library.borrowBookCopy("4", "1");
		library.borrowBookCopy("1", "3");
		library.borrowBookCopy("2", "1");
		library.borrowBookCopy("3", "3");
		
		library.printBookCopyId("2");
		
		List<BookCopy> searchList = library.searchBooks("Dsa");
		for(BookCopy bookCopy : searchList) {
			System.out.println("BookCopy is " + bookCopy.getBook());
		}
	}

}
