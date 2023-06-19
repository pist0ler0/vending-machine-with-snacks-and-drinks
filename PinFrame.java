import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class PinFrame extends JFrame implements ActionListener{
    JFrame popup;
    Serviceman serviceman;
    JTextField pinJTF;
    JButton enterButton;
    MyFrame frame;
    JButton goBackButton;
    VendingMachineFrame vendingMachineFrame;

    private int n = 0;

    public PinFrame(MyFrame frame){
            this.frame = frame;
            goBackButton = new JButton("Cofnij");
            goBackButton.addActionListener(this);
            enterButton = new JButton("Enter");
            popup = new JFrame("Popup");
            serviceman = new Serviceman();
            popup.setSize(300, 300);
            popup.setLocationRelativeTo(null);
            popup.setDefaultCloseOperation(EXIT_ON_CLOSE);
            popup.setVisible(true);
            popup.setLayout(new GridLayout(8, 1, 10, 10));
            popup.add(new JLabel());
            popup.add(new JLabel());
            popup.add(new JLabel());
            popup.add(new JLabel("Podaj pin"));
            pinJTF = new JTextField();
            popup.add(pinJTF);
            popup.add(enterButton);
            popup.add(new JLabel());
            popup.add(goBackButton);
            enterButton.addActionListener(this);
    }
    public PinFrame(MyFrame frame, VendingMachineFrame vendingMachineFrame){
            this.frame = frame;
            this.vendingMachineFrame = vendingMachineFrame;
            goBackButton = new JButton("Cofnij");
            goBackButton.addActionListener(this);
            enterButton = new JButton("Enter");
            popup = new JFrame("Popup");
            serviceman = new Serviceman();
            popup.setSize(300, 300);
            popup.setLocationRelativeTo(null);
            popup.setDefaultCloseOperation(EXIT_ON_CLOSE);
            popup.setVisible(true);
            popup.setLayout(new GridLayout(8, 1, 10, 10));
            popup.add(new JLabel());
            popup.add(new JLabel());
            popup.add(new JLabel());
            popup.add(new JLabel("Podaj pin"));
            pinJTF = new JTextField();
            popup.add(pinJTF);
            popup.add(enterButton);
            popup.add(new JLabel());
            popup.add(goBackButton);
            enterButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == enterButton){
        try{
           if(Integer.parseInt(pinJTF.getText()) == serviceman.getPin()){
               popup.dispose();
               serviceman = new Serviceman();
               new VendingMachineServiceFrame(serviceman);
               frame.dispose();
               n=0;
           }else{
               n = n + 1;
               if(n<3){
               JOptionPane.showMessageDialog(this, "Podałeś zły pin!", "Zły pin", JOptionPane.ERROR_MESSAGE);

               }
               else{
                   popup.dispose();
                   frame.dispose();
               }
            }}catch(Exception a){
                JOptionPane.showMessageDialog(this, "Wystąpił błąd", "Wystąpił błąd", JOptionPane.ERROR_MESSAGE);
        }
    }
    if(e.getSource() == goBackButton){
        n=0;
        frame.setVisible(true);
        popup.dispose();
    }
}
    
}
