import java.util.Scanner;

public class Library {
    static class Book {
        String title;
        String author;
        String isbn;

        Book(String title, String author, String isbn) {
            this.title = title;
            this.author = author;
            this.isbn = isbn;
        }

        void displayDetails() {
            System.out.println("\n--- Book Details ---");
            System.out.println("Title : " + title);
            System.out.println("Author: " + author);
            System.out.println("ISBN  : " + isbn);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        System.out.print("Enter ISBN: ");
        String isbn = sc.nextLine();

        Library.Book myBook = new Library.Book(title, author, isbn);
        myBook.displayDetails();
    }
}
