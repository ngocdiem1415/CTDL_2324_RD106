package lab3;

public class Product{
    private String id;
    private String name;
    private double price;
    private String type;

    public Product(String id, String name, double price, String type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + price + "," + type;
    }

    public int compareTo(Product p) {
        int byName = this.getName().compareTo(p.getName());
        if ( byName == 0){
            int byPrice = Double.compare(this.getPrice(), p.getPrice());
        }
        return byName;
    }
}
