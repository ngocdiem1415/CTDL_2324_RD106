package lab9;

public abstract class Publication {
    private String title;
    private int page;
    private int publishYear;
    private String author;
    private double cost;

    public Publication(String title, int page, int publishYear, String author, double cost) {
        this.title = title;
        this.page = page;
        this.publishYear = publishYear;
        this.author = author;
        this.cost = cost;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public double getCost() {
        return cost;
    }

    public String isType(Publication book) {
        return book instanceof Focus ? "fucus" :"referenBook";
    }

    public boolean isFocusAnd10PublishYear (Publication book) {
        return (isType(book).equals("fucus") && book.publishYear == 2021);
    }

    public boolean sameTypeAndAuthor ( Publication book1, Publication book2){
        return ( isType(book1).equals(isType(book2)) && (book1.author.equals(book2.author)));
    }

}
