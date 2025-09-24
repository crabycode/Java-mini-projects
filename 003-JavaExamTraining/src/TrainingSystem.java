import java.util.*;
import java.io.*;
import java.net.*;

public class TrainingSystem {
    private final int port = 6789;
    private final List<Training> trainings = new ArrayList<>();

    public void fillArrayList(){
        trainings.add(new Training(1, "Fitness", "Kaloyan", "14:00", 3));
        trainings.add(new Training(2, "Dancing", "Betina", "17:00", 12));
        trainings.add(new Training(3, "Yoga", "Betina", "12:00", 12));
        trainings.add(new Training(4, "Running", "Kaloyan", "09:00", 3));
    }
    private synchronized List<Training> findTrainingsByName(String trainingName){
        List<Training> availableTrainings = new ArrayList<>();
        for(int i = 0; i < trainings.size(); i++){
            if(trainings.get(i).getType().equals(trainingName)){
                availableTrainings.add(trainings.get(i));
            }
        }
        if(availableTrainings.isEmpty()){
            System.out.println("No trainings found");
            return null;
        }
        return availableTrainings;
    }
    private synchronized void reserveSpot(int id){
        boolean reserved = false;
        for(int i = 0; i<trainings.size(); i++){
            if(trainings.get(i).getId() == id){
                trainings.get(i).setAvailableSpots(trainings.get(i).getAvailableSpots()- 1);
                System.out.println("Spot reserved successfully");
                reserved = true;
            }
        }
        if(!reserved){
            System.out.println("Spot not reserved");
        }
    }
    private synchronized List<Training> findTrainingsByCoach(String coachName){
        List<Training> availableTrainings = new ArrayList<>();
        for(int i = 0; i< trainings.size(); i++){
            if(trainings.get(i).getCoachName().equals(coachName)){
                availableTrainings.add(trainings.get(i));
            }
        }
        if(availableTrainings.isEmpty()){
            System.out.println("No trainings found");
            return null;
        }
        return availableTrainings;
    }
    public void startServer(){
        try(ServerSocket serverSocket = new ServerSocket(port)){
            while(true){
                Socket clientSocket = serverSocket.accept();
                new Thread(() -> handleClient(clientSocket)).start();
            }
        }
        catch(IOException e){
            System.err.println("Server error: " + e.getMessage());
        }
    }
    private void handleClient(Socket clientSocket){
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
            String input;
            String command = in.readLine();
            switch(command){
                case "1":
                    String type = in.readLine();
                    findTrainingsByName(type);
                    break;
                case "2":
                    int id = Integer.parseInt(in.readLine());
                    reserveSpot(id);
                    break;
                case "3":
                    String coachName = in.readLine();
                    findTrainingsByCoach(coachName);
                    break;
                default:
                    out.println("Invalid command");
                    break;
            }

        }
        catch(IOException e) {
            System.err.println("Client handling error: " + e.getMessage());
        }
        finally{
            try{
                clientSocket.close();
            }
            catch(IOException e){
                System.err.println("Error closing client socket: " + e.getMessage());
            }
        }
    }
}
