public class Book {
    private int id;
    private String isbn;
    private String title;
    private String author;
    private boolean availability;
    private String library;

    public Book(int id, String isbn, String title, String author, boolean availability, String library) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.availability = availability;
        this.library = library;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean getAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public String getLibrary() {
        return library;
    }

    public void setLibrary(String library) {
        this.library = library;
    }
}
