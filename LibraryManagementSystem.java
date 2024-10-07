import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int bookId;
    String title;
    String author;
    boolean isAvailable;

    // Constructor
    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isAvailable = true; // Book is available when added
    }

    // Display Book Info
    public void displayBook() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Availability: " + (isAvailable ? "Available" : "Issued"));
    }
}

class Library {
    ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    // Add Book
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully!");
    }

    // Remove Book
    public void removeBook(int bookId) {
        for (Book book : books) {
            if (book.bookId == bookId) {
                books.remove(book);
                System.out.println("Book removed successfully!");
                return;
            }
        }
        System.out.println("Book not found!");
    }

    // Search Book by ID
    public void searchBook(int bookId) {
        for (Book book : books) {
            if (book.bookId == bookId) {
                book.displayBook();
                return;
            }
        }
        System.out.println("Book not found!");
    }

    // List all Books
    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            for (Book book : books) {
                book.displayBook();
                System.out.println("-------------------");
            }
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        int choice;

        do {
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book");
            System.out.println("4. List All Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Book Author: ");
                    String author = scanner.nextLine();
                    Book book = new Book(id, title, author);
                    library.addBook(book);
                    break;

                case 2:
                    System.out.print("Enter Book ID to remove: ");
                    int removeId = scanner.nextInt();
                    library.removeBook(removeId);
                    break;

                case 3:
                    System.out.print("Enter Book ID to search: ");
                    int searchId = scanner.nextInt();
                    library.searchBook(searchId);
                    break;

                case 4:
                    library.listBooks();
                    break;

                case 5:
                    System.out.println("Exiting the system.");
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 5);
        scanner.close();
    }
}
