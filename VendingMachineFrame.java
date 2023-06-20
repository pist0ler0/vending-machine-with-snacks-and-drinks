import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.*;

public final class VendingMachineFrame extends JFrame implements ActionListener{
   
    //Panel klienta
    Client client = new Client(100f);
    JButton goToMyFrameButton;
    JButton buyButton;
    JLabel brokenBuyJLabel;
    JLabel brokenBalanceLabel;
    JComboBox<String> whatItemToBuyBox;
    JComboBox<String> paymentBox;
    private String[] paymentMethods = {"Płatność kartą", "Płatność gotówką"};
    JButton exitButton;
    VendingMachine v;
    CupSizePopup cupSizePopup;
    JButton checkBalanceButton;
    private int unluckyNumber = 3;
    private int sugarQuantity;
    private int cupSize;
    private static VendingMachineFrame instance;
    
    //Panel Serwisanta
    Serviceman serviceman;
    
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

    
    private VendingMachineFrame(){
        super("Panel Klienta");
        v = VendingMachine.getInstance(this);
        setSize(800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new GridLayout(10, 1, 10, 10));
        whatItemToBuyBox = new JComboBox<>(things);
        buyButton = new JButton("Kup");
        buyButton.addActionListener(this);
        checkBalanceButton = new JButton("Sprawdź stan konta");
        checkBalanceButton.addActionListener(this);
        goToMyFrameButton = new JButton("Powrót");
        goToMyFrameButton.addActionListener(this);
        exitButton = new JButton("Wyjdź");
        exitButton.addActionListener(this);
        paymentBox = new JComboBox<>(paymentMethods);
        add(new JLabel("Vending Machine"));
        brokenBalanceLabel = new JLabel();
        brokenBuyJLabel = new JLabel();
        add(brokenBalanceLabel);
        add(brokenBuyJLabel);
        add(new JLabel("Wybierz co chcesz kupić"));
        add(whatItemToBuyBox);
        add(paymentBox);
        add(buyButton);
        add(checkBalanceButton);
        add(goToMyFrameButton);
        add(exitButton);
        setVisible(true); 
    }
    public static VendingMachineFrame getInstance(){
        if(instance == null){
            instance = new VendingMachineFrame();
        }
        return instance;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == goToMyFrameButton){
             setVisible(false);
             new MyFrame();
             client.setMoney(100f);
        }
        if(e.getSource() == buyButton){
            revalidate();
            repaint();
            int x = (int) ((Math.random() * (10 - 1)) + 1);
            if(unluckyNumber != x){
            if(paymentBox.getSelectedIndex()==0){
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
        }if(paymentBox.getSelectedIndex()==1){
            try{

                if(whatItemToBuyBox.getSelectedIndex()==0){
                    //Cola
                    if(v.getCola().getQuantity()>0){
                        Object[] possibleValues = {"10", "20", "50", "100"};
                        Object selectedValue = JOptionPane.showInputDialog(null,
                  "Wybierz banknot jakim płacisz", "Payment",
                  JOptionPane.INFORMATION_MESSAGE, null,
                  possibleValues, possibleValues[0]);    
                             JOptionPane.showMessageDialog(this, "Zakupiłeś właśnie CocaCole, "+(float) Math.round(((Float.parseFloat(selectedValue.toString()) - v.getCola().getPrice()))*100)/100+"zł reszty", "Zakup Udany", JOptionPane.INFORMATION_MESSAGE);
                             v.getCola().setQuantity(v.getCola().getQuantity()-1);
                       }else{
                            JOptionPane.showMessageDialog(this, "brak produktu", "Brak produktu", JOptionPane.ERROR_MESSAGE);
                       }
                }
                if(whatItemToBuyBox.getSelectedIndex()==1){
                    //Fanta

                    if(v.getFanta().getQuantity()>0){
                        Object[] possibleValues = {"10", "20", "50", "100"};
                        Object selectedValue = JOptionPane.showInputDialog(null,
                        "Wybierz banknot jakim płacisz", "Payment",
                  JOptionPane.INFORMATION_MESSAGE, null,
                  possibleValues, possibleValues[0]);    
                             JOptionPane.showMessageDialog(this, "Zakupiłeś właśnie Fante, "+(float) Math.round((Float.parseFloat(selectedValue.toString()) - v.getFanta().getPrice())*100)/100+"zł reszty", "Zakup Udany", JOptionPane.INFORMATION_MESSAGE);
                             v.getFanta().setQuantity(v.getFanta().getQuantity()-1);
                       }else{
                            JOptionPane.showMessageDialog(this, "brak produktu", "Brak produktu", JOptionPane.ERROR_MESSAGE);
                       }
                }
                if(whatItemToBuyBox.getSelectedIndex()==2){
                    //Pepsi
                    if(v.getPepsi().getQuantity()>0){
                        Object[] possibleValues = {"10", "20", "50", "100"};
                        Object selectedValue = JOptionPane.showInputDialog(null,
                        "Wybierz banknot jakim płacisz", "Payment",
                  JOptionPane.INFORMATION_MESSAGE, null,
                  possibleValues, possibleValues[0]);    
                             JOptionPane.showMessageDialog(this, "Zakupiłeś właśnie Pepsi, "+(float) Math.round((Float.parseFloat(selectedValue.toString()) - v.getPepsi().getPrice())*100)/100+"zł reszty", "Zakup Udany", JOptionPane.INFORMATION_MESSAGE);
                             v.getPepsi().setQuantity(v.getPepsi().getQuantity()-1);
                       }else{
                            JOptionPane.showMessageDialog(this, "brak produktu", "Brak produktu", JOptionPane.ERROR_MESSAGE);
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
                   if(v.getCzipsy().getQuantity()>0){
                    Object[] possibleValues = {"10", "20", "50", "100"};
                    Object selectedValue = JOptionPane.showInputDialog(null,
                    "Wybierz banknot jakim płacisz", "Payment",
              JOptionPane.INFORMATION_MESSAGE, null,
              possibleValues, possibleValues[0]);    
                         JOptionPane.showMessageDialog(this, "Zakupiłeś właśnie Chipsy Lays, "+(float) Math.round((Float.parseFloat(selectedValue.toString()) - v.getCzipsy().getPrice())*100)/100+"zł reszty", "Zakup Udany", JOptionPane.INFORMATION_MESSAGE);
                         v.getCzipsy().setQuantity(v.getCzipsy().getQuantity()-1);
                   }else{
                        JOptionPane.showMessageDialog(this, "brak produktu", "Brak produktu", JOptionPane.ERROR_MESSAGE);
                   }
                }
                if(whatItemToBuyBox.getSelectedIndex()==7){
                    //Żelki Gumisie
                    if(v.getZelki().getQuantity()>0){
                        Object[] possibleValues = {"10", "20", "50", "100"};
                        Object selectedValue = JOptionPane.showInputDialog(null,
                        "Wybierz banknot jakim płacisz", "Payment",
                  JOptionPane.INFORMATION_MESSAGE, null,
                  possibleValues, possibleValues[0]);    
                             JOptionPane.showMessageDialog(this, "Zakupiłeś właśnie Żelki Gumisie, "+(float) Math.round((Float.parseFloat(selectedValue.toString()) - v.getZelki().getPrice())*100)/100+"zł reszty", "Zakup Udany", JOptionPane.INFORMATION_MESSAGE);
                             v.getZelki().setQuantity(v.getZelki().getQuantity()-1);
                       }else{
                            JOptionPane.showMessageDialog(this, "brak produktu", "Brak produktu", JOptionPane.ERROR_MESSAGE);
                       }
                }
                if(whatItemToBuyBox.getSelectedIndex()==8){
                    //Paluszki Krakuski
                    if(v.getPaluszki().getQuantity()>0){
                        Object[] possibleValues = {"10", "20", "50", "100"};
                        Object selectedValue = JOptionPane.showInputDialog(null,
                        "Wybierz banknot jakim płacisz", "Payment",
                  JOptionPane.INFORMATION_MESSAGE, null,
                  possibleValues, possibleValues[0]);    
                             JOptionPane.showMessageDialog(this, "Zakupiłeś właśnie Paluszki Krakuski, "+(float) Math.round((Float.parseFloat(selectedValue.toString()) - v.getPaluszki().getPrice())*100)/100+"zł reszty", "Zakup Udany", JOptionPane.INFORMATION_MESSAGE);
                             v.getPaluszki().setQuantity(v.getPaluszki().getQuantity()-1);
                       }else{
                            JOptionPane.showMessageDialog(this, "brak produktu", "Brak produktu", JOptionPane.ERROR_MESSAGE);
                       }
                }
                revalidate();
                repaint();


            }catch(Exception a){

            }

        }

        }else{
            buyButton.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Awaria!", "Awaria!", JOptionPane.ERROR_MESSAGE);
            brokenBuyJLabel.setText("Maszyna uległa awarii!!");
            brokenBuyJLabel.setForeground(Color.RED);
        }}
        
        if(e.getSource() == exitButton){
            dispose();
        }
        if(e.getSource() == checkBalanceButton){
            int x = (int) ((Math.random() * (10 - 1)) + 1);
            if(unluckyNumber != x){
            JOptionPane.showMessageDialog(this, "Dostępne Środki: "+client.getMoney()+"zł", "Stan Konta", JOptionPane.INFORMATION_MESSAGE);
        }else{
            checkBalanceButton.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Awaria!", "Awaria!", JOptionPane.ERROR_MESSAGE);
            brokenBalanceLabel.setText("Przycisk sprawdzania stanu konta zepsuty");
            brokenBalanceLabel.setForeground(Color.RED);
        }}
         try{
            FileOutputStream f = new FileOutputStream("VendingMachineThings.txt");
            ObjectOutputStream oOS = new ObjectOutputStream(f);
            oOS.writeObject(VendingMachine.getInstance(VendingMachineFrame.getInstance()));
            oOS.close();
            f.close();
        }catch(IOException g){
            g.printStackTrace();
        }
        
        
    }

    
}
