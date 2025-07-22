import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Admin admin = new Admin();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- LIBRARY MENU ---");
            System.out.println("1. Admin Login");
            System.out.println("2. View Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Admin Username: ");
                    String user = sc.nextLine();
                    System.out.print("Password: ");
                    String pass = sc.nextLine();
                    if (admin.login(user, pass)) {
                        System.out.print("Enter book ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Title: ");
                        String title = sc.nextLine();
                        System.out.print("Author: ");
                        String author = sc.nextLine();
                        Book book = new Book(id, title, author);
                        library.addBook(book);
                    } else {
                        System.out.println("Invalid login.");
                    }
                    break;
                case 2:
                    library.showBooks();
                    break;
                case 3:
                    System.out.print("Enter your name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Book ID to issue: ");
                    int bid = sc.nextInt();
                    library.issueBook(name, bid);
                    break;
                case 4:
                    System.out.print("Enter your name: ");
                    String uname = sc.nextLine();
                    library.returnBook(uname);
                    break;
                case 5:
                    System.out.println("Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
