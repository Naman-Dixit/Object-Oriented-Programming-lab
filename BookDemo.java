
import java.util.Scanner;

class Book {

    // Instance variables
    private String title;
    private String author;
    private double price;

    // Static variable to track the number of Book objects created
    private static int bookCount = 0;

    // Default constructor
    public Book() {
        this.title = "Unknown";
        this.author = "Unknown";
        this.price = 0.0;
        bookCount++; // Increment the counter
    }

    // Parameterized constructor
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        bookCount++; // Increment the counter
    }

    // Method to return the title
    public String getTitle() {
        return title;
    }

    // Method to return the author
    public String getAuthor() {
        return author;
    }

    // Method to return the price
    public double getPrice() {
        return price;
    }

    // Method to apply discount
    public void applyDiscount(double discountPercentage) {
        if (discountPercentage > 0 && discountPercentage <= 100) {
            price = price - (price * discountPercentage / 100);
        }
    }

    // Static method to return the count of Book objects
    public static int getBookCount() {
        return bookCount;
    }
}

public class BookDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create books array to store multiple books
        System.out.print("How many books do you want to create? ");
        int numBooks = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Book[] books = new Book[numBooks];

        // Get input for each book
        for (int i = 0; i < numBooks; i++) {
            System.out.println("\nEnter details for Book " + (i + 1) + ":");

            System.out.print("Title: ");
            String title = scanner.nextLine();

            System.out.print("Author: ");
            String author = scanner.nextLine();

            System.out.print("Price: $");
            double price = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            // Create new book with user input
            books[i] = new Book(title, author, price);

            // Ask if user wants to apply discount
            System.out.print("Do you want to apply a discount? (yes/no): ");
            String answer = scanner.nextLine().toLowerCase();

            if (answer.equals("yes")) {
                System.out.print("Enter discount percentage: ");
                double discount = scanner.nextDouble();
                scanner.nextLine(); // Consume newline

                books[i].applyDiscount(discount);
                System.out.println("Discount applied. New price: $" + books[i].getPrice());
            }
        }

        // Display all book information
        System.out.println("\n----- Book Information -----");
        for (int i = 0; i < books.length; i++) {
            System.out.println("\nBook " + (i + 1) + " Details:");
            System.out.println("Title: " + books[i].getTitle());
            System.out.println("Author: " + books[i].getAuthor());
            System.out.println("Price: $" + books[i].getPrice());
        }

        // Display the total number of books created
        System.out.println("\nTotal number of books created: " + Book.getBookCount());

        scanner.close();
    }
}
