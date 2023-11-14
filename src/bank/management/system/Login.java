package bank.management.system;

import javax.swing.*;

public class Login extends JFrame {

    Login() {
        setTitle("Automated teller machine");
        setSize(800, 400);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        JLabel label = new JLabel(img1);
        add(label);
    }


    public static void main(String[] args) {

        new Login();
    }
}
