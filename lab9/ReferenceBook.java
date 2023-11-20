package lab9;

import java.util.List;

public class ReferenceBook extends Publication {
    private String fied;
    private List<Chapter> chapters;

    public ReferenceBook(String title, int page, int publishYear, String author, double cost, String fied, List<Chapter> chapters) {
        super(title, page, publishYear, author, cost);
        this.fied = fied;
        this.chapters = chapters;
    }

    @Override
    public String toString() {
        return super.toString() + fied + " " + " " + chapters + "\n";
    }

    @Override
    public String isType() {
        return "ReferenceBook";
    }

    @Override
    public boolean isFocusAnd10PublishYear() {
        return false;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public int isSizeChaper() {
        int total = 0;
        for (Chapter i : chapters) {
            total += i.getPage();
        }
        return total;
    }
}
