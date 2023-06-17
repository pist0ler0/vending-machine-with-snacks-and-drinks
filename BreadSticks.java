public class BreadSticks extends Item {
    private String name = "Paluszki krakowskie";
    
    public BreadSticks(){
        super(10, 7);
    }
    public String getName(){
        return name;
    }

    @Override
    public String info() {
        return "Słodka przekąska o nazwie "+getName()+" kosztuje "+super.getPrice()+"zł i pozostało ich "+super.getQuantity();
        
    }

    @Override
    public double cost() {
        return super.getPrice();
    }
    
}
