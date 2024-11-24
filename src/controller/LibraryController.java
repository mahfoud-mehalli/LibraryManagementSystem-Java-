package controller;

import model.Book;
import java.util.ArrayList;
import java.util.List;

public class LibraryController {
    private static LibraryController instance;
    private final List<Book> books;

    private LibraryController() {
        books = new ArrayList<>();
    }

    public static LibraryController getInstance() {
        if (instance == null) {
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
