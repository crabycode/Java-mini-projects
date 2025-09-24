import java.io.*;
import java.util.*;
import java.net.*;

public class DeliveryManagementServer {
    private final int PORT = 5678;
    private final List<Drink> drinks = new ArrayList<>();
    private final List<Order> orders = new ArrayList<>();
    private int nextOrderId = 0;

    private void addDrinks(){
        drinks.add(new Drink(1, "Cola", "non-alcoholic", 30));
        drinks.add(new Drink(2, "Sprite", "non-alcoholic", 12));
        drinks.add(new Drink(3, "Hankey Bannister", "alcohol", 44));
        drinks.add(new Drink(4, "Cosmopolitan", "cocktail", 0));
        drinks.add(new Drink(5, "Sex on the beach", "cocktail", 0));
    }
    private synchronized List<String> getAllDrinks(){
        List<String> allDrinks = new ArrayList<>();
        for(int i = 0; i<drinks.size(); i++){
            if(drinks.get(i).getQuantity() == 0){
                allDrinks.add(drinks.get(i).getId() + drinks.get(i).getName() + drinks.get(i).getType() + "Drink not available");
            }
            else{
                allDrinks.add(drinks.get(i).getId() + drinks.get(i).getName() + drinks.get(i).getType() + drinks.get(i).getQuantity());
            }
        }
        return allDrinks;
    }
    private synchronized void createOrder(int drinkId, int quantity){
        for(Drink drink:drinks){
            if(drink.getId() == drinkId){
                orders.add(new Order(nextOrderId++, OrderStatus.PENDING, drink.getId(), drink.getName(), drink.getType(), quantity));
                System.out.println("Order created");
                return;
            }
        }
        System.out.println("Drink with such Id was not found.");
    }
    private synchronized List<String> checkOrders(){
        List<String> allOrders = new ArrayList<>();
        for(Order order:orders){
            String orderInfo = String.format("Order ID: %d, Drink: %s, Quantity: %d, Status: %s", order.getOrderId(), order.getName(), order.getQuantity(), order.getStatus());
            allOrders.add(orderInfo);
        }
        return allOrders;
    }
    private synchronized void fillTheBar(){
        for(Order order:orders){
            if(order.getStatus() == OrderStatus.PROCESSED){
                for(Drink drink:drinks){
                    if(drink.getId() == order.getId()){
                        drink.setQuantity(drink.getQuantity() + order.getQuantity());
                        order.setStatus(OrderStatus.FINISHED);
                        break;
                    }
                }
            }
        }
    }
    public void startServer(){
        try(ServerSocket serverSocket = new ServerSocket(PORT)){
            while(true){
                Socket clientSocket = serverSocket.accept();
                new Thread(() -> handleClient(clientSocket)).start();
            }
        }
        catch (IOException e){
            System.err.println("Error starting the server: " + e.getMessage());
        }
    }
    private void handleClient(Socket clientSocket){
        try(BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)){
            String input;
            while ((input = in.readLine()) != null) {
                if (!input.matches("[1-4]")) {
                    out.println("Invalid command. Please enter a number between 1 and 4.");
                    continue;
                }

                int command = Integer.parseInt(input);
                switch(command){
                    case 1:
                        getAllDrinks();
                        break;
                    case 2:
                        out.println("Enter Drink ID:");
                        String drinkIdInput = in.readLine();
                        int drinkId = Integer.parseInt(drinkIdInput);
                        out.println("Enter Quantity:");
                        String quantityInput = in.readLine();
                        int quantity = Integer.parseInt(quantityInput);
                        createOrder(drinkId, quantity);
                        break;
                    case 3:
                        checkOrders();
                        break;
                    case 4:
                        fillTheBar();
                        break;
                }
            }
        }catch(IOException e){
            System.err.println("Client handling error: " + e.getMessage());
        } finally{
            try{
                clientSocket.close();
            }
            catch(IOException e){
                System.err.println("Error closing client socket: " + e.getMessage());
            }
        }
    }
}
