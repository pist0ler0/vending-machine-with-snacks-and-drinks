public class VendingMachine {
    private double waterQuantity = 10;
    private int sugarPortions = 10;
    private int bigCupQuantity = 10;
    private int mediumCupQuantity = 10;
    private int smallCupQuantity = 10;
    HotDrink czarna_kawa = new BlackCoffee();
    HotDrink herbata = new Tea();
    HotDrink biala_kawa = new WhiteCoffee();
    ColdDrink cola = new CocaCola();
    ColdDrink fanta = new Fanta();
    ColdDrink pepsi = new Pepsi();
    Lays czipsy = new Lays();
    GummyBears zelki = new GummyBears();
    BreadSticks paluszki = new BreadSticks();
    
    public int getSugarPortions() {
        return sugarPortions;
    }
    public void setSugarPortions(int sugarPortions) {
        this.sugarPortions = sugarPortions;
    }
    public int getBigCupQuantity() {
        return bigCupQuantity;
    }
    public void setBigCupQuantity(int bigCupQuantity) {
        this.bigCupQuantity = bigCupQuantity;
    }
    public int getMediumCupQuantity() {
        return mediumCupQuantity;
    }
    public void setMediumCupQuantity(int mediumCupQuantity) {
        this.mediumCupQuantity = mediumCupQuantity;
    }
    public int getSmallCupQuantity() {
        return smallCupQuantity;
    }
    public void setSmallCupQuantity(int smallCupQuantity) {
        this.smallCupQuantity = smallCupQuantity;
    }
    public Lays getCzipsy() {
        return czipsy;
    }
    public GummyBears getZelki() {
        return zelki;
    }
    public BreadSticks getPaluszki() {
        return paluszki;
    }
    public HotDrink getCzarna_kawa() {
        return czarna_kawa;
    }
    public HotDrink getHerbata() {
        return herbata;
    }
    public HotDrink getBiala_kawa() {
        return biala_kawa;
    }
    public ColdDrink getCola() {
        return cola;
    }
    public ColdDrink getFanta() {
        return fanta;
    }
    public ColdDrink getPepsi() {
        return pepsi;
    }
    public double getWaterQuantity() {
        return waterQuantity;
    }
    public void setWaterQuantity(double waterQuantity) {
        this.waterQuantity = waterQuantity;
    }
    
}
