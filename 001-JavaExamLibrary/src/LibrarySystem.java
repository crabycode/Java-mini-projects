import java.util.*;
import java.io.*;
import java.net.*;

public class LibrarySystem {
    private final int port = 5678;
    private final List<Book> bookList = new ArrayList<>();
    private final List<Book> rentalList =  new ArrayList<>();

    private void addBooks(){
        bookList.add(new Book(1, "1234567890", "Python Basics", "John Doe", true, "Central Library"));
        bookList.add(new Book(2, "0987654321", "Data Structures", "Jane Smith", false, "Central Library"));
        bookList.add(new Book(3, "1111111111", "Algorithms", "Alan Turing", true, "City Library"));
    }
    private synchronized String searchBook(String bookName){
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < bookList.size(); i++){
            if(bookList.get(i).getTitle().equals(bookName)){
                result.append("Library: ");
                result.append(bookList.get(i).getLibrary());
                result.append("Available: ");
                result.append(bookList.get(i).getAvailability());
            }
        }
        if(result.length() == 0){
            result.append("No such book");
        }
        return result.toString();
    }
    private synchronized String addBook(int id){
        for(int i = 0; i<rentalList.size(); i++){
            if(rentalList.get(i).getId() == id){
                return "Book already in your rental list";
            }
        }
        for(int i = 0; i < bookList.size(); i++){
            if(bookList.get(i).getId() == id){
                rentalList.add(bookList.get(i));
                bookList.get(i).setAvailability(false);
                return "Book added successfully";
            }
        }
        return "Book ID not found";
    }
    private synchronized List<Book> searchBooksInLibrary(String library){
        List<Book> result = new ArrayList<>();
        for(int i = 0; i < bookList.size(); i++){
            if(bookList.get(i).getLibrary().equals(library)){
                result.add(bookList.get(i));
            }
        }
        if(result.isEmpty()){
            System.out.println("No books found in this library");
        }
        return result;
    }
    public void startServer(){
        try (ServerSocket serverSocket = new ServerSocket(port)) {

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
