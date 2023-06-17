public class ColdDrink extends Thing{
    private String name;
    public ColdDrink(int quantity, double price, String name){
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



    
}
