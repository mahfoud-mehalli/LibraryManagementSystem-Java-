package view;

import controller.LibraryController;
import model.Book;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryController library = new LibraryController();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Remove Book");
            System.out.println("4. Find Book");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter year: ");
                    int year = scanner.nextInt();
                    library.addBook(new Book(title, author, year));
                    System.out.println("Book added successfully!");
                    break;
                case 2:
                    System.out.println("Books in library:");
                    library.getBooks().forEach(System.out::println);
                    break;
                case 3:
                    System.out.print("Enter title to remove: ");
                    String removeTitle = scanner.nextLine();
                    library.removeBook(removeTitle);
                    System.out.println("Book removed (if it existed).");
                    break;
                case 4:
                    System.out.print("Enter title to find: ");
                    String findTitle = scanner.nextLine();
                    Book foundBook = library.findBook(findTitle);
                    System.out.println(foundBook != null ? foundBook : "Book not found.");
                    break;
                case 5:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}
