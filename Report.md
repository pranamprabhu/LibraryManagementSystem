# Project Report: Library Management System

## 1. Introduction
The objective of this project is to create a console-based Library Management System applying core Object-Oriented Programming (OOP) concepts. The system handles the basic operations of a library, simulating a realistic business application.

## 2. System Architecture
The system is divided into four main components:
- `Book`: Represents the entity of a book with attributes like ID, title, author, and availability status.
- `Member`: Represents a library member, keeping track of their ID, name, and the list of books they have borrowed.
- `Library`: Acts as the central manager for the system. It maintains collections of all books and members and handles the business logic for issuing and returning books, as well as calculating overdue fines.
- `Main`: Serves as the entry point and the user interface, providing a menu-driven console for interacting with the `Library`.

## 3. Key Concepts Applied
- **Encapsulation:** Data fields in `Book` and `Member` are made private, and access is provided through public getter and setter methods.
- **Data Structures:** Java Collections are utilized extensively. `HashMap` is used in the `Library` class for efficient O(1) retrieval of books and members using their IDs. `ArrayList` is used in the `Member` class to dynamically manage the list of borrowed books.
- **Date Handling:** The `java.time.LocalDate` class is used to manage dates, ensuring accurate calculation of due dates and overdue fines.

## 4. Features Implemented
- **Add Book/Member:** Register new entities into the system's hashmaps.
- **Issue Book:** Checks availability and assigns a due date (14 days from issue). Updates the status of the book and the member's record.
- **Return Book:** Calculates fines if the book is returned past the due date. Reverts the status of the book to available.
- **Display Functions:** Prints all registered books and members along with their current status.

## 5. Conclusion
This project successfully demonstrates the application of Java OOP principles and Collections to model a real-world scenario. The resulting application is modular and extensible, allowing for future enhancements such as persistent storage (databases) or a graphical user interface (GUI).
