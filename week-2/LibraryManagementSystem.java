import java.util.ArrayList;
import java.util.Scanner;

// ==========================================
// 1. MAIN DRIVER CLASS (Must be at the top)
// ==========================================
public class User {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();
        
        // Default data
        lib.addBook(new Book(101, "Java Programming", "James Gosling"));
        lib.addBook(new Book(102, "DBMS", "C.J. Date"));
        lib.addUser(new LibraryUser(1, "Anaya"));
        
        int choice;
        do {
            System.out.println("\n====== LIBRARY MANAGEMENT SYSTEM ======");
            System.out.println("1. Add Book   2. Add User   3. Show Books   4. Show Users");
            System.out.println("5. Borrow Book   6. Return Book   7. User's Books 0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            
            switch(choice) {
                case 1:
                    System.out.print("Book ID: "); int bId = sc.nextInt(); sc.nextLine();
                    System.out.print("Title: "); String title = sc.nextLine();
                    System.out.print("Author: "); String author = sc.nextLine();
                    lib.addBook(new Book(bId, title, author));
                    break;
                case 2:
                    System.out.print("User ID: "); int uId = sc.nextInt(); sc.nextLine();
                    System.out.print("Name: "); String name = sc.nextLine();
                    lib.addUser(new LibraryUser(uId, name));
                    break;
                case 3: lib.showAllBooks(); break;
                case 4: lib.showAllUsers(); break;
                case 5:
                    System.out.print("User ID: "); int uid1 = sc.nextInt();
                    System.out.print("Book ID: "); int bid1 = sc.nextInt();
                    lib.borrowBook(bid1, uid1); break;
                case 6:
                    System.out.print("User ID: "); int uid2 = sc.nextInt();
                    System.out.print("Book ID: "); int bid2 = sc.nextInt();
                    lib.returnBook(bid2, uid2); break;
                case 7:
                    System.out.print("User ID: "); int uid3 = sc.nextInt();
                    LibraryUser u = lib.findUser(uid3);
                    if(u != null) u.showBorrowedBooks();
                    else System.out.println("User not found.");
                    break;
                case 0: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice!");
            }
        } while(choice != 0);
        sc.close();
    }
}

// ==========================================
// 2. OTHER CLASSES (Supporting OOP Logic)
// ==========================================

// Abstraction
abstract class Person {
    protected String name;
    Person(String name) { this.name = name; }
    abstract void displayRole();
}

// Inheritance
class LibraryUser extends Person {
    private int userId;
    private ArrayList<Book> borrowedBooks;
    
    LibraryUser(int userId, String name) {
        super(name);
        this.userId = userId;
        this.borrowedBooks = new ArrayList<>();
    }
    
    @Override
    void displayRole() { System.out.println("Role: Library User"); }
    
    public int getUserId() { return userId; }
    public String getName() { return name; }
    
    public void borrowBook(Book book) { borrowedBooks.add(book); }
    public void returnBook(Book book) { borrowedBooks.remove(book); }
    
    public boolean hasBook(Book book) { return borrowedBooks.contains(book); }
    
    public void showBorrowedBooks() {
        if(borrowedBooks.isEmpty()) {
            System.out.println(name + " has no borrowed books.");
        } else {
            System.out.println(name + "'s Borrowed Books:");
            for(Book b : borrowedBooks) {
                System.out.println(" - " + b.getTitle());
            }
        }
    }
}

// Encapsulation
class Book {
    private int bookId;
    private String title;
    private String author;
    private boolean isAvailable;
    
    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }
    
    public int getBookId() { return bookId; }
    public String getTitle() { return title; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }
    
    public void displayBook() {
        String status = isAvailable ? "Available" : "Borrowed";
        System.out.println(bookId + " | " + title + " | " + author + " | " + status);
    }
}

class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<LibraryUser> users = new ArrayList<>();
    
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }
    
    public void addUser(LibraryUser user) {
        users.add(user);
        System.out.println("User added: " + user.getName());
    }
    
    public void borrowBook(int bookId, int userId) {
        Book book = findBook(bookId);
        LibraryUser user = findUser(userId);
        if(book == null || user == null) { System.out.println("Invalid ID."); return; }
        
        if(book.isAvailable()) {
            book.setAvailable(false);
            user.borrowBook(book);
            System.out.println(user.getName() + " borrowed " + book.getTitle());
        } else {
            System.out.println("Book is already borrowed.");
        }
    }
    
    public void returnBook(int bookId, int userId) {
        Book book = findBook(bookId);
        LibraryUser user = findUser(userId);
        if(book == null || user == null) { System.out.println("Invalid ID."); return; }
        
        if(user.hasBook(book)) {
            book.setAvailable(true);
            user.returnBook(book);
            System.out.println(user.getName() + " returned " + book.getTitle());
        } else {
            System.out.println(user.getName() + " did not borrow this book.");
        }
    }
    
    public void showAllBooks() {
        System.out.println("\n--- Library Books ---");
        System.out.println("ID | Title | Author | Status");
        for (Book book : books) book.displayBook();
    }
    
    public void showAllUsers() {
        System.out.println("\n--- Library Users ---");
        for (LibraryUser user : users) {
            System.out.println(user.getUserId() + " | " + user.getName());
        }
    }
    
    public LibraryUser findUser(int userId) {
        for(LibraryUser u : users) if(u.getUserId() == userId) return u;
        return null;
    }
    
    private Book findBook(int bookId) {
        for(Book b : books) if(b.getBookId() == bookId) return b;
        return null;
    }
}
