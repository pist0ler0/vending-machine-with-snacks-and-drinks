public class Client extends Person{
    private float cash;
    
    public Client(String name, String surname, float cash){
        super(name, surname);
        this.cash = cash;
    }
    public Client(float cash){
        super();
        this.cash = cash;
    }
    public float getMoney(){
        cash = (float) (Math.round(cash*100)/100);
        return cash;
    }
    public void setMoney(float cash){
        this.cash = (float) (Math.round(cash*100)/100);
    }
    public void buyBlackCoffee(VendingMachine vending ){
        if(vending.getCzarna_kawa().getPrice()>=cash){
            cash = cash - vending.getCzarna_kawa().getPrice();
            vending.getCzarna_kawa().setQuantity(vending.getCzarna_kawa().getQuantity()-1);
        }
    }
    public void buyWhiteCoffee(VendingMachine vending){
        if(vending.getBiala_kawa().getPrice()>=cash){
            cash = cash - vending.getBiala_kawa().getPrice();
            vending.getBiala_kawa().setQuantity(vending.getBiala_kawa().getQuantity()-1);
        }
    }
    public void buyTea(VendingMachine vending){
        if(vending.getHerbata().getPrice()>=cash){
            cash = cash - vending.getHerbata().getPrice();
            vending.getHerbata().setQuantity(vending.getHerbata().getQuantity()-1);
        }
    }
    public void buyPepsi(VendingMachine vending){
        if(vending.getPepsi().getPrice()>=cash){
            cash = cash - vending.getPepsi().getPrice();
            vending.getPepsi().setQuantity(vending.getPepsi().getQuantity()-1);
        }
    }
    public void buyCocaCola(VendingMachine vending){
        if(vending.getCola().getPrice()>=cash){
            cash = cash - vending.getCola().getPrice();
            vending.getCola().setQuantity(vending.getCola().getQuantity()-1);
        }
    }
    public void buyFanta(VendingMachine vending){
        if(vending.getFanta().getPrice()>=cash){
            cash = cash - vending.getFanta().getPrice();
            vending.getFanta().setQuantity(vending.getFanta().getQuantity()-1);
        }
    }
    public void buyLays(VendingMachine vending){
        if(vending.getCzipsy().getPrice()>=cash){
            cash = cash - vending.getCzipsy().getPrice();
            vending.getCzipsy().setQuantity(vending.getCzipsy().getQuantity()-1);
        }
    }
    public void buyZelki(VendingMachine vending){
        if(vending.getZelki().getPrice()>=cash){
            cash = cash - vending.getZelki().getPrice();
            vending.getZelki().setQuantity(vending.getZelki().getQuantity()-1);
        }
    }
    public void buyPaluszki(VendingMachine vending){
        if(vending.getPaluszki().getPrice()>=cash){
            cash = cash - vending.getPaluszki().getPrice();
            vending.getPaluszki().setQuantity(vending.getPaluszki().getQuantity()-1);
        }
    }

}
