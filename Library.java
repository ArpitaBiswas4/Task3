import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

// Library class - Manages books and users
class Library {
    private ArrayList<Book> books;
    private ArrayList<User> users;
    private String libraryName;

    public Library(String libraryName) {
        this.libraryName = libraryName;
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    // Book Management Methods
    public void addBook(Book book) {
        books.add(book);
    }

    public Book findBookById(String bookId) {
        for (Book book : books) {
            if (book.getBookId().equalsIgnoreCase(bookId)) {
                return book;
            }
        }
        return null;
    }

    public ArrayList<Book> searchBooksByTitle(String title) {
        ArrayList<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                results.add(book);
            }
        }
        return results;
    }

    public ArrayList<Book> searchBooksByAuthor(String author) {
        ArrayList<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                results.add(book);
            }
        }
        return results;
    }

    public ArrayList<Book> getAvailableBooks() {
        ArrayList<Book> available = new ArrayList<>();
        for (Book book : books) {
            if (!book.isIssued()) {
                available.add(book);
            }
        }
        return available;
    }

    public ArrayList<Book> getAllBooks() {
        return books;
    }

    // User Management Methods
    public void addUser(User user) {
        users.add(user);
    }

    public User findUserById(String userId) {
        for (User user : users) {
            if (user.getUserId().equalsIgnoreCase(userId)) {
                return user;
            }
        }
        return null;
    }

    public ArrayList<User> getAllUsers() {
        return users;
    }

    // Issue and Return Methods
    public boolean issueBook(String bookId, String userId) {
        Book book = findBookById(bookId);
        User user = findUserById(userId);

        if (book == null) {
            System.out.println("Book not found!");
            return false;
        }

        if (user == null) {
            System.out.println("User not found!");
            return false;
        }

        if (book.isIssued()) {
            System.out.println("Book is already issued to another user!");
            return false;
        }

        if (!user.canBorrowBook()) {
            System.out.println("User has reached maximum book limit (3 books)!");
            return false;
        }

        book.issueBook(userId);
        user.addIssuedBook(bookId);
        System.out.println("Book issued successfully!");
        System.out.println("Due Date: " + book.getDueDate().format(DateTimeFormatter.ofPattern("dd-MMM-yyyy")));
        return true;
    }

    public boolean returnBook(String bookId) {
        Book book = findBookById(bookId);

        if (book == null) {
            System.out.println("Book not found!");
            return false;
        }

        if (!book.isIssued()) {
            System.out.println("Book is not currently issued!");
            return false;
        }

        String userId = book.getIssuedTo();
        User user = findUserById(userId);

        // Check for overdue
        if (LocalDate.now().isAfter(book.getDueDate())) {
            long daysOverdue = LocalDate.now().toEpochDay() - book.getDueDate().toEpochDay();
            System.out.println("Book is overdue by " + daysOverdue + " days!");
            System.out.println("Fine: ₹" + (daysOverdue * 10)); // ₹10 per day
        }

        book.returnBook();
        if (user != null) {
            user.removeIssuedBook(bookId);
        }
        System.out.println("Book returned successfully!");
        return true;
    }

    public String getLibraryName() {
        return libraryName;
    }
}