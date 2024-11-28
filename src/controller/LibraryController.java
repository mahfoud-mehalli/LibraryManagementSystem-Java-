package controller;

import model.Book;
import observer.Observer;
import observer.Subject;

import java.util.ArrayList;
import java.util.List;

public class LibraryController implements Subject {
    private static LibraryController instance;
    private final List<Book> books;
    private final List<Observer> observers;

    private LibraryController() {
        books = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static LibraryController getInstance() {
        if (instance == null) {
            instance = new LibraryController();
        }
        return instance;
    }

    public void addBook(Book book) {
        books.add(book);
        notifyObservers(); // Notify when a book is added
    }

    public void removeBook(String title) {
        books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
        notifyObservers(); // Notify when a book is removed
    }

    public Book findBook(String title) {
        return books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }

    public List<Book> getBooks() {
        return books;
    }

    // Subject implementation
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

//    @Override
//    public void removeObserver(Observer observer) {
//        observers.remove(observer);
//    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
