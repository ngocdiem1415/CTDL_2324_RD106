package lab3;

public class Order {
    private OrderItem[] items;

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

    public boolean contains(Product p) {
        for (int i = 0; i < items.length; i++) {
            if (items[i].getP().equals(p)) {
                return true;
            }
        }
        return false;
    }


    public Product[] filter(String type) {

        return null;
    }


    public static void main(String[] args) {
        Product pro1 = new Product("1", "A", 22.2, "coca");
        Product pro2 = new Product("10", "A", 22.2, "coca");
        OrderItem od1 = new OrderItem(pro1, 7);
        OrderItem od2 = new OrderItem(new Product("2", "G", 99.4, "pessi"), 10);
        OrderItem od3 = new OrderItem(new Product("3", "E", 52.2, "starbuck"), 5);
        OrderItem od4 = new OrderItem(new Product("4", "C", 147.8, "water"), 8);

        OrderItem[] test = {od1, od2, od3, od4};
        Order oder = new Order(test);

        System.out.println(oder.cost());
        System.out.println(oder.contains(pro2));
    }
}
