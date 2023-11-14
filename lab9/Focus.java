package lab9.task2;

public class Focus extends Book {
    private String name;

    public Focus(String title, int page, int publishYear, String author, String cost, String name) {
        super(title, page, publishYear, author, cost);
        this.name = name;
    }


}
