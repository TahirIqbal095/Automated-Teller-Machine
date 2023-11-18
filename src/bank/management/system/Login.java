package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JButton login, clear, signup;
    JTextField textFieldCard;
    JPasswordField textFieldPin;
    Login() {
        setTitle("Automated teller machine");

        // setting up the logo
        setLayout(null);
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image img2 = img1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel label = new JLabel(img3);
        label.setBounds(60, 20, 100, 100);
        add(label);

        // changing the background color of a frame
        getContentPane().setBackground(Color.white);

        // adding text to the frame
        JLabel heading = new JLabel("Welcome to the ATM");
        heading.setBounds(200, 30, 400, 40);
        heading.setFont(new Font("Osward", Font.BOLD, 38));
        add(heading);

        JLabel cardNum = new JLabel("Card No : ");
        cardNum.setBounds(120, 150, 200, 40);
        cardNum.setFont(new Font("Raleway", Font.BOLD, 24));
        add(cardNum);

        textFieldCard = new JTextField(); // input text field
        textFieldCard.setBounds(240, 160, 200, 25);
        textFieldCard.setFont(new Font("Ariel", Font.BOLD, 14));
        add(textFieldCard);

        JLabel pin = new JLabel("Pin : ");
        pin.setBounds(120, 220, 80, 40);
        pin.setFont(new Font("Raleway", Font.BOLD, 24));
        add(pin);

        textFieldPin = new JPasswordField(); // input password field
        textFieldPin.setBounds(240, 235, 200, 25);
        textFieldPin.setFont(new Font("Ariel", Font.BOLD, 14));
        add(textFieldPin);

        // buttons
        login = new JButton("Sign in");
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.setBounds(240, 300, 90, 30);
        add(login);
        login.addActionListener(this);

        clear = new JButton("Clear");
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.setBounds(342, 300, 90, 30);
        add(clear);
        clear.addActionListener(this);

        signup = new JButton("Sign up");
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.setBounds(240, 350, 200, 30);
        add(signup);
        signup.addActionListener(this);


        setSize(800, 500);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String accNum = textFieldCard.getText();
        String pinNum = textFieldPin.getText();
        if (ae.getSource() == clear) {
            textFieldCard.setText("");
            textFieldPin.setText("");
        } else if (ae.getSource() == login) {
            if(accNum.isEmpty() || pinNum.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter both account and pin number");
            }
            else {
                Conn c = new Conn();
                String query = "select * from login where account_number = " + accNum + " and pin = " + pinNum;

                try {
                    ResultSet rs = c.s.executeQuery(query);
                    if(rs.next()) {
                        setVisible(false);
                        new Transaction(pinNum).setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "User doesn't exit");
                    }

                } catch (Exception e) {
                    System.out.println(e);
                }
            }

        } else if (ae.getSource() == signup) {
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }

    public static void main(String[] args) {

        new Login();
    }

}
