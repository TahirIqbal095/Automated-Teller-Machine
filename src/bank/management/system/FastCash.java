package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.ResultSet;

public class FastCash extends JFrame implements ActionListener {
    JButton back, rs100, rs500, rs2000, rs1000, rs5000, rs10000;
    String pinNum;
    public FastCash(String pinNum) {
        this.pinNum = pinNum;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 700);
        add(image);

        JLabel heading = new JLabel("Select withdrawal amount");
        heading.setBounds(210, 225, 250, 40);
        heading.setFont(new Font("Ariel", Font.BOLD, 14));
        heading.setForeground(Color.white);
        image.add(heading);

        rs100 = new JButton("Rs 100");
        rs100.setBounds(145, 325, 150, 22);
        rs100.addActionListener(this);
        image.add(rs100);

        rs500 = new JButton("Rs 500");
        rs500.setBounds(305, 325, 150, 22);
        rs500.addActionListener(this);
        image.add(rs500);

        rs1000 = new JButton("Rs 1000");
        rs1000.setBounds(145, 350, 150, 22);
        rs1000.addActionListener(this);
        image.add(rs1000);

        rs2000 = new JButton("Rs 2000");
        rs2000.setBounds(305, 350, 150, 22);
        rs2000.addActionListener(this);
        image.add(rs2000);

        rs5000 = new JButton("Rs 5000");
        rs5000.setBounds(145, 375, 150, 22);
        rs5000.addActionListener(this);
        image.add(rs5000);

        rs10000 = new JButton("Rs 10,000");
        rs10000.setBounds(305, 375, 150, 22);
        rs10000.addActionListener(this);
        image.add(rs10000);

        back = new JButton("Back");
        back.setBounds(305, 400, 150, 22);
        back.addActionListener(this);
        image.add(back);

        setSize(800, 700);
        setUndecorated(true);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == back) {
            setVisible(false);
            new Transaction(pinNum).setVisible(true);
        }
        else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinNum+"'");
                int balance = 0;
                while(rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    }
                    else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if (ae.getSource() != back && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient balance");
                    return;
                }
                Date date = new Date();
                String query = "insert into bank values ('"+pinNum+"', '"+date+"', '"+amount+"', 'Withdrawal')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs " + amount + " debited successfully");
                setVisible(false);
                new Transaction(pinNum).setVisible(true);
            }
            catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
