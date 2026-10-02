# Library Management System

This is a console-based Library Management System implemented in Java. It demonstrates Object-Oriented Programming (OOP) concepts such as classes, encapsulation, and the use of Collections.

## Features
- **Book Management:** Add new books to the library.
- **Member Management:** Register new members to the library.
- **Issue and Return:** Allow members to borrow and return books.
- **Overdue Tracking:** Automatically calculate fines for overdue books based on a 14-day borrowing period.

## Technologies Used
- **Java:** Core language used for logic.
- **Collections Framework:** `HashMap` for storing books and members, and `ArrayList` for tracking borrowed books.
- **Java Time API:** `LocalDate` for managing issue and due dates.

## How to Run
1. Ensure you have Java installed on your system.
2. Compile the Java files:
   ```bash
   javac *.java
   ```
3. Run the application:
   ```bash
   java Main
   ```

## Usage
Upon running the application, you will be presented with a menu. Enter the corresponding number to choose an option, such as adding a book, adding a member, issuing a book, etc.
