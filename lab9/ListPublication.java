package lab9;

import java.util.List;

public abstract class ListPublication {
    private List<Publication> list;

    public ListPublication(List<Publication> list) {
        this.list = list;
    }

    public abstract String isType(Publication book);

    public abstract boolean isFocusAnd10PublishYear (Publication book);

    public abstract boolean sameTypeAndAuthor ( Publication book1, Publication book2);

    public double totalCost (){
        int total =0;
        for (Publication temp: list) {
            total += temp.getCost();
        }
        return total;
    }

    public ReferenceBook theMostChaper (){
        ReferenceBook result = null;
        for (Publication temp: list ) {
            if ( isType(temp).equals("referenBook")){
                if ( temp. )
            }
        }
        return result;
    }


}
