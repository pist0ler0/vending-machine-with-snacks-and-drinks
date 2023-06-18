import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CupSizePopup extends JFrame implements ActionListener{
    JComboBox<String> cupSizeBox;
    JComboBox<Integer> sugar;
    JButton chosenButton;
    private VendingMachineFrame frame;
    private Integer[] sugarQuantity = {0, 1, 2, 3, 4, 5};
    private String[] sizes = {"Mały kubek", "Średni kubek", "Duży kubek"};
    public JComboBox<String> getCupSizeBox(){
        return cupSizeBox;
    }
    public JComboBox<Integer> getSugar(){
        return sugar;
    }

    public CupSizePopup(VendingMachineFrame frame){
        super("Wybierz wielkość Kubka");
        this.frame = frame;
        setSize(500,500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 1, 10, 10));
        setResizable(false);
        cupSizeBox = new JComboBox<>(sizes);
        add(cupSizeBox);
        sugar = new JComboBox<>(sugarQuantity);
        add(sugar);
        chosenButton = new JButton("Wybierz");
        chosenButton.addActionListener(this);
        add(chosenButton);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(frame.whatItemToBuyBox.getSelectedIndex()==3){
        frame.setSizeAndSugar(sugar.getSelectedIndex(), cupSizeBox.getSelectedIndex());
                    if(cupSizeBox.getSelectedIndex() == 0){
                        if(frame.v.getWaterQuantity()>=frame.v.getReqSmallCupWaterQuantity()){
                            if(frame.v.getSmallCupQuantity()>0){
                           if(frame.client.getMoney()>=frame.v.getCzarna_kawa().cost()){
                            frame.client.setMoney(frame.client.getMoney()-frame.v.getCzarna_kawa().cost());
                            JOptionPane.showMessageDialog(frame, "Zakupiłeś właśnie małą Czarną kawe,"+frame.v.getCzarna_kawa().cost()+"zł zostało zabrane z konta bankowego", "Zakup Udany", JOptionPane.INFORMATION_MESSAGE);
                            frame.v.getCzarna_kawa().setQuantity(frame.v.getCzarna_kawa().getQuantity()-1);
                            frame.v.setSmallCupQuantity(frame.v.getSmallCupQuantity()-1);
                            frame.v.setWaterQuantity(frame.v.getWaterQuantity()-frame.v.getReqSmallCupWaterQuantity());
                        }else{
                            JOptionPane.showMessageDialog(frame, "Nie udało się zakupić produktu, nie masz wystarczających środków", "Zakup nie udany", JOptionPane.ERROR_MESSAGE);
                           }
                        }else{
                            JOptionPane.showMessageDialog(frame, "Brak Małych Kubków", "Brak Kubków", JOptionPane.ERROR_MESSAGE);
                        }
                        }else{
                        JOptionPane.showMessageDialog(frame, "Brak Wody", "Brak Wody", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    if(cupSizeBox.getSelectedIndex() == 1){
                        if(frame.v.getWaterQuantity()>=frame.v.getReqMediumCupWaterQuantity()){
                            if(frame.v.getMediumCupQuantity()>0){
                           if(frame.client.getMoney()>=frame.v.getCzarna_kawa().cost()){
                            frame.client.setMoney(frame.client.getMoney()-frame.v.getCzarna_kawa().cost());
                            JOptionPane.showMessageDialog(frame, "Zakupiłeś właśnie średnią Czarną kawe,"+frame.v.getCzarna_kawa().cost()+"zł zostało zabrane z konta bankowego", "Zakup Udany", JOptionPane.INFORMATION_MESSAGE);
                            frame.v.getCzarna_kawa().setQuantity(frame.v.getCzarna_kawa().getQuantity()-1);
                            frame.v.setMediumCupQuantity(frame.v.getMediumCupQuantity()-1);
                            frame.v.setWaterQuantity(frame.v.getWaterQuantity()-frame.v.getReqMediumCupWaterQuantity());
                        }else{
                            JOptionPane.showMessageDialog(frame, "Nie udało się zakupić produktu, nie masz wystarczających środków", "Zakup nie udany", JOptionPane.ERROR_MESSAGE);
                           }
                        }else{
                            JOptionPane.showMessageDialog(frame, "Brak Średnich kubków", "Brak kubków", JOptionPane.ERROR_MESSAGE);
                        }
                        }else{
                        JOptionPane.showMessageDialog(frame, "Brak Wody", "Brak Wody", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    if(cupSizeBox.getSelectedIndex() == 2){
                        if(frame.v.getWaterQuantity()>=frame.v.getReqBigCupWaterQuantity()){
                            if(frame.v.getBigCupQuantity()>0){
                           if(frame.client.getMoney()>=frame.v.getCzarna_kawa().cost()){
                            frame.client.setMoney(frame.client.getMoney()-frame.v.getCzarna_kawa().cost());
                            JOptionPane.showMessageDialog(frame, "Zakupiłeś właśnie dużą Czarną kawe,"+frame.v.getCzarna_kawa().cost()+"zł zostało zabrane z konta bankowego", "Zakup Udany", JOptionPane.INFORMATION_MESSAGE);
                            frame.v.getCzarna_kawa().setQuantity(frame.v.getCzarna_kawa().getQuantity()-1);
                            frame.v.setBigCupQuantity(frame.v.getBigCupQuantity()-1);
                            frame.v.setWaterQuantity(frame.v.getWaterQuantity()-frame.v.getReqBigCupWaterQuantity());
                        }else{
                            JOptionPane.showMessageDialog(frame, "Nie udało się zakupić produktu, nie masz wystarczających środków", "Zakup nie udany", JOptionPane.ERROR_MESSAGE);
                           }
                        }else{
                            JOptionPane.showMessageDialog(frame, "Brak dużych kubków", "Brak kubków", JOptionPane.ERROR_MESSAGE);
                        }
                        }else{
                        JOptionPane.showMessageDialog(frame, "Brak Wody", "Brak Wody", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
                
                if(frame.whatItemToBuyBox.getSelectedIndex()==4){
                    if(cupSizeBox.getSelectedIndex() == 0){
                        if(frame.v.getWaterQuantity()>=frame.v.getReqSmallCupWaterQuantity()){
                            if(frame.v.getSmallCupQuantity()>0){
                           if(frame.client.getMoney()>=frame.v.getBiala_kawa().cost()){
                            frame.client.setMoney(frame.client.getMoney()-frame.v.getBiala_kawa().cost());
                            JOptionPane.showMessageDialog(this, "Zakupiłeś właśnie małą Białą kawe,"+frame.v.getBiala_kawa().cost()+"zł zostało zabrane z konta bankowego", "Zakup Udany", JOptionPane.INFORMATION_MESSAGE);
                            frame.v.getBiala_kawa().setQuantity(frame.v.getBiala_kawa().getQuantity()-1);
                            frame.v.setSmallCupQuantity(frame.v.getSmallCupQuantity()-1);
                            frame.v.setWaterQuantity(frame.v.getWaterQuantity()-frame.v.getReqSmallCupWaterQuantity());
                        }else{
                            JOptionPane.showMessageDialog(this, "Nie udało się zakupić produktu, nie masz wystarczających środków", "Zakup nie udany", JOptionPane.ERROR_MESSAGE);
                           }
                        }else{
                            JOptionPane.showMessageDialog(this, "Brak małych kubków", "Brak kubków", JOptionPane.ERROR_MESSAGE);
                        }
                        }else{
                        JOptionPane.showMessageDialog(this, "Brak Wody", "Brak Wody", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    if(cupSizeBox.getSelectedIndex() == 1){
                        if(frame.v.getWaterQuantity()>=frame.v.getReqMediumCupWaterQuantity()){
                            if(frame.v.getMediumCupQuantity()>0){
                           if(frame.client.getMoney()>=frame.v.getBiala_kawa().cost()){
                            frame.client.setMoney(frame.client.getMoney()-frame.v.getBiala_kawa().cost());
                            JOptionPane.showMessageDialog(this, "Zakupiłeś właśnie średnią Białą kawe,"+frame.v.getBiala_kawa().cost()+"zł zostało zabrane z konta bankowego", "Zakup Udany", JOptionPane.INFORMATION_MESSAGE);
                            frame.v.getBiala_kawa().setQuantity(frame.v.getBiala_kawa().getQuantity()-1);
                            frame.v.setMediumCupQuantity(frame.v.getMediumCupQuantity()-1);
                            frame.v.setWaterQuantity(frame.v.getWaterQuantity()-frame.v.getReqMediumCupWaterQuantity());
                        }else{
                            JOptionPane.showMessageDialog(this, "Nie udało się zakupić produktu, nie masz wystarczających środków", "Zakup nie udany", JOptionPane.ERROR_MESSAGE);
                           }
                        }else{
                            JOptionPane.showMessageDialog(this, "Brak średnich kubków", "Brak Kubków", JOptionPane.ERROR_MESSAGE);

                        }
                        }else{
                        JOptionPane.showMessageDialog(this, "Brak Wody", "Brak Wody", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    if(cupSizeBox.getSelectedIndex() == 2){
                        if(frame.v.getWaterQuantity()>=frame.v.getReqBigCupWaterQuantity()){
                            if(frame.v.getBigCupQuantity()>0){
                           if(frame.client.getMoney()>=frame.v.getBiala_kawa().cost()){
                            frame.client.setMoney(frame.client.getMoney()-frame.v.getBiala_kawa().cost());
                            JOptionPane.showMessageDialog(this, "Zakupiłeś właśnie dużą Białą kawe,"+frame.v.getBiala_kawa().cost()+"zł zostało zabrane z konta bankowego", "Zakup Udany", JOptionPane.INFORMATION_MESSAGE);
                            frame.v.getBiala_kawa().setQuantity(frame.v.getBiala_kawa().getQuantity()-1);
                            frame.v.setBigCupQuantity(frame.v.getBigCupQuantity()-1);
                            frame.v.setWaterQuantity(frame.v.getWaterQuantity()-frame.v.getReqBigCupWaterQuantity());}else{
                            JOptionPane.showMessageDialog(this, "Nie udało się zakupić produktu, nie masz wystarczających środków", "Zakup nie udany", JOptionPane.ERROR_MESSAGE);
                           }
                        }else{
                            JOptionPane.showMessageDialog(this, "Brak dużych kubków", "Brak kubków", JOptionPane.ERROR_MESSAGE);
                        }
                        }else{
                        JOptionPane.showMessageDialog(this, "Brak Wody", "Brak Wody", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
                if(frame.whatItemToBuyBox.getSelectedIndex() == 5){
                    if(cupSizeBox.getSelectedIndex() == 0){
                        if(frame.v.getSmallCupQuantity()>0){
                        if(frame.v.getWaterQuantity()>=frame.v.getReqSmallCupWaterQuantity()){
                           if(frame.client.getMoney()>=frame.v.getHerbata().cost()){
                            frame.client.setMoney(frame.client.getMoney()-frame.v.getHerbata().cost());
                            JOptionPane.showMessageDialog(this, "Zakupiłeś właśnie Małą Herbate,"+frame.v.getHerbata().cost()+"zł zostało zabrane z konta bankowego", "Zakup Udany", JOptionPane.INFORMATION_MESSAGE);
                            frame.v.getHerbata().setQuantity(frame.v.getHerbata().getQuantity()-1);
                            frame.v.setSmallCupQuantity(frame.v.getSmallCupQuantity()-1);
                            frame.v.setWaterQuantity(frame.v.getWaterQuantity()-frame.v.getReqSmallCupWaterQuantity());
                        }else{
                            JOptionPane.showMessageDialog(this, "Nie udało się zakupić produktu, nie masz wystarczających środków", "Zakup nie udany", JOptionPane.ERROR_MESSAGE);
                           }
                        }else{
                            JOptionPane.showMessageDialog(this, "Brak małych kubków", "Brak kubków", JOptionPane.ERROR_MESSAGE);
                        }
                        }else{
                        JOptionPane.showMessageDialog(this, "Brak Wody", "Brak Wody", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    if(cupSizeBox.getSelectedIndex() == 1){
                        if(frame.v.getWaterQuantity()>=frame.v.getReqMediumCupWaterQuantity()){
                            if(frame.v.getMediumCupQuantity()>0){
                           if(frame.client.getMoney()>=frame.v.getHerbata().cost()){
                            frame.client.setMoney(frame.client.getMoney()-frame.v.getHerbata().cost());
                            JOptionPane.showMessageDialog(this, "Zakupiłeś właśnie Średnią Herbate,"+frame.v.getHerbata().cost()+"zł zostało zabrane z konta bankowego", "Zakup Udany", JOptionPane.INFORMATION_MESSAGE);
                            frame.v.getHerbata().setQuantity(frame.v.getHerbata().getQuantity()-1);
                            frame.v.setMediumCupQuantity(frame.v.getMediumCupQuantity()-1);
                            frame.v.setWaterQuantity(frame.v.getWaterQuantity()-frame.v.getReqMediumCupWaterQuantity());
                        }else{
                            JOptionPane.showMessageDialog(this, "Nie udało się zakupić produktu, nie masz wystarczających środków", "Zakup nie udany", JOptionPane.ERROR_MESSAGE);
                           }
                        }else{
                            JOptionPane.showMessageDialog(this, "Brak średnich kubków", "Brak kóbków", JOptionPane.ERROR_MESSAGE);
                        }
                        }else{
                        JOptionPane.showMessageDialog(this, "Brak Wody", "Brak Wody", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    if(cupSizeBox.getSelectedIndex() == 2){
                        if(frame.v.getWaterQuantity()>=frame.v.getReqBigCupWaterQuantity()){
                            if(frame.v.getBigCupQuantity()>0){
                           if(frame.client.getMoney()>=frame.v.getHerbata().cost()){
                            frame.client.setMoney(frame.client.getMoney()-frame.v.getHerbata().cost());
                            JOptionPane.showMessageDialog(this, "Zakupiłeś właśnie Dużą Herbate,"+frame.v.getHerbata().cost()+"zł zostało zabrane z konta bankowego", "Zakup Udany", JOptionPane.INFORMATION_MESSAGE);
                            frame.v.getHerbata().setQuantity(frame.v.getHerbata().getQuantity()-1);
                            frame.v.setBigCupQuantity(frame.v.getBigCupQuantity()-1);
                            frame.v.setWaterQuantity(frame.v.getWaterQuantity()-frame.v.getReqBigCupWaterQuantity());
                        }else{
                            JOptionPane.showMessageDialog(this, "Nie udało się zakupić produktu, nie masz wystarczających środków", "Zakup nie udany", JOptionPane.ERROR_MESSAGE);
                           }
                        }else{
                            JOptionPane.showMessageDialog(this, "Brak Dużych kubków", "Brak kubków", JOptionPane.ERROR_MESSAGE);
                        }
                        }else{
                        JOptionPane.showMessageDialog(this, "Brak Wody", "Brak Wody", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
                }
            

        
    }

    

