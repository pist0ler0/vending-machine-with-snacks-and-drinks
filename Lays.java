public class Lays extends Item {
    private String name = "czipsy Lays";

    public Lays(){
        super(10, 8);
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
