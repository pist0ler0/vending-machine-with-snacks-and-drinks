public class HotDrink extends Thing{
    private String name;
    private int sugarQuantity;
    private String size;
    public HotDrink(int quantity, double price, String name, int sugarQuantity, String size){
        super(quantity, price);
        this.name = name;
        this.size = size;
        this.sugarQuantity = sugarQuantity;
    }
   
    public int getSugarQuantity() {
        return sugarQuantity;
    }

    public String getSize() {
        return size;
    }

    @Override
    public String info(){
        return "Napój "+getSize()+" "+getName()+" z "+getSugarQuantity()+" kostkami cukru, kosztuje "+super.getPrice()+"zł, i pozostało ich "+super.getQuantity()+". Jedna kostka cukru jest darmowa, każda kolejna kosztuje dodatkowo 20 groszy";
        
    }

    public String getName() {
        return name;
    }
    public void addSugar(){
        sugarQuantity = sugarQuantity+1;
        if(sugarQuantity>1){
            super.setPrice(super.getPrice()+0.2);
        }
    }
    public void decreaseSugar(){
        sugarQuantity = sugarQuantity-1;
        if(sugarQuantity>=1){
            super.setPrice(super.getPrice()-0.2);
        }
    }

}
