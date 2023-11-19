package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CheckBalance extends JFrame implements ActionListener {
    String pinNum;
    JButton back;
    public CheckBalance(String pinNum) {
        this.pinNum = pinNum;

        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 700);
        add(image);

        String query = "select * from bank where pin = '"+pinNum+"'";
        Conn c = new Conn();
        int balance = 0;
        try {
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                if(rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                }
                else if(rs.getString("type").equals("Withdrawal")) {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }

        JLabel text = new JLabel("Your balance is : " + balance);
        text.setBounds(180, 230, 200, 30);
        text.setFont(new Font("Ariel", Font.BOLD, 16));
        text.setForeground(Color.white);
        image.add(text);

        back = new JButton("Back");
        back.setBounds(350, 400, 80, 20);
        back.addActionListener(this);
        add(back);

        setSize(800, 700);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == back) {
            setVisible(false);
            new Transaction(pinNum).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new CheckBalance("");
    }
}
