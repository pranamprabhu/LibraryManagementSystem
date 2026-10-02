import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<String, Book> books;
    private Map<String, Member> members;
    private static final int DAYS_ALLOWED = 14;
    private static final double FINE_PER_DAY = 1.5;

    public Library() {
        this.books = new HashMap<>();
        this.members = new HashMap<>();
    }

    public void addBook(Book book) {
        books.put(book.getId(), book);
        System.out.println("Book added successfully.");
    }

    public void addMember(Member member) {
        members.put(member.getMemberId(), member);
        System.out.println("Member added successfully.");
    }

    public void issueBook(String bookId, String memberId) {
        Book book = books.get(bookId);
        Member member = members.get(memberId);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }
        if (member == null) {
            System.out.println("Member not found.");
            return;
        }
        if (book.isIssued()) {
            System.out.println("Book is already issued.");
            return;
        }

        book.setIssued(true);
        book.setDueDate(LocalDate.now().plusDays(DAYS_ALLOWED));
        member.borrowBook(book);
        System.out.println("Book issued successfully to " + member.getName() + ". Due date: " + book.getDueDate());
    }

    public void returnBook(String bookId, String memberId) {
        Book book = books.get(bookId);
        Member member = members.get(memberId);

        if (book == null || member == null) {
            System.out.println("Invalid Book ID or Member ID.");
            return;
        }
        if (!book.isIssued() || !member.getBorrowedBooks().contains(book)) {
            System.out.println("Book is not issued to this member.");
            return;
        }

        LocalDate now = LocalDate.now();
        if (now.isAfter(book.getDueDate())) {
            long daysOverdue = ChronoUnit.DAYS.between(book.getDueDate(), now);
            double fine = daysOverdue * FINE_PER_DAY;
            System.out.println("Book returned late. Overdue by " + daysOverdue + " days. Fine: $" + fine);
        } else {
            System.out.println("Book returned on time.");
        }

        book.setIssued(false);
        book.setDueDate(null);
        member.returnBook(book);
        System.out.println("Book returned successfully.");
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in library.");
            return;
        }
        for (Book book : books.values()) {
            System.out.println(book);
        }
    }

    public void displayMembers() {
        if (members.isEmpty()) {
            System.out.println("No members in library.");
            return;
        }
        for (Member member : members.values()) {
            System.out.println(member);
        }
    }
}
