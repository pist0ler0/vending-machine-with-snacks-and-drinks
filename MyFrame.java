import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyFrame extends JFrame implements ActionListener{
     
    private JButton serviceButton;
    private JButton clientButton;
    private JButton exitButton;
    private Person person;
    public MyFrame getMyFrame(){
        return this;
    }
    public MyFrame(){
        super("nie umiem");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null);
        setTitle("Vending Machine Simulator");
        setResizable(false);
        setLayout(new GridLayout(8, 2, 20, 20));
        add(new JLabel());
        add(new JLabel());
        add(new JLabel());
        serviceButton = new JButton("Pracownik Serwisu");
        clientButton = new JButton("Klient");
        clientButton.addActionListener(this);
        serviceButton.addActionListener(this);
        add(serviceButton);
        add(clientButton);
        exitButton = new JButton("Zamknij");
        exitButton.addActionListener(this);
        add(new JLabel());
        add(exitButton);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == clientButton){
            dispose();  
            person = new Client(100);
        }
        if(e.getSource() == serviceButton){
            setVisible(false);
            PinFrame frame = new PinFrame(this);
        }
        if(e.getSource() == exitButton){
            dispose();
        }
    }

}
