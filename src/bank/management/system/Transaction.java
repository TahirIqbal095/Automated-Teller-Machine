package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction extends JFrame implements ActionListener {
    JButton exit, deposit, withdrawal, miniS, fastCash, pinChange, balance;
    String pinNum;
    public Transaction(String pinNum) {
        this.pinNum = pinNum;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 700);
        add(image);

        JLabel heading = new JLabel("Please select your transaction");
        heading.setBounds(210, 225, 250, 40);
        heading.setFont(new Font("Ariel", Font.BOLD, 14));
        heading.setForeground(Color.white);
        image.add(heading);

        deposit = new JButton("Deposit");
        deposit.setBounds(145, 325, 150, 22);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawal = new JButton("Cash Withdrawal");
        withdrawal.setBounds(305, 325, 150, 22);
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(145, 350, 150, 22);
        fastCash.addActionListener(this);
        image.add(fastCash);

        miniS = new JButton("Mini Statement");
        miniS.setBounds(305, 350, 150, 22);
        miniS.addActionListener(this);
        image.add(miniS);

        pinChange = new JButton("Pin Change");
        pinChange.setBounds(145, 375, 150, 22);
        pinChange.addActionListener(this);
        image.add(pinChange);

        balance = new JButton("Check Balance");
        balance.setBounds(305, 375, 150, 22);
        balance.addActionListener(this);
        image.add(balance);

        exit = new JButton("Exit");
        exit.setBounds(305, 400, 150, 22);
        exit.addActionListener(this);
        image.add(exit);

        setSize(800, 700);
        setUndecorated(true);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(pinNum).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Transaction("");
    }
}

