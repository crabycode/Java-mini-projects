import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class LibraryServer {
    private static final int PORT = 5678;
    private List<Book> books = new ArrayList<>();
    private Map<String, List<Book>> rentingLists = new ConcurrentHashMap<>();

    public void startServer() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started at port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Thread(() -> handleClient(clientSocket)).start();
            }
        } catch (IOException e) {
            System.err.println("Error with starting server: " + e.getMessage());
        }
    }

    private void handleClient(Socket clientSocket) {
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
        ) {
            String line;
            while ((line = in.readLine()) != null) {
                String[] parts = line.split("\\|");
                int command = Integer.parseInt(parts[0]);

                switch (command) {
                    case 1:
                        searchBooks(parts[1], out);
                        break;
                    case 2:
                        addToRentingList(Integer.parseInt(parts[1]), parts[2], out);
                        break;
                    case 3:
                        showLibraryBooks(parts[1], out);
                        break;
                }
            }
        } catch (IOException e) {
            System.err.println("Error with client communication: " + e.getMessage());
        }
    }

    private void searchBooks(String title, PrintWriter out) {
        boolean found = false;
        for (Book book : books) {
            if (book.title.equals(title)) {
                found = true;
                out.println(String.format(
                        "Library: %s, Availability: %s",
                        book.library,
                        book.availability ? "Available" : "Not available"
                ));
            }
        }

        if (!found) {
            out.println("Book not found");
        }
    }

    private void addToRentingList(int bookId, String userId, PrintWriter out) {
        Book bookToRent = books.stream()
                .filter(b -> b.id == bookId)
                .findFirst()
                .orElse(null);

        if (bookToRent == null) {
            out.println("Book does not exist");
            return;
        }

        List<Book> userList = rentingLists.computeIfAbsent(userId, k -> new ArrayList<>());

        if (userList.stream().anyMatch(b -> b.id == bookId)) {
            out.println("Book is already added to your list");
            return;
        }

        userList.add(bookToRent);
        out.println("Book successfully added to your list");
    }

    private void showLibraryBooks(String libraryName, PrintWriter out) {
        List<Book> libraryBooks = books.stream()
                .filter(b -> b.library.equals(libraryName))
                .collect(Collectors.toList());

        if (libraryBooks.isEmpty()) {
            out.println("No available books or no existing books");
            return;
        }

        for (Book book : libraryBooks) {
            out.println(String.format(
                    "ID: %d, Title: %s, Author: %s, Availability: %s",
                    book.id,
                    book.title,
                    book.author,
                    book.availability ? "Yes" : "No"
            ));
        }
    }
}