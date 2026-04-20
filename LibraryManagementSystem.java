import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private int id; // Added ID field
    private String title;
    private String author;
    private boolean isIssued;

    // Updated constructor to accept ID
    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }

    public void issueBook() {
        if (!isIssued) {
            isIssued = true;
            System.out.println("Book issued successfully: " + title);
        } else {
            System.out.println("Book is already issued.");
        }
    }

    public void returnBook() {
        if (isIssued) {
            isIssued = false;
            System.out.println("Book returned successfully: " + title);
        } else {
            System.out.println("Book was not issued.");
        }
    }

    public void displayDetails() {
        System.out.println("ID: " + id + " | Title: " + title + " | Author: " + author + " | Status: " + (isIssued ? "Issued" : "Available"));
    }
}

class Library {
    private static int totalBooks = 0;
    private static ArrayList<Book> books = new ArrayList<>();

    public static void addBook(Book book) {
        books.add(book);
        totalBooks++;
        System.out.println("Book added successfully!");
    }

    // SEARCH FUNCTION: Finds book by ID and displays it
    public static void searchBook(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                book.displayDetails();
                return;
            }
        }
        System.out.println("Book with ID " + id + " not found.");
    }

    // DELETE FUNCTION: Removes book from ArrayList
    public static void deleteBook(int id) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == id) {
                System.out.println("Removing: " + books.get(i).getTitle());
                books.remove(i);
                totalBooks--; // Reduce the total count
                return;
            }
        }
        System.out.println("Could not find book with ID " + id + " to delete.");
    }

    // ISSUE FUNCTION: Updated to use ID
    public static void issueBook(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                book.issueBook();
                return;
            }
        }
        System.out.println("Book ID not found.");
    }

    // RETURN FUNCTION: Updated to use ID
    public static void returnBook(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                book.returnBook();
                return;
            }
        }
        System.out.println("Book ID not found.");
    }

    public static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("Library is empty.");
        } else {
            for (Book book : books) { book.displayDetails(); }
        }
    }

    public static void viewTotalBooks() {
        System.out.println("Total unique books in library: " + totalBooks);
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Initial books with unique IDs
        Library.addBook(new Book(101, "The Alchemist", "Paulo Coelho"));
        Library.addBook(new Book(102, "1984", "George Orwell"));

        int choice;
        do {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book  2. Issue Book  3. Return Book");
            System.out.println("4. View All  5. Total Count 6. Search Book");
            System.out.println("7. Delete Book 0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: "); int id = sc.nextInt();
                    sc.nextLine(); // Clear buffer
                    System.out.print("Enter Title: "); String title = sc.nextLine();
                    System.out.print("Enter Author: "); String author = sc.nextLine();
                    Library.addBook(new Book(id, title, author));
                    break;
                case 2:
                    System.out.print("Enter ID to issue: ");
                    Library.issueBook(sc.nextInt());
                    break;
                case 3:
                    System.out.print("Enter ID to return: ");
                    Library.returnBook(sc.nextInt());
                    break;
                case 4: Library.viewBooks(); break;
                case 5: Library.viewTotalBooks(); break;
                case 6:
                    System.out.print("Enter ID to search: ");
                    Library.searchBook(sc.nextInt());
                    break;
                case 7:
                    System.out.print("Enter ID to delete: ");
                    Library.deleteBook(sc.nextInt());
                    break;
                case 0: System.out.println("Goodbye!"); break;
                default: System.out.println("Invalid choice.");
            }
        } while (choice != 0);
        sc.close();
    }
}