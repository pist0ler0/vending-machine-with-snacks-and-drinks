public abstract class Item{
    private int quantity;
    private float price;
    public Item(int quantity, float price){
        this.quantity = quantity;
        this.price = price;
    }
    public int getQuantity() {
        return quantity;
    }
    public float getPrice() {
        return price;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public abstract String info();
    public abstract float cost();
}