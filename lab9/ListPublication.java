package lab9;

import java.util.List;

public class Publication {
    private List<Book> list;

    public Publication() {
    }

    public String isType(Book book) {
        return book instanceof Focus ? "fucus" :"referenBook";
    }
}
