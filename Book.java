import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// Book class - Represents a book in the library
class Book {
    private String bookId;
    private String title;
    private String author;
    private String category;
    private boolean isIssued;
    private String issuedTo;
    private LocalDate issueDate;
    private LocalDate dueDate;

    public Book(String bookId, String title, String author, String category) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.category = category;
        this.isIssued = false;
        this.issuedTo = null;
        this.issueDate = null;
        this.dueDate = null;
    }

    // Getters
    public String getBookId() { return bookId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getCategory() { return category; }
    public boolean isIssued() { return isIssued; }
    public String getIssuedTo() { return issuedTo; }
    public LocalDate getIssueDate() { return issueDate; }
    public LocalDate getDueDate() { return dueDate; }

    // Issue book to a user
    public void issueBook(String userId) {
        this.isIssued = true;
        this.issuedTo = userId;
        this.issueDate = LocalDate.now();
        this.dueDate = LocalDate.now().plusDays(14); // 14 days borrowing period
    }

    // Return book
    public void returnBook() {
        this.isIssued = false;
        this.issuedTo = null;
        this.issueDate = null;
        this.dueDate = null;
    }

    @Override
    public String toString() {
        String status = isIssued ? "ISSUED" : "AVAILABLE";
        return String.format("ID: %-8s | Title: %-30s | Author: %-20s | Category: %-15s | Status: %s",
                bookId, title, author, category, status);
    }

    public String getDetailedInfo() {
        StringBuilder info = new StringBuilder();
        info.append("\n--- Book Details ---\n");
        info.append("Book ID    : ").append(bookId).append("\n");
        info.append("Title      : ").append(title).append("\n");
        info.append("Author     : ").append(author).append("\n");
        info.append("Category   : ").append(category).append("\n");
        info.append("Status     : ").append(isIssued ? "ISSUED" : "AVAILABLE").append("\n");
        if (isIssued) {
            info.append("Issued To  : ").append(issuedTo).append("\n");
            info.append("Issue Date : ").append(issueDate.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"))).append("\n");
            info.append("Due Date   : ").append(dueDate.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"))).append("\n");
        }
        return info.toString();
    }
}