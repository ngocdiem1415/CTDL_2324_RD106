package lab9;

public class Focus extends Publication {
    private String name;

    public Focus(String title, int page, int publishYear, String author, String cost, String name) {
        super(title, page, publishYear, author, cost);
        this.name = name;
    }


}
