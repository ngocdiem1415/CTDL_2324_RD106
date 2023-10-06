package lab3;

import java.util.Comparator;

public class Comparetor implements Comparator<OrderItem> {


    @Override
    public int compare(OrderItem o1, OrderItem o2) {
        return o1.getP().getId().compareTo(o2.getP().getId());
    }
}
