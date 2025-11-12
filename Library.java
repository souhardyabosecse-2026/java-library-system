import java.util.*;

public class Library {
    private Map<String, Book> books;
    private Map<String, List<Book>> borrowedBooks;
    
    public Library() {
        this.books = new HashMap<>();
        this.borrowedBooks = new HashMap<>();
    }
    
    public void addBook(String bookId, String title, String author) {
        if (!books.containsKey(bookId)) {
            Book newBook = new Book(bookId, title, author);
            books.put(bookId, newBook);
            System.out.println("Book added: " + title);
        } else {
            System.out.println("Book ID already exists!");
        }
    }
    
    public void borrowBook(String bookId, String memberId) {
        Book book = books.get(bookId);
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            borrowedBooks.computeIfAbsent(memberId, k -> new ArrayList<>()).add(book);
            System.out.println("Book borrowed: " + book.getTitle());
        } else {
            System.out.println("Book not available or not found!");
        }
    }
    
    public void returnBook(String bookId, String memberId) {
        Book book = books.get(bookId);
        List<Book> memberBooks = borrowedBooks.get(memberId);
        
        if (book != null && memberBooks != null && memberBooks.contains(book)) {
            book.setAvailable(true);
            memberBooks.remove(book);
            System.out.println("Book returned: " + book.getTitle());
        } else {
            System.out.println("Return failed: Book not found or not borrowed by this member!");
        }
    }
    
    public void displayAvailableBooks() {
        System.out.println("\n=== AVAILABLE BOOKS ===");
        books.values().stream()
            .filter(Book::isAvailable)
            .forEach(System.out::println);
    }
    
    public void searchBooks(String keyword) {
        System.out.println("\n=== SEARCH RESULTS ===");
        books.values().stream()
            .filter(book -> book.getTitle().toLowerCase().contains(keyword.toLowerCase()) || 
                           book.getAuthor().toLowerCase().contains(keyword.toLowerCase()))
            .forEach(System.out::println);
    }
}
