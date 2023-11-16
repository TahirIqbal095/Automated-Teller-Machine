package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import com.toedter.calendar.JDateChooser;


public class SignupOne extends JFrame implements ActionListener {

    int randomNum;
    JTextField nameTextField, fnameTextField, emailTextField, addressTextField, cityTextField, stateTextField, pinTextField;
    JDateChooser dateChooser;
    JButton next;
    JRadioButton male, female, married, unmarried, other;
    public SignupOne() {

        setTitle("Page 1 : Sign up Form");
        setSize(700, 800);
        setLayout(null);


        randomNum = (int)((Math.random() * 10000 ) + 1001);

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
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Ariel", Font.BOLD, 12));
        nameTextField.setBounds(300, 150, 300, 30);
        add(nameTextField);

        JLabel fname = new JLabel("Father's Name :");
        fname.setBounds(120, 190, 150, 40);
        fname.setFont(new Font("Ariel", Font.BOLD, 16));
        add(fname);
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Ariel", Font.BOLD, 12));
        fnameTextField.setBounds(300, 190, 300, 30);
        add(fnameTextField);

        JLabel dob = new JLabel("Date of birth :");
        dob.setBounds(120, 230, 150, 40);
        dob.setFont(new Font("Ariel", Font.BOLD, 16));
        add(dob);
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 230, 300, 30);
        dateChooser.setForeground(new Color(32, 123, 34));
        add(dateChooser);

        JLabel gender = new JLabel("Gender :");
        gender.setBounds(120, 270, 150, 40);
        gender.setFont(new Font("Ariel", Font.BOLD, 16));
        add(gender);
        male = new JRadioButton("Male");
        male.setBounds(300, 270, 100, 30);
        male.setBackground(Color.white);
        add(male);
        female = new JRadioButton("Female");
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
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Ariel", Font.BOLD, 12));
        emailTextField.setBounds(300, 310, 300, 30);
        add(emailTextField);

        JLabel marital = new JLabel("Marital Status :");
        marital.setBounds(120, 350, 150, 40);
        marital.setFont(new Font("Ariel", Font.BOLD, 16));
        add(marital);
        married = new JRadioButton("Married");
        married.setBounds(300, 350, 100, 30);
        married.setBackground(Color.white);
        add(married);
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(400, 350, 100, 30);
        unmarried.setBackground(Color.white);
        add(unmarried);
        other = new JRadioButton("Other");
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
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Ariel", Font.BOLD, 12));
        addressTextField.setBounds(300, 390, 300, 30);
        add(addressTextField);

        JLabel city = new JLabel("City :");
        city.setBounds(120, 430, 150, 40);
        city.setFont(new Font("Ariel", Font.BOLD, 16));
        add(city);
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Ariel", Font.BOLD, 12));
        cityTextField.setBounds(300, 430, 300, 30);
        add(cityTextField);

        JLabel state = new JLabel("State :");
        state.setBounds(120, 470, 150, 40);
        state.setFont(new Font("Ariel", Font.BOLD, 16));
        add(state);
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Ariel", Font.BOLD, 12));
        stateTextField.setBounds(300, 470, 300, 30);
        add(stateTextField);

        JLabel pincode = new JLabel("Pin code :");
        pincode.setBounds(120, 510, 150, 40);
        pincode.setFont(new Font("Ariel", Font.BOLD, 16));
        add(pincode);
        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Ariel", Font.BOLD, 12));
        pinTextField.setBounds(300, 510, 300, 30);
        add(pinTextField);

        next = new JButton("Next");
        next.setBounds(500, 600, 100, 30);
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.addActionListener(this);
        add(next);

        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(Color.white);

    }
    @Override
    public void actionPerformed(ActionEvent ae) {

        String formno = "" + randomNum;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String email = emailTextField.getText();
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinTextField.getText();

        String gender = null;
        if(male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }

        String marital = null;
        if (married.isSelected()) {
            marital = "Married";
        } else if(unmarried.isSelected()) {
            marital = "Unmarried";
        } else if (other.isSelected()) {
            marital = "Other";
        }

        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();

        try {
            if(name.equals("")) {
                JOptionPane.showMessageDialog(null, "Are you without name?");
            } else {
                Conn c = new Conn();
                String query = "insert into signup values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+email+"', '"+address+"', '"+city+"', '"+state+"', '"+pin+"', '"+gender+"', '"+marital+"')";
                c.s.executeUpdate(query);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        new SignupOne();
    }
}
