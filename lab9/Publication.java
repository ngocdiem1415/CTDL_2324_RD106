package lab9;

public abstract class Book {
    private String title;
    private int page;
    private int publishYear;
    private String author;
    private String cost;

    public Book(String title, int page, int publishYear, String author, String cost) {
        this.title = title;
        this.page = page;
        this.publishYear = publishYear;
        this.author = author;
        this.cost = cost;
    }

}
