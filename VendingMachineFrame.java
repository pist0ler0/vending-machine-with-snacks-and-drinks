import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
//TODO konstruktor z przekazaniem Serwisanta, Gui Serwisanta

public class VendingMachineFrame extends JFrame implements ActionListener{
    Client client;
    Serviceman serviceman;
    JButton checkQuantityButton;
    JLabel waterQuantityJLabel;
    JButton goToMyFrameButton;
    JButton buyButton;
    JComboBox<String> whatItemToBuyBox;
    JButton exitButton;
    VendingMachine v;
    CupSizePopup cupSizePopup;
    JButton checkBalanceButton;
    private int sugarQuantity;
    private int cupSize;
    public int getSugarQuantity(){
        return sugarQuantity;
    }
    public int getCupSize(){
        return cupSize;
    }
    public void setSizeAndSugar(int sugarQuantity, int cupSize){
        this.sugarQuantity = sugarQuantity;
        this.cupSize = cupSize;
    }
    private String[] things = { "CocaCola", "Fanta", "Pepsi", "Czarna kawa", "Biała kawa", "Herbata", "Chipsy Lays", "Żelki Gumisie", "Paluszki Krakuski"  };

    public VendingMachineFrame(Serviceman serviceman){
        super("Panel Serwisanta");
        v = VendingMachine.getInstance(this);

    }
    public VendingMachineFrame(Client client){
        super("Panel Klienta");
        v = VendingMachine.getInstance(this);
        this.client = client;
        setSize(800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new GridLayout(10, 2, 10, 10));
        whatItemToBuyBox = new JComboBox<>(things);
        buyButton = new JButton("Kup");
        buyButton.addActionListener(this);
        checkBalanceButton = new JButton("Sprawdź stan konta");
        checkBalanceButton.addActionListener(this);
        goToMyFrameButton = new JButton("Powrót");
        goToMyFrameButton.addActionListener(this);
        exitButton = new JButton("Wyjdź");
        exitButton.addActionListener(this);
        add(new JLabel("Vending Machine"));
        add(new JLabel());
        add(new JLabel());
        add(new JLabel("Wybierz co chcesz kupić"));
        add(whatItemToBuyBox);
        add(buyButton);
        add(checkBalanceButton);
        add(goToMyFrameButton);
        add(exitButton);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == goToMyFrameButton){
             dispose();
             new MyFrame();
        }
        if(e.getSource() == buyButton){
            try{

                if(whatItemToBuyBox.getSelectedIndex()==0){
                    //Cola
                    if(client.getMoney()>=v.getCola().getPrice()){
                        client.setMoney(client.getMoney()-v.getCola().getPrice());
                        JOptionPane.showMessageDialog(this, "Zakupiłeś właśnie CocaCole,"+v.getCola().getPrice()+"zł zostało zabrane z konta bankowego", "Zakup Udany", JOptionPane.INFORMATION_MESSAGE);
                        v.getCola().setQuantity(v.getCola().getQuantity()-1);
                    }else{
                        JOptionPane.showMessageDialog(this, "Nie udało się zakupić produktu, nie masz wystarczających środków", "Zakup nie udany", JOptionPane.ERROR_MESSAGE);
                    }

                }
                if(whatItemToBuyBox.getSelectedIndex()==1){
                    //Fanta
                    if(client.getMoney()>=v.getFanta().getPrice()){
                        client.setMoney(client.getMoney()-v.getFanta().getPrice());
                        JOptionPane.showMessageDialog(this, "Zakupiłeś właśnie Fante,"+v.getFanta().getPrice()+"zł zostało zabrane z konta bankowego", "Zakup Udany", JOptionPane.INFORMATION_MESSAGE);
                        v.getFanta().setQuantity(v.getFanta().getQuantity()-1);
                    }else{
                        JOptionPane.showMessageDialog(this, "Nie udało się zakupić produktu, nie masz wystarczających środków", "Zakup nie udany", JOptionPane.ERROR_MESSAGE);
                    }
                }
                if(whatItemToBuyBox.getSelectedIndex()==2){
                    //Pepsi
                    if(client.getMoney()>=v.getPepsi().getPrice()){
                        client.setMoney(client.getMoney()-v.getPepsi().getPrice());
                        JOptionPane.showMessageDialog(this, "Zakupiłeś właśnie Pepsi,"+v.getPepsi().getPrice()+"zł zostało zabrane z konta bankowego", "Zakup Udany", JOptionPane.INFORMATION_MESSAGE);
                        v.getPepsi().setQuantity(v.getPepsi().getQuantity()-1);
                    }else{
                        JOptionPane.showMessageDialog(this, "Nie udało się zakupić produktu, nie masz wystarczających środków", "Zakup nie udany", JOptionPane.ERROR_MESSAGE);
                    }
                }
                if(whatItemToBuyBox.getSelectedIndex()==3){
                    //Czarna Kawa
                    cupSizePopup = new CupSizePopup(this);
                } 
                if(whatItemToBuyBox.getSelectedIndex()==4){
                    //Biała kawa
                    cupSizePopup = new CupSizePopup(this);
                    
                        
                    }
                if(whatItemToBuyBox.getSelectedIndex()==5){
                    //Herbata
                    cupSizePopup = new CupSizePopup(this);
                        
                    
                }
                if(whatItemToBuyBox.getSelectedIndex()==6){
                    //Chipsy Lays
                    if(client.getMoney()>=v.getCzipsy().getPrice()){
                        client.setMoney(client.getMoney()-v.getCzipsy().getPrice());
                        JOptionPane.showMessageDialog(this, "Zakupiłeś właśnie Chipsy Lays,"+v.getCzipsy().getPrice()+"zł zostało zabrane z konta bankowego", "Zakup Udany", JOptionPane.INFORMATION_MESSAGE);
                        v.getCzipsy().setQuantity(v.getCzipsy().getQuantity()-1);
                    }else{
                        JOptionPane.showMessageDialog(this, "Nie udało się zakupić produktu, nie masz wystarczających środków", "Zakup nie udany", JOptionPane.ERROR_MESSAGE);
                    }
                }
                if(whatItemToBuyBox.getSelectedIndex()==7){
                    //Żelki Gumisie
                    if(client.getMoney()>=v.getZelki().getPrice()){
                        client.setMoney(client.getMoney()-v.getZelki().getPrice());
                        JOptionPane.showMessageDialog(this, "Zakupiłeś właśnie Żelki Gumisie,"+v.getZelki().getPrice()+"zł zostało zabrane z konta bankowego", "Zakup Udany", JOptionPane.INFORMATION_MESSAGE);
                        v.getZelki().setQuantity(v.getZelki().getQuantity()-1);
                    }else{
                        JOptionPane.showMessageDialog(this, "Nie udało się zakupić produktu, nie masz wystarczających środków", "Zakup nie udany", JOptionPane.ERROR_MESSAGE);
                    }
                }
                if(whatItemToBuyBox.getSelectedIndex()==8){
                    //Paluszki Krakuski
                    if(client.getMoney()>=v.getPaluszki().getPrice()){
                        client.setMoney(client.getMoney()-v.getPaluszki().getPrice());
                        JOptionPane.showMessageDialog(this, "Zakupiłeś właśnie Paluszki Krakuski,"+v.getPaluszki().getPrice()+"zł zostało zabrane z konta bankowego", "Zakup Udany", JOptionPane.INFORMATION_MESSAGE);
                        v.getPaluszki().setQuantity(v.getPaluszki().getQuantity()-1);
                    }else{
                        JOptionPane.showMessageDialog(this, "Nie udało się zakupić produktu, nie masz wystarczających środków", "Zakup nie udany", JOptionPane.ERROR_MESSAGE);
                    }
                }
                revalidate();
                repaint();


            }catch(Exception a){

            }
            
        }
        if(e.getSource() == exitButton){
            dispose();
        }
        if(e.getSource() == checkBalanceButton){
            JOptionPane.showMessageDialog(this, "Dostępne Środki: "+client.getMoney()+"zł", "Stan Konta", JOptionPane.INFORMATION_MESSAGE);
        }
        
        
    }

    
}
