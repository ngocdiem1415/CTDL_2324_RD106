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

    @Override
    public String toString() {
        return title + " ," +page +" ,"+ publishYear +" ,"+ author + " ," + cost +" ,"  ;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public double getCost() {
        return cost;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public abstract String isType();

    public abstract boolean isFocusAnd10PublishYear ();

    public abstract int isSizeChaper();

    public boolean sameAuthorAndSameType (Publication orther){
        return this.author.equalsIgnoreCase(orther.author) && this.isType().equalsIgnoreCase(orther.isType());
    }
}
