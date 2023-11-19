package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {
    JPasswordField pinText, pin2Text;
    JButton change, back;
    String pinNum;
    public PinChange(String pinNum) {
        this.pinNum = pinNum;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 700);
        add(image);

        JLabel text = new JLabel("Change you pin");
        text.setBounds(250, 210, 150, 40);
        text.setForeground(Color.white);
        text.setFont(new Font("Ariel", Font.BOLD, 16));
        image.add(text);

        JLabel pin = new JLabel("Enter new pin");
        pin.setBounds(150, 270, 150, 30);
        pin.setForeground(Color.white);
        pin.setFont(new Font("Ariel", Font.BOLD, 12));
        image.add(pin);
        pinText = new JPasswordField();
        pinText.setBounds(270, 270, 180, 20);
        add(pinText);

        JLabel pin2 = new JLabel("Re-Enter new pin");
        pin2.setBounds(150, 310, 150, 30);
        pin2.setForeground(Color.white);
        pin2.setFont(new Font("Ariel", Font.BOLD, 12));
        image.add(pin2);
        pin2Text = new JPasswordField();
        pin2Text.setBounds(270, 310, 180, 20);
        image.add(pin2Text);

        change = new JButton("Change");
        change.setBounds(375, 400, 80, 20);
        change.addActionListener(this);
        image.add(change);
        back = new JButton("Back");
        back.setBounds(280, 400, 80, 20);
        back.addActionListener(this);
        image.add(back);

        setSize(800, 700);
        setLocationRelativeTo(null);
        setResizable(false);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String pin1 = pinText.getText();
        String pin = pin2Text.getText();
        if(ae.getSource() == back) {
            setVisible(false);
            new Transaction(pinNum).setVisible(true);
        }
        else if(ae.getSource() == change) {
            try {
                if(pin.equals(pin1)) {
                String query1 = "update login set pin = '"+pin+"' where pin = '"+pinNum+"'";
                String query2 = "update signupthree set pin_number = '"+pin+"' where pin_number = '"+pinNum+"'";
                Conn c = new Conn();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "Pin has been changed");
                setVisible(false);
                new Transaction(pin).setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Pin doesn't match\nTry Again");
                }
            }
            catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    public static void main(String[] args) {
        new PinChange("");
    }
}
