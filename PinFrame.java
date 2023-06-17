import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//TODO naprawic to ze sie nie disposuje MyFrame przekazany 

public class PinFrame extends JFrame implements ActionListener{
    JFrame popup;
    Serviceman serviceman;
    JTextField pinJTF;
    JButton enterButton;
    MyFrame frame;
    private int n = 0;

    public PinFrame(MyFrame frame){
        this.frame = frame;
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
            enterButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
        if(Integer.parseInt(pinJTF.getText()) == serviceman.getPin()){
            popup.dispose();
            serviceman = new Serviceman();
            VendingMachineFrame v = new VendingMachineFrame(serviceman);
            frame.dispose();
            n=0;
        }else{
            n = n + 1;
            if(n<3){
            JFrame wrongpsswd = new JFrame("Zły pin!!");
            wrongpsswd.add(new JLabel("Złe hasło"));
            wrongpsswd.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            wrongpsswd.setSize(100, 100);
            wrongpsswd.setLocationRelativeTo(null);
            wrongpsswd.setVisible(true);
            }
            else{
                popup.dispose();
                frame.dispose();
            }
        }}catch(Exception a){
            JFrame wrong = new JFrame("Błąd");
            wrong.setSize(200, 200);
            wrong.add(new JLabel("Wystąpił błąd"));
            wrong.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            wrong.setVisible(true);
        }
    }
    
}
