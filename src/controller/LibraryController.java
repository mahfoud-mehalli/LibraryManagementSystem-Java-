package controller;

import model.Book;
import java.util.ArrayList;
import java.util.List;

public class LibraryController {
    private static LibraryController instance; // Static instance of the Singleton
    private final List<Book> books;

    // Private constructor to prevent instantiation
    private LibraryController() {
        books = new ArrayList<>();
    }

    // Public method to get the single instance
    public static LibraryController getInstance() {
        if (instance == null) { // Lazy initialization
            instance = new LibraryController();
        }
        return instance;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void removeBook(String title) {
        books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
    }

    public Book findBook(String title) {
        return books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }
}
