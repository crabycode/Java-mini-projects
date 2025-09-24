import java.util.*;
import java.io.*;
import java.net.*;

public class ProductSystem {
    private final int port = 4321;
    private final List<Product> products = new ArrayList<>();
    private List<Product> cart = new ArrayList<>();

    public void addProducts() {
        products.add(new Product(1, "sirene", 4.00, "Anastasiq"));
        products.add(new Product(2, "mlqko", 3.40, "Kaufland"));
        products.add(new Product(3, "kashakval", 7.30, "Fantastiko"));
    }

    public synchronized List<Product> getProductsWithName(String name) {
        List<Product> products2 = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().equals(name)) {
                products2.add(products.get(i));
            }
        }
        if (products2.isEmpty()) {
            System.out.println("No products found with name " + name);
        }
        return products2;
    }

    public synchronized void addToCart(int id) {
        for (Product p2 : cart) {
            if (p2.getId() == id) {
                System.out.println("Product already added to the cart");
                return;
            }
        }
        for (Product p : products) {
            if (p.getId() == id) {
                cart.add(p);
            }
        }
    }

    public List<Product> getCart() {

        return cart;
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
                        response = addProducts(parts[1]);
                        break;
                    case "2":
                        try {
                            int bookId = Integer.parseInt(parts[1]);
                            response = getProductsWithName(bookId);
                        } catch (NumberFormatException e) {
                            response = "Invalid book ID.";
                        }
                        break;
                    case "3":
                        response = addToCart(parts[1]);
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
    public void startServer() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Thread(() -> handleClient(clientSocket)).start();
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }
}
