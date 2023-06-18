public class ColdDrink extends Item{
    private String name;
    public ColdDrink(int quantity, float price, String name){
        super(quantity, price);
        this.name = name;
    }
    
    @Override
    public String info(){
        return "Napój o nazwie "+getName()+" kosztuje "+super.getPrice()+"zł, i pozostało ich "+super.getQuantity();
        
    }

    public String getName() {
        return name;
    }

    @Override
    public float cost() {
       return super.getPrice();
    }



    
}
