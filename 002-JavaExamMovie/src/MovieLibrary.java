import java.util.*;
import java.io.*;
import java.net.*;

public class MovieLibrary {
    public final int port = 5678;
    private final List<Movie> movies = new ArrayList<>();
    private void addSampleMovies() {
        movies.add(new Movie(1, "Inception", "Sci-Fi", "Christopher Nolan", true, "Shelf A"));
        movies.add(new Movie(2, "Interstellar", "Sci-Fi", "Christopher Nolan", true, "Shelf B"));
        movies.add(new Movie(3, "The Godfather", "Crime", "Francis Ford Coppola", true, "Shelf C"));
    }

    private synchronized List<String> findMovie(String title){
        List<String> availableLocations = new ArrayList<>();
        for(int i = 0; i < movies.size(); i++){
            if(movies.get(i).getTitle().equals(title)){
                availableLocations.add(movies.get(i).getLocation());
            }
        }
        if(availableLocations.size() == 0){
            System.out.println("No movies found");
        }
        return availableLocations;
    }
    private synchronized void changeMovieAvailability(int id){
        int found = 0;
        for(int i = 0; i < movies.size(); i++){
            if(movies.get(i).getId() == id){
                if (!movies.get(i).isAvailabilty()) {
                    System.out.println("Movie is not available");
                    return;
                }
                movies.get(i).setAvailabilty(false);
                found = 1;
            }
        }
        if(found == 0){
            System.out.println("No movie found");
        }
    }
    private synchronized List<Movie> searchByGenre(String genre){
        List<Movie> foundMovies = new ArrayList<>();
        for(int i = 0; i < movies.size(); i++){
            if(movies.get(i).getGenre().equals(genre)){
                foundMovies.add(movies.get(i));
            }
        }
        if(foundMovies.size() == 0){
            System.out.println("No movie found");
        }
        return foundMovies;
    }
    public void startServer(){
        try(ServerSocket serverSocket = new ServerSocket(port)){
            while(true){
                Socket clientSocket = serverSocket.accept();
                new Thread(() -> handleClient(clientSocket)).start();
            }
        } catch (IOException e) {
            System.err.println("Server error: "+ e.getMessage());
        }
    }
    private void handleClient(Socket clientSocket){
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

            String input;
            while((input=in.readLine()) != null){
                switch(input){
                    case "1":
                        String condition = in.readLine();
                        findMovie(condition);
                        break;
                    case "2":
                        int id = Integer.parseInt(in.readLine());
                        changeMovieAvailability(id);
                        break;
                        case "3":
                            String genre = in.readLine();
                            searchByGenre(genre);
                            break;
                    default:
                        out.println("Unknown command");
                        break;
                }
            }
        } catch (IOException e){
            System.err.println("Client handling error: " + e.getMessage());
        } finally{
            try{
                clientSocket.close();
            } catch(IOException e){
                System.err.println("Error closing clinet socket: " + e.getMessage());
            }
        }
    }
}
