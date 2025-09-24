//ChatGPT post-learning
import java.io.*;
import java.net.*;
import java.util.*;

// Клас за представяне на книга
class Book {
    private int id;
    private String isbn;
    private String title;
    private String author;
    private boolean availability;

    public Book(int id, String isbn, String title, String author, boolean availability) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.availability = availability;
    }

    public int getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", availability=" + (availability ? "Available" : "Not Available") +
                '}';
    }
}

// Основен клас за сървъра
public class LibraryServer {
    private static Map<Integer, List<Book>> libraryBooks = new HashMap<>();

    public static void main(String[] args) {
        // Инициализация на библиотеките и книгите
        initializeLibraryData();

        try (ServerSocket serverSocket = new ServerSocket(5678)) {
            System.out.println("Library Server is running on port 5678...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void initializeLibraryData() {
        libraryBooks.put(1, new ArrayList<>(Arrays.asList(
                new Book(101, "978-1", "Java Basics", "Author A", true),
                new Book(102, "978-2", "Advanced Java", "Author B", true)
        )));
        libraryBooks.put(2, new ArrayList<>(Arrays.asList(
                new Book(103, "978-3", "Data Structures", "Author C", true),
                new Book(104, "978-4", "Algorithms", "Author D", false)
        )));
    }

    static synchronized List<String> searchBook(String title) {
        List<String> results = new ArrayList<>();
        for (Map.Entry<Integer, List<Book>> entry : libraryBooks.entrySet()) {
            int libraryId = entry.getKey();
            for (Book book : entry.getValue()) {
                if (book.getTitle().equalsIgnoreCase(title)) {
                    results.add("Library " + libraryId + ": " + book);
                }
            }
        }
        if (results.isEmpty()) {
            results.add("No book with the title '" + title + "' found.");
        }
        return results;
    }

    static synchronized String borrowBook(int libraryId, int bookId) {
        List<Book> books = libraryBooks.get(libraryId);
        if (books != null) {
            for (Book book : books) {
                if (book.getId() == bookId) {
                    if (book.isAvailable()) {
                        book.setAvailability(false);
                        return "Book borrowed successfully: " + book;
                    } else {
                        return "Book is not available for borrowing.";
                    }
                }
            }
        }
        return "Book not found in Library " + libraryId;
    }

    static synchronized List<String> listBooks(int libraryId) {
        List<String> results = new ArrayList<>();
        List<Book> books = libraryBooks.get(libraryId);
        if (books != null) {
            for (Book book : books) {
                results.add(book.toString());
            }
        } else {
            results.add("Library " + libraryId + " does not exist.");
        }
        return results;
    }

    static class ClientHandler extends Thread {
        private Socket clientSocket;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                String input;
                while ((input = in.readLine()) != null) {
                    String[] parts = input.split(" ", 2);
                    int command = Integer.parseInt(parts[0]);
                    String response;

                    switch (command) {
                        case 1: // Търсене на книги
                            String title = parts[1];
                            response = String.join("\n", searchBook(title));
                            break;
                        case 2: // Запаметяване на книга
                            String[] params = parts[1].split(" ");
                            int libraryId = Integer.parseInt(params[0]);
                            int bookId = Integer.parseInt(params[1]);
                            response = borrowBook(libraryId, bookId);
                            break;
                        case 3: // Показване на всички книги в дадена библиотека
                            libraryId = Integer.parseInt(parts[1]);
                            response = String.join("\n", listBooks(libraryId));
                            break;
                        default:
                            response = "Invalid command.";
                            break;
                    }

                    out.println(response);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
