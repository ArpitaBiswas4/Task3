import java.util.ArrayList;

// User class - Represents a library user
class User {
    private String userId;
    private String name;
    private String email;
    private String phone;
    private ArrayList<String> issuedBooks;
    private static final int MAX_BOOKS = 3;

    public User(String userId, String name, String email, String phone) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.issuedBooks = new ArrayList<>();
    }

    // Getters
    public String getUserId() { return userId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public ArrayList<String> getIssuedBooks() { return issuedBooks; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }

    // Check if user can borrow more books
    public boolean canBorrowBook() {
        return issuedBooks.size() < MAX_BOOKS;
    }

    // Add book to user's issued list
    public void addIssuedBook(String bookId) {
        issuedBooks.add(bookId);
    }

    // Remove book from user's issued list
    public void removeIssuedBook(String bookId) {
        issuedBooks.remove(bookId);
    }

    @Override
    public String toString() {
        return String.format("ID: %-8s | Name: %-25s | Email: %-30s | Books Issued: %d/%d",
                userId, name, email, issuedBooks.size(), MAX_BOOKS);
    }

    public String getDetailedInfo() {
        StringBuilder info = new StringBuilder();
        info.append("\n--- User Details ---\n");
        info.append("User ID    : ").append(userId).append("\n");
        info.append("Name       : ").append(name).append("\n");
        info.append("Email      : ").append(email).append("\n");
        info.append("Phone      : ").append(phone).append("\n");
        info.append("Books Issued: ").append(issuedBooks.size()).append("/").append(MAX_BOOKS).append("\n");
        if (!issuedBooks.isEmpty()) {
            info.append("Book IDs   : ").append(String.join(", ", issuedBooks)).append("\n");
        }
        return info.toString();
    }
}