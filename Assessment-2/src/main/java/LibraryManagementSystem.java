import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;
    private String author;
    private boolean isAvailable;

    // Constructor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;  // Default: Book is available when created
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    // Display Book Info
    public void displayBookInfo() {
        System.out.println("Title: " + title + ", Author: " + author + ", Available: " + isAvailable);
    }
}

class Library {
    private List<Book> books;

    // Constructor
    public Library() {
        books = new ArrayList<>();
    }

    // Add a new book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // Issue a book (mark as unavailable)
    public void issueBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title) && book.isAvailable()) {
                book.setAvailable(false);
                System.out.println("Book '" + title + "' has been issued.");
                return;
            }
        }
        System.out.println("Sorry, the book '" + title + "' is not available.");
    }

    // Return a book (mark as available)
    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title) && !book.isAvailable()) {
                book.setAvailable(true);
                System.out.println("Book '" + title + "' has been returned.");
                return;
            }
        }
        System.out.println("Book '" + title + "' was not issued or does not exist.");
    }

    // Display all books in the library
    public void displayBooks() {
        for (Book book : books) {
            book.displayBookInfo();
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        // Create Library
        Library library = new Library();

        // Create and add books to library
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald");
        Book book2 = new Book("1984", "George Orwell");
        Book book3 = new Book("To Kill a Mockingbird", "Harper Lee");
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Display all books
        System.out.println("Books in Library:");
        library.displayBooks();

        // Issue and return books
        library.issueBook("1984");
        library.issueBook("The Great Gatsby");
        library.returnBook("1984");

        // Display books after some transactions
        System.out.println("\nBooks in Library after transactions:");
        library.displayBooks();
    }
}
/*3: Organizing a Library Management System
Approach:
Library Management System involves maintaining details about books and users.

Classes and Objects represent books, library members, and their transactions.

We will use encapsulation to keep the attributes of the classes protected and create methods to manage the data (add books, issue books, etc.).
Explanation:
Book Class:

Stores details of a book (title, author, availability).

Methods for displaying information and updating availability (issuing or returning).

Library Class:

Maintains a list of books.

Methods to add, issue, return books, and display available books.

Main Program:

Creates a library, adds books, and performs operations like issuing and returning books.
*/