package adapter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Book;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class FileAdapter {
    private final Gson gson;

    public FileAdapter() {
        gson = new Gson(); // Gson library for JSON handling
    }

    public List<Book> importBooks(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            Type listType = new TypeToken<ArrayList<Book>>() {}.getType();
            return gson.fromJson(reader, listType); // Convert JSON to List<Book>
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public void exportBooks(String filePath, List<Book> books) {
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(books, writer); // Convert List<Book> to JSON
            System.out.println("Books exported successfully!");
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }
}
