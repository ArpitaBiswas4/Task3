import java.util.ArrayList;
import java.util.Scanner;

// Main class
public class LibraryManagementSystem {
    private static Library library;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        library = new Library("Kolkata Library");
        initializeData(); // Add some sample data

        System.out.println("     " + library.getLibraryName().toUpperCase() + "     ");
        System.out.println("        LIBRARY MANAGEMENT SYSTEM              ");

        int choice = 0;
        do {
            displayMainMenu();
            choice = getIntInput("\nEnter your choice: ");

            switch (choice) {
                case 1:
                    bookManagementMenu();
                    break;
                case 2:
                    userManagementMenu();
                    break;
                case 3:
                    issueBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    viewIssuedBooks();
                    break;
                case 0:
                    System.out.println("\nThank you for using " + library.getLibraryName() + "!");
                    break;
                default:
                    System.out.println("\nInvalid choice! Please try again.");
            }
            System.out.println("\n" + "=".repeat(60));
        } while (choice != 0);

        scanner.close();
    }

    private static void displayMainMenu() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println(" ".repeat(24)+"Main Menu");
        System.out.println("=".repeat(60));
        System.out.println("Press 1 for Book Management");
        System.out.println("Press 2 for. User Management");
        System.out.println("Press 3 for Issue Book");
        System.out.println("Press 4 for Return Book");
        System.out.println("Press 5 for View Issued Books");
        System.out.println("Press 0 for Exit");
    }

    // Book Management Menu
    private static void bookManagementMenu() {
        int choice = 0;
        do {
            System.out.println("\n--- BOOK MANAGEMENT ---");
            System.out.println("Press 1 for Add New Book");
            System.out.println("Press 2 for View All Books");
            System.out.println("Press 3 for View Available Books");
            System.out.println("Press 4 for Search Book by ID");
            System.out.println("Press 5 for Search Books by Title");
            System.out.println("Press 6 for Search Books by Author");
            System.out.println("Press 0 for Back to Main Menu");

            choice = getIntInput("\nEnter choice: ");

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    viewAllBooks();
                    break;
                case 3:
                    viewAvailableBooks();
                    break;
                case 4:
                    searchBookById();
                    break;
                case 5:
                    searchBooksByTitle();
                    break;
                case 6:
                    searchBooksByAuthor();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("✗ Invalid choice!");
            }
        } while (choice != 0);
    }

    // User Management Menu
    private static void userManagementMenu() {
        int choice = 0;
        do {
            System.out.println("\n--- USER MANAGEMENT ---");
            System.out.println("Press 1 for Add New User");
            System.out.println("Press 2 for View All Users");
            System.out.println("Press 3 for View User Details");
            System.out.println("Press 4 for Update User Information");
            System.out.println("Press 0 for Back to Main Menu");

            choice = getIntInput("\nEnter choice: ");

            switch (choice) {
                case 1:
                    addUser();
                    break;
                case 2:
                    viewAllUsers();
                    break;
                case 3:
                    viewUserDetails();
                    break;
                case 4:
                    updateUser();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("✗ Invalid choice!");
            }
        } while (choice != 0);
    }

    // Book Management Methods
    private static void addBook() {
        System.out.println("\n--- ADD NEW BOOK ---");
        String bookId = getStringInput("Enter Book ID: ");

        if (library.findBookById(bookId) != null) {
            System.out.println("Book with this ID already exists!");
            return;
        }

        String title = getStringInput("Enter Title: ");
        String author = getStringInput("Enter Author: ");
        String category = getStringInput("Enter Category: ");

        Book book = new Book(bookId, title, author, category);
        library.addBook(book);
        System.out.println("Book added successfully!");
    }

    private static void viewAllBooks() {
        System.out.println("\n--- ALL BOOKS ---");
        ArrayList<Book> books = library.getAllBooks();

        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }

        for (Book book : books) {
            System.out.println(book);
        }
        System.out.println("\nTotal Books: " + books.size());
    }

    private static void viewAvailableBooks() {
        System.out.println("\n--- AVAILABLE BOOKS ---");
        ArrayList<Book> books = library.getAvailableBooks();

        if (books.isEmpty()) {
            System.out.println("No books available at the moment.");
            return;
        }

        for (Book book : books) {
            System.out.println(book);
        }
        System.out.println("\nAvailable Books: " + books.size());
    }

    private static void searchBookById() {
        String bookId = getStringInput("\nEnter Book ID: ");
        Book book = library.findBookById(bookId);

        if (book != null) {
            System.out.println(book.getDetailedInfo());
        } else {
            System.out.println("✗ Book not found!");
        }
    }

    private static void searchBooksByTitle() {
        String title = getStringInput("\nEnter title to search: ");
        ArrayList<Book> results = library.searchBooksByTitle(title);

        if (results.isEmpty()) {
            System.out.println("✗ No books found!");
        } else {
            System.out.println("\n--- SEARCH RESULTS ---");
            for (Book book : results) {
                System.out.println(book);
            }
            System.out.println("\nResults: " + results.size());
        }
    }

    private static void searchBooksByAuthor() {
        String author = getStringInput("\nEnter author to search: ");
        ArrayList<Book> results = library.searchBooksByAuthor(author);

        if (results.isEmpty()) {
            System.out.println("✗ No books found!");
        } else {
            System.out.println("\n--- SEARCH RESULTS ---");
            for (Book book : results) {
                System.out.println(book);
            }
            System.out.println("\nResults: " + results.size());
        }
    }

    // User Management Methods
    private static void addUser() {
        System.out.println("\n--- ADD NEW USER ---");
        String userId = getStringInput("Enter User ID: ");

        if (library.findUserById(userId) != null) {
            System.out.println("✗ User with this ID already exists!");
            return;
        }

        String name = getStringInput("Enter Name: ");
        String email = getStringInput("Enter Email: ");
        String phone = getStringInput("Enter Phone: ");

        User user = new User(userId, name, email, phone);
        library.addUser(user);
        System.out.println("✓ User added successfully!");
    }

    private static void viewAllUsers() {
        System.out.println("\n--- ALL USERS ---");
        ArrayList<User> users = library.getAllUsers();

        if (users.isEmpty()) {
            System.out.println("No users registered.");
            return;
        }

        for (User user : users) {
            System.out.println(user);
        }
        System.out.println("\nTotal Users: " + users.size());
    }

    private static void viewUserDetails() {
        String userId = getStringInput("\nEnter User ID: ");
        User user = library.findUserById(userId);

        if (user != null) {
            System.out.println(user.getDetailedInfo());
        } else {
            System.out.println("✗ User not found!");
        }
    }

    private static void updateUser() {
        String userId = getStringInput("\nEnter User ID to update: ");
        User user = library.findUserById(userId);

        if (user == null) {
            System.out.println("✗ User not found!");
            return;
        }

        System.out.println("\nCurrent Details: ");
        System.out.println(user.getDetailedInfo());

        String name = getStringInput("Enter new name (press Enter to skip): ");
        if (!name.isEmpty()) user.setName(name);

        String email = getStringInput("Enter new email (press Enter to skip): ");
        if (!email.isEmpty()) user.setEmail(email);

        String phone = getStringInput("Enter new phone (press Enter to skip): ");
        if (!phone.isEmpty()) user.setPhone(phone);

        System.out.println("✓ User updated successfully!");
    }

    // Issue and Return Methods
    private static void issueBook() {
        System.out.println("\n--- ISSUE BOOK ---");
        String bookId = getStringInput("Enter Book ID: ");
        String userId = getStringInput("Enter User ID: ");

        library.issueBook(bookId, userId);
    }

    private static void returnBook() {
        System.out.println("\n--- RETURN BOOK ---");
        String bookId = getStringInput("Enter Book ID: ");

        library.returnBook(bookId);
    }

    private static void viewIssuedBooks() {
        System.out.println("\n--- ISSUED BOOKS ---");
        ArrayList<Book> allBooks = library.getAllBooks();
        boolean found = false;

        for (Book book : allBooks) {
            if (book.isIssued()) {
                System.out.println(book.getDetailedInfo());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books are currently issued.");
        }
    }

    // Initialize sample data
    private static void initializeData() {
        // Add sample books
        library.addBook(new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald", "Fiction"));
        library.addBook(new Book("B002", "To Kill a Mockingbird", "Harper Lee", "Fiction"));
        library.addBook(new Book("B003", "1984", "George Orwell", "Science Fiction"));
        library.addBook(new Book("B004", "Pride and Prejudice", "Jane Austen", "Romance"));
        library.addBook(new Book("B005", "The Catcher in the Rye", "J.D. Salinger", "Fiction"));

        // Add sample users
        library.addUser(new User("U001", "John Doe", "john@example.com", "9876543210"));
        library.addUser(new User("U002", "Jane Smith", "jane@example.com", "9876543211"));
        library.addUser(new User("U003", "Bob Johnson", "bob@example.com", "9876543212"));
    }

    // Helper Methods
    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("✗ Invalid input! Please enter a number.");
            }
        }
    }

    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
}