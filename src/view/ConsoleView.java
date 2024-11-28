package view;

import controller.LibraryController;
import observer.Observer;

public class ConsoleView implements Observer {
    private final LibraryController library;

    public ConsoleView(LibraryController library) {
        this.library = library;
        library.addObserver(this); // Register as an observer
    }

    @Override
    public void update() {
        System.out.println("\n--- Book List Updated ---");
        library.getBooks().forEach(System.out::println);
    }
}
