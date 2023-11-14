package lab9.task2;

import java.util.List;

public class ReferenceBook extends Book {
    private String fied;
    private List<Chapter> chapters;

    public ReferenceBook(String title, int page, int publishYear, String author, String cost, String fied, List<Chapter> chapters) {
        super(title, page, publishYear, author, cost);
        this.fied = fied;
        this.chapters = chapters;
    }
}
