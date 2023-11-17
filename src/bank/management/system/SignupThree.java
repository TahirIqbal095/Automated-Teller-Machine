package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Map;

public class SignupThree extends JFrame implements ActionListener {
    JRadioButton saving, current, fixed, recurring;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formno;
    public SignupThree(String formno) {

        this.formno = formno;
        setLayout(null);

        JLabel heading = new JLabel("Page 3 : Account Details");
        heading.setBounds(150, 40, 400, 40);
        heading.setFont(new Font("Ariel", Font.BOLD, 32));
        add(heading);

        JLabel type = new JLabel("Account type :");
        type.setBounds(70, 120, 200, 40);
        type.setFont(new Font("Ariel", Font.BOLD, 16));
        add(type);
        saving = new JRadioButton("Saving Account");
        saving.setBounds(240, 120, 160, 30);
        saving.setFont(new Font("Ariel", Font.BOLD, 14));
        saving.setBackground(Color.white);
        add(saving);
        current = new JRadioButton("Current Account");
        current.setBounds(400, 120, 160, 30);
        current.setFont(new Font("Ariel", Font.BOLD, 14));
        current.setBackground(Color.white);
        add(current);
        fixed = new JRadioButton("Fixed Account");
        fixed.setBounds(240, 160, 160, 30);
        fixed.setFont(new Font("Ariel", Font.BOLD, 14));
        fixed.setBackground(Color.white);
        add(fixed);
        recurring = new JRadioButton("Recurring Account");
        recurring.setBounds(400, 160, 160, 30);
        recurring.setFont(new Font("Ariel", Font.BOLD, 14));
        recurring.setBackground(Color.white);
        add(recurring);
        ButtonGroup accGroup = new ButtonGroup();
        accGroup.add(saving);
        accGroup.add(current);
        accGroup.add(fixed);
        accGroup.add(recurring);

        JLabel card = new JLabel("Card Number :");
        card.setBounds(70, 210, 250, 40);
        card.setFont(new Font("Ariel", Font.BOLD, 16));
        add(card);
        JLabel cardDetails = new JLabel("Your 16-digit account number");
        cardDetails.setFont(new Font("Ariel", Font.PLAIN, 12));
        cardDetails.setBounds(70, 240, 250, 20);
        add(cardDetails);
        JLabel cardNo = new JLabel("XXXX-XXXX-XXXX-2478");
        cardNo.setBounds(240, 210, 250, 40);
        cardNo.setFont(new Font("Ariel", Font.BOLD, 16));
        add(cardNo);

        JLabel pinText = new JLabel("Pin Number :");
        pinText.setBounds(70, 260, 250, 40);
        pinText.setFont(new Font("Ariel", Font.BOLD, 16));
        add(pinText);
        JLabel pindetails = new JLabel("Your 4-digit pin");
        pindetails.setFont(new Font("Ariel", Font.PLAIN, 12));
        pindetails.setBounds(70, 290, 21500, 20);
        add(pindetails);
        JLabel pinNo = new JLabel("XXXX");
        pinNo.setBounds(240, 260, 250, 40);
        pinNo.setFont(new Font("Ariel", Font.BOLD, 16));
        add(pinNo);

        JLabel services = new JLabel("Services required :");
        services.setBounds(70, 310, 250, 40);
        services.setFont(new Font("Ariel", Font.BOLD, 16));
        add(services);
        c1 = new JCheckBox("ATM Card");
        c1.setFont(new Font("Ariel", Font.BOLD, 14));
        c1.setBounds(240, 310, 150, 30);
        c1.setBackground(Color.white);
        add(c1);
        c2 = new JCheckBox("Internet Banking");
        c2.setFont(new Font("Ariel", Font.BOLD, 14));
        c2.setBounds(400, 310, 150, 30);
        c2.setBackground(Color.white);
        add(c2);
        c3 = new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Ariel", Font.BOLD, 14));
        c3.setBounds(240, 350, 150, 30);
        c3.setBackground(Color.white);
        add(c3);
        c4 = new JCheckBox("SMS Alert");
        c4.setFont(new Font("Ariel", Font.BOLD, 14));
        c4.setBounds(400, 350, 150, 30);
        c4.setBackground(Color.white);
        add(c4);
        c5 = new JCheckBox("Cheque book");
        c5.setFont(new Font("Ariel", Font.BOLD, 14));
        c5.setBounds(240, 390, 150, 30);
        c5.setBackground(Color.white);
        add(c5);
        c6 = new JCheckBox("E-Statement");
        c6.setFont(new Font("Ariel", Font.BOLD, 14));
        c6.setBounds(400, 390, 150, 30);
        c6.setBackground(Color.white);
        add(c6);
        c7 = new JCheckBox("I here by declare that the above given information is correct to the best of my knowledge");
        c7.setFont(new Font("Ariel", Font.PLAIN, 12));
        c7.setBounds(240, 440, 550, 30);
        c7.setBackground(Color.white);
        add(c7);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setBounds(350, 500, 150, 40);
        cancel.setFont(new Font("Ariel", Font.BOLD, 16));
        cancel.addActionListener(this);
        add(cancel);

        submit = new JButton("Submit");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setBounds(550, 500, 150, 40);
        submit.setFont(new Font("Ariel", Font.BOLD, 16));
        submit.addActionListener(this);
        add(submit);

        getContentPane().setBackground(Color.white);
        setSize(800, 800);
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("Account details");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == submit) {
            String accountType = null;
            if(saving.isSelected()) {
                accountType = "Saving";
            } else if(current.isSelected()) {
                accountType = "Current";
            } else if(fixed.isSelected()) {
                accountType = "Fixed";
            } else if(recurring.isSelected()) {
                accountType = "Recurring";
            }

            String cardNumber = "078104100000" + (int)((Math.random() * 9999) + 1000);
            String pinNumber = "" + (int)((Math.random() * 9999) + 1000);

            String facility = "";
            if(c1.isSelected()) {
                facility += "Atm card";
            } else if(c2.isSelected()) {
                facility += " Internet banking";
            } else if(c3.isSelected()) {
                facility += " Mobile banking";
            } else if(c4.isSelected()) {
                facility += " SMS Alert";
            } else if(c5.isSelected()) {
                facility += " Cheque book";
            } else if(c6.isSelected()) {
                facility += " E-Statement";
            }

            try {
                if(accountType == "") {
                    JOptionPane.showMessageDialog(null, "Account type is required");
                } else {
                    Conn c = new Conn();
                    String query1 = "insert into signupthree values ('"+formno+"', '"+accountType+"', '"+cardNumber+"', '"+pinNumber+"', '"+facility+"')";
                    String query2 = "insert into login values ('"+cardNumber+"', '"+pinNumber+"')";
                    JOptionPane.showMessageDialog(null, "Account Number: " + cardNumber + "\nPin: " + pinNumber);
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                }

            } catch (Exception e){
                System.out.println(e);
            }

        } else if(ae.getSource() == cancel) {

        }
    }
    public static void main(String[] args) {
        new SignupThree("");
    }
}
