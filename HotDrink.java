public class HotDrink extends Item{
    private String name;
    private int sugarQuantity;
    private String size;
    private VendingMachineFrame frame;
    private float cost;
    public HotDrink(int quantity, float price, String name, VendingMachineFrame frame){
        super(quantity, price);
        this.name = name;
        sugarQuantity = 1;
        this.frame = frame;
    }
   
    public void setSugarQuantity(int sugar){
        this.sugarQuantity = sugar;
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
    @Override
    public float cost(){
        cost = super.getPrice();
        System.out.println("oryginalna cena "+cost);
        sugarQuantity = frame.getSugarQuantity();
        if( frame.getCupSize() == 1){
            cost = cost + 0.4f;
        }
        if( frame.getCupSize() == 2){
            cost = cost + 0.8f;
        }
        if(sugarQuantity>1){
            cost= cost + 0.2f*(sugarQuantity-1);
        }
        System.out.println("Koszt tego gówna przed zaokragleniu to "+cost);
        cost = (float) (Math.round(cost * 100.0) / 100.0);
        System.out.println("Koszt tego gówna po zaokragleniu to "+cost);
        return cost;
    }
}
