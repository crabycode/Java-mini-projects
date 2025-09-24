public class Movie {
    private int id;
    private String title;
    private String genre;
    private String director;
    private boolean availabilty;
    private String location;
    public Movie(int id, String title, String genre, String director, boolean availabilty, String location) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.director = director;
        this.availabilty = availabilty;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public boolean isAvailabilty() {
        return availabilty;
    }

    public void setAvailabilty(boolean availabilty) {
        this.availabilty = availabilty;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
