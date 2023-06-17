public abstract class Item{
    private int quantity;
    private double price;
    public Item(int quantity, double price){
        this.quantity = quantity;
        price = price - price % 0.01;
        this.price = price;
    }
    public Item(){
        price = 3.99;
        quantity = 10;
    }
    public int getQuantity() {
        return quantity;
    }
    public double getPrice() {
        return price;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public abstract String info();
    public abstract double cost();
}