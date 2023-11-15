package lab9;

public class Chapter {
    private String title;
    private int page;

    public Chapter(String title, int page) {
        this.title = title;
        this.page = page;
    }

    public int getPage() {
        return page;
    }

    @Override
    public String toString() {
        return  title + " " +" " + page;
    }
}
