# Library Management System

A comprehensive CLI-based Library Management System built with Java, demonstrating Object-Oriented Programming principles including encapsulation, inheritance, and abstraction.


## Features

### Book Management
- Add new books to the library
- View all books with status (Available/Issued)
- View only available books
- Search books by ID, title, or author
- Track book issue and return dates

### User Management
- Register new library users
- View all users and their details
- Update user information
- Track number of books issued per user
- Enforce maximum book limit (3 books per user)

### Issue & Return System
- Issue books to registered users
- Return books with overdue checking
- Automatic fine calculation (₹10 per day)
- 14-day borrowing period
- Due date tracking
- View all currently issued books


## Installation & Setup

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- VS Code / IntelliJ IDEA / Terminal

### Compilation & Execution

**Using Terminal/Command Line:**

```bash
# Compile all classes
javac LibraryManagementSystem.java

# Run the program
java LibraryManagementSystem
```

**Using VS Code:**
1. Install Java Extension Pack
2. Open the project folder
3. Right-click on `LibraryManagementSystem.java`
4. Select "Run Java"

**Using IntelliJ IDEA:**
1. Create new Java project
2. Add all `.java` files to src folder
3. Right-click and select "Run 'LibraryManagementSystem.main()'"

## How to Use

### Main Menu Structure

```
MAIN MENU
1. Book Management
2. User Management
3. Issue Book
4. Return Book
5. View Issued Books
0. Exit
```

### 1. Book Management

#### Add New Book
- Select option `1` → `1`
- Enter Book ID (unique identifier)
- Enter book title, author, and category
- Book is added to the library

#### View All Books
- Shows all books with their current status
- Displays: ID, Title, Author, Category, Status (Available/Issued)

#### View Available Books
- Shows only books that are not currently issued
- Helps users find books they can borrow

#### Search Options
- **By ID**: Direct lookup for specific book
- **By Title**: Find books containing search term
- **By Author**: Find all books by an author

### 2. User Management

#### Add New User
- Select option `2` → `1`
- Enter User ID (unique identifier)
- Enter name, email, and phone number
- User is registered in the system

#### View All Users
- Displays all registered users
- Shows books issued count (e.g., 2/3)

#### View User Details
- Shows complete user information
- Lists all book IDs currently borrowed

#### Update User Information
- Modify user's name, email, or phone
- Press Enter to skip fields you don't want to change

### 3. Issue Book

Process:
1. Select option `3` from main menu
2. Enter Book ID
3. Enter User ID
4. System validates:
   - Book exists and is available
   - User exists and hasn't reached limit (3 books)
5. If valid, book is issued with due date (14 days)

**Validations:**
- Book not found
- Book already issued
- User not found
- User reached book limit

### 4. Return Book

Process:
1. Select option `4` from main menu
2. Enter Book ID
3. System checks if book is overdue
4. If overdue, displays fine (₹10 per day)
5. Book is returned and removed from user's list

### 5. View Issued Books

- Shows all books currently issued
- Displays complete details including:
  - Book information
  - Who borrowed it
  - Issue date and due date

