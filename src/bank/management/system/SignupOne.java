package bank.management.system;

import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;


public class SignupOne extends JFrame {
    public SignupOne() {

        setTitle("Sign up Form");
        setSize(700, 800);
        setLayout(null);


        int randomNum = (int)((Math.random() * 10000 ) + 1001);
        JLabel heading = new JLabel("Application Form number : " + randomNum);
        heading.setBounds(120, 40, 500, 40);
        heading.setFont(new Font("Ariel", Font.BOLD, 28));
        add(heading);

        JLabel personalDet = new JLabel("Page 1 : Personal details");
        personalDet.setBounds(220, 100, 400, 40);
        personalDet.setFont(new Font("Ariel", Font.BOLD, 18));
        add(personalDet);

        JLabel name = new JLabel("Name :");
        name.setBounds(120, 150, 100, 40);
        name.setFont(new Font("Ariel", Font.BOLD, 16));
        add(name);
        JTextField nameTextField = new JTextField();
        nameTextField.setFont(new Font("Ariel", Font.BOLD, 12));
        nameTextField.setBounds(300, 150, 300, 30);
        add(nameTextField);

        JLabel fname = new JLabel("Father's Name :");
        fname.setBounds(120, 190, 150, 40);
        fname.setFont(new Font("Ariel", Font.BOLD, 16));
        add(fname);
        JTextField fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Ariel", Font.BOLD, 12));
        fnameTextField.setBounds(300, 190, 300, 30);
        add(fnameTextField);

        JLabel dob = new JLabel("Date of birth :");
        dob.setBounds(120, 230, 150, 40);
        dob.setFont(new Font("Ariel", Font.BOLD, 16));
        add(dob);
        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 230, 300, 30);
        dateChooser.setForeground(new Color(32, 123, 34));
        add(dateChooser);

        JLabel gender = new JLabel("Gender :");
        gender.setBounds(120, 270, 150, 40);
        gender.setFont(new Font("Ariel", Font.BOLD, 16));
        add(gender);
        JRadioButton male = new JRadioButton("Male");
        male.setBounds(300, 270, 100, 30);
        male.setBackground(Color.white);
        add(male);
        JRadioButton female = new JRadioButton("Female");
        female.setBounds(420, 270, 100, 30);
        female.setBackground(Color.white);
        add(female);
        // make sure that only one gender is selected
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel email = new JLabel("Email :");
        email.setBounds(120, 310, 150, 40);
        email.setFont(new Font("Ariel", Font.BOLD, 16));
        add(email);
        JTextField emailTextField = new JTextField();
        emailTextField.setFont(new Font("Ariel", Font.BOLD, 12));
        emailTextField.setBounds(300, 310, 300, 30);
        add(emailTextField);

        JLabel marital = new JLabel("Marital Status :");
        marital.setBounds(120, 350, 150, 40);
        marital.setFont(new Font("Ariel", Font.BOLD, 16));
        add(marital);
        JRadioButton married = new JRadioButton("Married");
        married.setBounds(300, 350, 100, 30);
        married.setBackground(Color.white);
        add(married);
        JRadioButton unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(400, 350, 100, 30);
        unmarried.setBackground(Color.white);
        add(unmarried);
        JRadioButton other = new JRadioButton("Other");
        other.setBounds(520, 350, 100, 30);
        other.setBackground(Color.white);
        add(other);
        // make sure that only yes or no is selected
        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(other);

        JLabel address = new JLabel("Address :");
        address.setBounds(120, 390, 150, 40);
        address.setFont(new Font("Ariel", Font.BOLD, 16));
        add(address);
        JTextField addressTextField = new JTextField();
        addressTextField.setFont(new Font("Ariel", Font.BOLD, 12));
        addressTextField.setBounds(300, 390, 300, 30);
        add(addressTextField);

        JLabel city = new JLabel("City :");
        city.setBounds(120, 430, 150, 40);
        city.setFont(new Font("Ariel", Font.BOLD, 16));
        add(city);
        JTextField cityTextField = new JTextField();
        cityTextField.setFont(new Font("Ariel", Font.BOLD, 12));
        cityTextField.setBounds(300, 430, 300, 30);
        add(cityTextField);

        JLabel state = new JLabel("State :");
        state.setBounds(120, 470, 150, 40);
        state.setFont(new Font("Ariel", Font.BOLD, 16));
        add(state);
        JTextField stateTextField = new JTextField();
        stateTextField.setFont(new Font("Ariel", Font.BOLD, 12));
        stateTextField.setBounds(300, 470, 300, 30);
        add(stateTextField);

        JLabel pincode = new JLabel("Pin code :");
        pincode.setBounds(120, 510, 150, 40);
        pincode.setFont(new Font("Ariel", Font.BOLD, 16));
        add(pincode);
        JTextField pinTextField = new JTextField();
        pinTextField.setFont(new Font("Ariel", Font.BOLD, 12));
        pinTextField.setBounds(300, 510, 300, 30);
        add(pinTextField);

        JButton button = new JButton("Next");
        button.setBounds(500, 600, 100, 30);
        button.setBackground(Color.black);
        button.setForeground(Color.white);
        add(button);

        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(Color.white);

    }
    public static void main(String[] args) {
        new SignupOne();
    }
}
