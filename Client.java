public class Client extends Person{
    private double cash;
    
    public Client(String name, String surname, double cash){
        super(name, surname);
        this.cash = cash;
    }
    public double getMoney(){
        return cash;
    }
    public void setMoney(double cash){
        this.cash = cash;
    }
}
