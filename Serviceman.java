public class Serviceman extends Person {
    private int pin = 6969;
    public int getPin(){
        return pin;
    }
    public Serviceman(String name, String surname){
        super(name, surname);
    }
    public Serviceman(){
        super();
    }
    public void addSugar(VendingMachine vending){
        vending.setSugarPortions(20);
    }
    public void refillWater(VendingMachine vending){
        vending.setWaterQuantity(10);
    }
    public void addBlackCoffee(VendingMachine vending){
        vending.getCzarna_kawa().setQuantity(10);
    }
    public void addWhiteCoffee(VendingMachine vending){
        vending.getBiala_kawa().setQuantity(10);
    }
    public void addTea(VendingMachine vending){
        vending.getHerbata().setQuantity(10);
    }
    public void addPepsi(VendingMachine vending){
        vending.getPepsi().setQuantity(10);
    }
    public void addCocaCola(VendingMachine vending){
        vending.getCola().setQuantity(10);
    }
    public void addFanta(VendingMachine vending){
        vending.getFanta().setQuantity(10);
    }
    public void addLays(VendingMachine vending){
        vending.getCzipsy().setQuantity(10);
    }
    public void addZelki(VendingMachine vending){
        vending.getZelki().setQuantity(10);
    }
    public void addPaluszki(VendingMachine vending){
        vending.getPaluszki().setQuantity(10);
    }
    public void addSmallCup(VendingMachine vending){
        vending.setSmallCupQuantity(10);
    }
    public void addMediumCup(VendingMachine vending){
        vending.setMediumCupQuantity(10);
    }
    public void addBigCup(VendingMachine vending){
        vending.setBigCupQuantity(10);
    }

    
}
