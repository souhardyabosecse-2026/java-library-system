import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        
        // Add sample books
        library.addBook("B001", "Java Programming", "John Doe");
        library.addBook("B002", "Data Structures", "Jane Smith");
        library.addBook("B003", "Algorithms", "Robert Johnson");
        
        System.out.println("=== LIBRARY MANAGEMENT SYSTEM ===");
        
        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. View Available Books");
            System.out.println("5. Search Books");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter book ID: ");
                    String bookId = scanner.nextLine();
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    library.addBook(bookId, title, author);
                    break;
                    
                case 2:
                    System.out.print("Enter book ID to borrow: ");
                    String borrowId = scanner.nextLine();
                    System.out.print("Enter your member ID: ");
                    String memberId = scanner.nextLine();
                    library.borrowBook(borrowId, memberId);
                    break;
                    
                case 3:
                    System.out.print("Enter book ID to return: ");
                    String returnId = scanner.nextLine();
                    System.out.print("Enter your member ID: ");
                    String returnMemberId = scanner.nextLine();
                    library.returnBook(returnId, returnMemberId);
                    break;
                    
                case 4:
                    library.displayAvailableBooks();
                    break;
                    
                case 5:
                    System.out.print("Enter search keyword: ");
                    String keyword = scanner.nextLine();
                    library.searchBooks(keyword);
                    break;
                    
                case 6:
                    System.out.println("Thank you for using Library System!");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
