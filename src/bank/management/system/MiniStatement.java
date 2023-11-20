package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame {
    String pinNum;
    public MiniStatement(String pinNum) {
        this.pinNum = pinNum;

        setLayout(null);
        JLabel text = new JLabel("Indian Bank");
        text.setBounds(150, 20, 250, 30);
        text.setFont(new Font("Ariel", Font.BOLD, 16));
        add(text);

        JLabel accNum = new JLabel();
        accNum.setBounds(80, 80, 250, 30);
        add(accNum);

        JLabel bankDetails = new JLabel();
        bankDetails.setBounds(80, 120, 250, 150);
        add(bankDetails);

        JLabel balance = new JLabel();
        balance.setBounds(80, 250, 200, 50);
        add(balance);

        try {
            String query = "select * from login where pin = '"+pinNum+"'";
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                accNum.setText("Account Number : " + rs.getString("account_number").substring(0, 2) + "XXXXXXXXXX" + rs.getString("account_number").substring(12));
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }

        try {
            int bal = 0;
            String query = "select * from bank where pin = '"+pinNum+"'";
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                }
                else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
                balance.setText("Your current Balance is : " + bal);
                bankDetails.setText(bankDetails.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
            }
        }
        catch (Exception e){
            System.out.println(e);
        }

        setSize(500, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MiniStatement("");
    }
}
