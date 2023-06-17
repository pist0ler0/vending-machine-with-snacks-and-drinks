public abstract class Thing{
    private int quantity;
    private double price;
    public Thing(int quantity, double price){
        this.quantity = quantity;
        price = price - price % 0.01;
        this.price = price;
    }
    public Thing(){
        price = 3.99;
        quantity = 10;
    }
    public int getQuantity() {
        return quantity;
    }
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    public abstract String info();
}