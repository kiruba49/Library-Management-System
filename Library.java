import java.util.*;

public class Library {
    private List<Book> books = new ArrayList<>();
    private Map<String, User> users = new HashMap<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added!");
    }

    public void showBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void issueBook(String username, int bookId) {
        User user = users.getOrDefault(username, new User(username));
        for (Book book : books) {
            if (book.getId() == bookId && !book.isIssued()) {
                book.issue();
                user.issueBook(bookId);
                users.put(username, user);
                System.out.println("Book issued to " + username);
                return;
            }
        }
        System.out.println("Book not available.");
    }

    public void returnBook(String username) {
        User user = users.get(username);
        if (user == null || user.getIssuedBookId() == -1) {
            System.out.println("No book to return.");
            return;
        }

        for (Book book : books) {
            if (book.getId() == user.getIssuedBookId()) {
                book.returnBook();
                user.returnBook();
                System.out.println("Book returned!");
                return;
            }
        }
    }
}
