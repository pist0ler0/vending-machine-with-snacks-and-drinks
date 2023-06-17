public class HotDrink extends Item{
    private String name;
    private int sugarQuantity;
    private String size;
    public HotDrink(int quantity, double price, String name){
        super(quantity, price);
        this.name = name;
        sugarQuantity = 1;
    }
   
    public int getSugarQuantity() {
        return sugarQuantity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
    

    @Override
    public String info(){
        return "Napój "+getSize()+" "+getName()+" z "+getSugarQuantity()+" kostkami cukru, kosztuje "+super.getPrice()+"zł, i pozostało ich "+super.getQuantity()+". Jedna kostka cukru jest darmowa, każda kolejna kosztuje dodatkowo 20 groszy";
        
    }

    public String getName() {
        return name;
    }
    public void addSugar(VendingMachine v){
        if(sugarQuantity!=5){
           sugarQuantity = sugarQuantity+1;
           v.setSugarPortions(v.getSugarPortions()-1);
        }
    }
    public void decreaseSugar(){
        if(sugarQuantity!=0){
           sugarQuantity = sugarQuantity-1;
        }
    }
    @Override
    public double cost(){
        if(sugarQuantity>1){
            super.setPrice(super.getPrice()+0.2*(sugarQuantity-1));
        }
        return super.getPrice();
        
    }

}
