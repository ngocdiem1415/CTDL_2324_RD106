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

    public List<Chapter> getChapters() {
        return chapters;
    }

    public int isSize(){
        return chapters.size();
    }
}
