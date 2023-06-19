import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class RefillProductActionListener implements ActionListener {
    VendingMachineServiceFrame frame;

    RefillProductActionListener(VendingMachineServiceFrame frame) {
        this.frame = frame;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object[] possibleValues = {
                "Pepsi", "CocaCola", "Fanta", "Czarna kawa", "Biała kawa", "Herbata", "Chipsy Lays", "Żelki Gumisie",
                "Paluszki Krakuski", "Woda", "Cukier", "Małe Kubki", "Średnie Kubki", "Duże Kubki"
        };
        Object selectedValue = JOptionPane.showInputDialog(null,
                "Wybierz Produkt który chcesz uzupełnić", "Refilling",
                JOptionPane.INFORMATION_MESSAGE, null,
                possibleValues, possibleValues[0]);
        try {

            if (selectedValue.toString().equals("Pepsi")) {
                frame.serviceman.addPepsi(frame.v);
            } else if (selectedValue.toString().equals("CocaCola")) {
                frame.serviceman.addCocaCola(frame.v);
            } else if (selectedValue.toString().equals("Fanta")) {
                frame.serviceman.addFanta(frame.v);
            } else if (selectedValue.toString().equals("Czarna kawa")) {
                frame.serviceman.addBlackCoffee(frame.v);
            } else if (selectedValue.toString().equals("Biała kawa")) {
                frame.serviceman.addWhiteCoffee(frame.v);
            } else if (selectedValue.toString().equals("Herbata")) {
                frame.serviceman.addTea(frame.v);
            } else if (selectedValue.toString().equals("Chipsy Lays")) {
                frame.serviceman.addLays(frame.v);
            } else if (selectedValue.toString().equals("Żelki Gumisie")) {
                frame.serviceman.addZelki(frame.v);
            } else if (selectedValue.toString().equals("Paluszki Krakuski")) {
                frame.serviceman.addPaluszki(frame.v);
            } else if (selectedValue.toString().equals("Woda")) {
                frame.serviceman.refillWater(frame.v);
            } else if (selectedValue.toString().equals("Cukier")) {
                frame.serviceman.addSugar(frame.v);
            } else if (selectedValue.toString().equals("Małe Kubki")) {
                frame.serviceman.addSmallCup(frame.v);
            } else if (selectedValue.toString().equals("Średnie Kubki")) {
                frame.serviceman.addMediumCup(frame.v);
            } else if (selectedValue.toString().equals("Duże Kubki")) {
                frame.serviceman.addBigCup(frame.v);
            }

        } catch (Exception a) {
            JOptionPane.showMessageDialog(frame, "Wystąpił błąd", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
