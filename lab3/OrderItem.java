package lab3;

public class OrderItem {
    private Product p;
    private  int quality;

    public OrderItem(Product p, int quality) {
        this.p = p;
        this.quality = quality;
    }

    public Product getP() {
        return p;
    }

    @Override
    public String toString() {
        return  p + "," + quality + "\n";
    }

}
