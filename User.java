public class User {
    private String name;
    private int issuedBookId = -1;

    public User(String name) {
        this.name = name;
    }

    public String getName() { return name; }
    public int getIssuedBookId() { return issuedBookId; }

    public void issueBook(int bookId) { this.issuedBookId = bookId; }
    public void returnBook() { this.issuedBookId = -1; }
}
