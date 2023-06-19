
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class VendingMachineServiceFrame extends JFrame implements ActionListener{
    VendingMachineFrame frame;
    Serviceman serviceman;
    VendingMachine v;
    JButton refillProduct;
    JButton goToMyFrameServiceButton;
    JLabel welcomeServicemanJLabel;
    JButton refillWaterButton;
    JButton repairButton;
    JButton exitButton;

    public VendingMachineServiceFrame(Serviceman serviceman){
        super("Panel Serwisanta");
        this.frame = VendingMachineFrame.getInstance();
        v = VendingMachine.getInstance(this.frame);
        this.serviceman = serviceman;
        setSize(800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new GridLayout(10, 2, 10, 10));
        refillProduct = new JButton("Uzupełnij produkt");
        refillProduct.addActionListener(new RefillProductActionListener(this));
        repairButton = new JButton("Napraw Maszyne");
        repairButton.addActionListener(this);
        exitButton = new JButton("Wyjdź");
        exitButton.addActionListener(this);
        goToMyFrameServiceButton = new JButton("Powrót");
        goToMyFrameServiceButton.addActionListener(this);
        add(new JLabel("Witaj Serwisancie"));
        add(new JLabel());
        add(repairButton);
        add(refillProduct);
        add(goToMyFrameServiceButton);
        add(exitButton);


        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == goToMyFrameServiceButton){
            dispose();
            new MyFrame();
        }else if(e.getSource() == exitButton){
            dispose();
        }else if(e.getSource() == repairButton){
            JOptionPane.showMessageDialog(this,"Maszyna Naprawiona", "Naprawianie", JOptionPane.INFORMATION_MESSAGE);
            frame.brokenBalanceLabel.setText(null);
            frame.brokenBuyJLabel.setText(null);
            frame.buyButton.setEnabled(true);
            frame.checkBalanceButton.setEnabled(true);

        }
    }
    
}
