public class Serviceman extends Person {

    public Serviceman(String name, String surname){
        super(name, surname);
    }
    public void refillWater(VendingMachine x){
        x.setWaterQuantity(10);
    }
    public void addBlackCoffee(VendingMachine vending, int n){
        vending.getCzarna_kawa().setQuantity(n);
    }
    public void addWhiteCoffee(VendingMachine vending, int n){
        vending.getBiala_kawa().setQuantity(n);
    }
    public void addTea(VendingMachine vending, int n){
        vending.getHerbata().setQuantity(n);
    }
    public void addPepsi(VendingMachine vending, int n){
        vending.getPepsi().setQuantity(n);
    }
    public void addCocaCola(VendingMachine vending, int n){
        vending.getCola().setQuantity(n);
    }
    public void addFanta(VendingMachine vending, int n){
        vending.getFanta().setQuantity(n);
    }

    
}
