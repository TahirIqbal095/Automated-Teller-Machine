package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    JTextField amount;
    JButton deposit, back;
    String pinNum;
    public Deposit(String pinNum) {

        this.pinNum = pinNum;

        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 700);
        add(image);

        JLabel text = new JLabel("Enter the amount you want deposit");
        text.setBounds(180, 250, 250, 40);
        text.setForeground(Color.white);
        text.setFont(new Font("Ariel", Font.BOLD, 14));
        image.add(text);

        amount = new JTextField();
        amount.setBounds(180, 290, 200, 20);
        amount.setFont(new Font("Ariel", Font.BOLD, 12));
        image.add(amount);

        deposit = new JButton("Deposit");
        deposit.setBounds(180, 320, 100, 20);
        deposit.addActionListener(this);
        image.add(deposit);

        back = new JButton("Back");
        back.setBounds(180, 350, 100, 20);
        deposit.addActionListener(this);
        image.add(back);

        setSize(800, 700);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed (ActionEvent ae) {
        if(ae.getSource() == deposit) {
            String totalAmount = amount.getText();
            Date date = new Date();
            try {
                if(totalAmount.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the amount");
                } else {
                    Conn c = new Conn();
                    String query = "insert into bank values ('"+ pinNum+"', '"+ date+"', '"+totalAmount+"', 'Deposit')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Your amount " + totalAmount + " deposited successfully");
                    setVisible(false);
                    new Transaction(pinNum).setVisible(true);
                }
            }
            catch(Exception e) {
                System.out.println(e);
            }

        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transaction(pinNum).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Deposit("");
    }
}
