class Book {
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

    public String getTitle() {
        return title;
    }

    public String getLibrary() {
        return library;
    }

    public boolean isAvailable() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}