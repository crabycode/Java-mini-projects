import java.io.*;
import java.net.*;
import java.util.*;

public class LibraryServer {
    private final int port = 5678;
    private final List<Book> books = new ArrayList<>();
    private final List<Book> rentalList = new ArrayList<>(); // Replaced Map with List

    public LibraryServer() {
        addSampleBooks();
    }

    private void addSampleBooks() {
        books.add(new Book(1, "1234567890", "Python Basics", "John Doe", true, "Central Library"));
        books.add(new Book(2, "0987654321", "Data Structures", "Jane Smith", false, "Central Library"));
        books.add(new Book(3, "1111111111", "Algorithms", "Alan Turing", true, "City Library"));
    }

    private synchronized String searchBooks(String title) {
        StringBuilder result = new StringBuilder();

        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                result.append("Library: ").append(book.getLibrary())
                        .append(", Available: ").append(book.isAvailable()).append("\n");
            }
        }

        return result.length() > 0 ? result.toString() : "No such book found.";
    }

    private synchronized String addToRentalList(int bookId) {
        for (Book rentedBook : rentalList) {
            if (rentedBook.getId() == bookId) {
                return "Book is already in your rental list.";
            }
        }

        for (Book book : books) {
            if (book.getId() == bookId) {
                if (!book.isAvailable()) {
                    return "Book is not available.";
                }
                rentalList.add(book);
                book.setAvailability(false); // Mark as unavailable
                return "Book added to your rental list.";
            }
        }

        return "Book not found.";
    }

    private synchronized String listBooksInLibrary(String libraryName) {
        StringBuilder result = new StringBuilder();

        for (Book book : books) {
            if (book.getLibrary().equalsIgnoreCase(libraryName)) {
                result.append("ID: ").append(book.getId())
                        .append(", Title: ").append(book.getTitle())
                        .append(", Available: ").append(book.isAvailable()).append("\n");
            }
        }

        return result.length() > 0 ? result.toString() : "No books found in the specified library.";
    }

    public void startServer() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Thread(() -> handleClient(clientSocket)).start();
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }

    private void handleClient(Socket clientSocket) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

            String input;
            while ((input = in.readLine()) != null) {
                String[] parts = input.split("\\|", 2);
                if (parts.length < 2) {
                    out.println("Invalid command format.");
                    continue;
                }

                String command = parts[0];
                String response;

                switch (command) {
                    case "1":
                        response = searchBooks(parts[1]);
                        break;
                    case "2":
                        try {
                            int bookId = Integer.parseInt(parts[1]);
                            response = addToRentalList(bookId);
                        } catch (NumberFormatException e) {
                            response = "Invalid book ID.";
                        }
                        break;
                    case "3":
                        response = listBooksInLibrary(parts[1]);
                        break;
                    default:
                        response = "Invalid command.";
                }

                out.println(response);
            }
        } catch (IOException e) {
            System.err.println("Client handling error: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.err.println("Error closing client socket: " + e.getMessage());
            }
        }
    }
}
