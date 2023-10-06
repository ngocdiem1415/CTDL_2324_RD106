package lab3;

import java.util.Arrays;

public class Order {
    private OrderItem[] items;
    private Comparetor sort;

    public Order(OrderItem[] items) {
        this.items = items;
    }

    public double cost() {
        double sum = 0.0;
        for (int i = 0; i < items.length; i++) {
            sum += items[i].getP().getPrice();
        }
        return sum;
    }

    // using binary search approach
    public boolean contains(Product p) {
        Arrays.sort(items, new Comparetor());
//        System.out.println(Arrays.toString(items));
        return resursionBinarySearch(p, 0, items.length);
//        for (int i = 0; i < items.length; i++) {
//            if (items[i].getP().equals(p)) {
//        return true;
//            }
//        }
//        return false;
    }

    public boolean resursionBinarySearch(Product p, int low, int high) {
        if (low > high) {
            return false;
        } else {
            int mid = (low + high) / 2;
            if (p == items[mid].getP()) {
                return true;
            } else if (p.compareTo(items[mid].getP()) < 0) {
                return resursionBinarySearch(p, low, mid - 1);
            } else {
                return resursionBinarySearch(p, high, mid + 1);
            }
        }
    }

    //    get all products based on the given type using
//    linear search
    public Product[] filter(String type) {
        int size = 0;
        for (int i = 0; i < items.length; i++) {
            if (type.compareTo(items[i].getP().getType()) == 0) {
                size++;
//                System.out.println(size);
            }
        }
        Product[] result = new Product[size];
        for (int i = 0; i < items.length; i++) {
            int temp = type.compareTo(items[i].getP().getType());
            if ( temp == 0){
                result[(result.length) -size] = items[i].getP();
                size--;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Product pro1 = new Product("1", "A", 22.2, "coca");
        Product pro2 = new Product("10", "A", 22.2, "coca");
        OrderItem od1 = new OrderItem(pro1, 7);
        OrderItem od5 = new OrderItem(pro2, 7);
        OrderItem od2 = new OrderItem(new Product("2", "G", 99.4, "pessi"), 10);
        OrderItem od3 = new OrderItem(new Product("3", "E", 52.2, "starbuck"), 5);
        OrderItem od4 = new OrderItem(new Product("4", "C", 147.8, "water"), 8);

        OrderItem[] test = {od1,od5, od3, od4, od2};
        Order oder = new Order(test);

//        System.out.println(Arrays.toString(test));
//        System.out.println(oder.cost());
//        System.out.println(oder.contains(pro1));
        System.out.println(Arrays.toString(oder.filter("coca")));
    }
}
