public class GummyBears extends Item{
    private String name = "Gumisie";
    public GummyBears(){
        super(10, 6);
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
