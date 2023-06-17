import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyFrame extends JFrame implements ActionListener{
    private JFrame ramka;
    private JButton serviceButton;
    private JButton clientButton;
    private JButton exitButton;
    private Client client;
    public MyFrame(){
        ramka = new JFrame();
        ramka.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ramka.setSize(800, 800);
        ramka.setLocationRelativeTo(null);
        ramka.setTitle("Vending Machine Simulator");
        ramka.setResizable(false);
        ramka.setLayout(new GridLayout(8, 2, 20, 20));
        ramka.add(new JLabel());
        ramka.add(new JLabel());
        ramka.add(new JLabel());
        serviceButton = new JButton("Pracownik Serwisu");
        clientButton = new JButton("Klient");
        clientButton.addActionListener(this);
        serviceButton.addActionListener(this);
        ramka.add(serviceButton);
        ramka.add(clientButton);
        exitButton = new JButton("Zamknij");
        exitButton.addActionListener(this);
        ramka.add(new JLabel());
        ramka.add(exitButton);
        ramka.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == clientButton){
            ramka.dispose();  
            client = new Client(100);
            VendingMachineFrame v = new VendingMachineFrame(client);
        }
        if(e.getSource() == serviceButton){
            ramka.setVisible(false);
            PinFrame frame = new PinFrame(this);
        }
        if(e.getSource() == exitButton){
            ramka.dispose();
        }
    }

}
