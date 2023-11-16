package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;

public class SignupTwo extends JFrame {
    JTextField categoryTextField, qualificationTextField, incomeTextField,
            educationTextField, occupationTextField, panTextField, aadharTextField;
    public SignupTwo() {

        setSize(700, 800);
        setTitle("Page 2 : Sign up form");
        setLayout(null);

        JLabel heading = new JLabel("Page 2 : Additional Details");
        heading.setBounds(120, 40, 500, 40);
        heading.setFont(new Font("Ariel", Font.BOLD, 28));
        add(heading);

        JLabel religion = new JLabel("Religion :");
        religion.setBounds(120, 150, 100, 40);
        religion.setFont(new Font("Ariel", Font.BOLD, 16));
        add(religion);
        String[] listReligion = {"Muslim", "Hindu", "Christian", "Parsi", "Sikh", "other"};
        JComboBox religionDropDown = new JComboBox(listReligion);
        religionDropDown.setBounds(300, 150, 300, 30);
        religionDropDown.setBackground(Color.white);
        add(religionDropDown);

        JLabel category = new JLabel("Category :");
        category.setBounds(120, 190, 150, 40);
        category.setFont(new Font("Ariel", Font.BOLD, 16));
        add(category);
        String[] valCategory = {"General", "Sc", "ST", "RBA", "OBC", "Other"};
        JComboBox categoryDropDown = new JComboBox(valCategory);
        categoryDropDown.setBounds(300, 190, 300, 30);
        categoryDropDown.setBackground(Color.white);
        add(categoryDropDown);


        JLabel income = new JLabel("Income :");
        income.setBounds(120, 230, 150, 40);
        income.setFont(new Font("Ariel", Font.BOLD, 16));
        add(income);
        String[] incomeCategory = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000", "> 10,00,000"};
        JComboBox incomeDropDown = new JComboBox(incomeCategory);
        incomeDropDown.setBounds(300, 230, 300, 30);
        incomeDropDown.setBackground(Color.white);
        add(incomeDropDown);


        JLabel education = new JLabel("Educational");
        education.setBounds(120, 270, 150, 40);
        education.setFont(new Font("Ariel", Font.BOLD, 16));
        add(education);
        JLabel qualification = new JLabel("Qualification :");
        qualification.setBounds(120, 295, 150, 40);
        qualification.setFont(new Font("Ariel", Font.BOLD, 16));
        add(qualification);
        String[] eduVal = {"Under Graduate", "Graduate", "Post-Graduate", "Phd", "Doctrate", "Other"};
        JComboBox eduDropDown = new JComboBox(eduVal);
        eduDropDown.setBounds(300, 295, 300, 30);
        eduDropDown.setBackground(Color.white);
        add(eduDropDown);

        JLabel occupation = new JLabel("Occupation :");
        occupation.setBounds(120, 350, 150, 40);
        occupation.setFont(new Font("Ariel", Font.BOLD, 16));
        add(occupation);
        String[] occupationVal = {"Student", "Salaried", "Business", "Retired", "Other"};
        JComboBox occupationDropDown = new JComboBox(occupationVal);
        occupationDropDown.setBounds(300, 350, 300, 30);
        occupationDropDown.setBackground(Color.white);
        add(occupationDropDown);

        JLabel pan = new JLabel("Pan Number :");
        pan.setBounds(120, 390, 150, 40);
        pan.setFont(new Font("Ariel", Font.BOLD, 16));
        add(pan);
        panTextField = new JTextField();
        panTextField.setFont(new Font("Ariel", Font.BOLD, 12));
        panTextField.setBounds(300, 390, 300, 30);
        add(panTextField);

        JLabel aadhar = new JLabel("Aadhar Number :");
        aadhar.setBounds(120, 430, 150, 40);
        aadhar.setFont(new Font("Ariel", Font.BOLD, 16));
        add(aadhar);
        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Ariel", Font.BOLD, 12));
        aadharTextField.setBounds(300, 430, 300, 30);
        add(aadharTextField);

        JLabel sCitizen = new JLabel("Senior Citizen :");
        sCitizen.setBounds(120, 470, 150, 40);
        sCitizen.setFont(new Font("Ariel", Font.BOLD, 16));
        add(sCitizen);
        JRadioButton sYes = new JRadioButton("Yes");
        sYes.setBounds(300, 470, 70, 20);
        sYes.setBackground(Color.white);
        add(sYes);
        JRadioButton sNo = new JRadioButton("N0");
        sNo.setBounds(380, 480, 70, 20);
        sNo.setBackground(Color.white);
        add(sNo);
        ButtonGroup sCitizenGroup = new ButtonGroup();
        sCitizenGroup.add(sYes);
        sCitizenGroup.add(sNo);

        JLabel eAccount = new JLabel("Existing Account :");
        eAccount.setBounds(120, 510, 150, 40);
        eAccount.setFont(new Font("Ariel", Font.BOLD, 16));
        add(eAccount);
        JRadioButton eYes = new JRadioButton("Yes");
        eYes.setBounds(300, 520, 70, 20);
        eYes.setBackground(Color.white);
        add(sYes);
        JRadioButton eNo = new JRadioButton("N0");
        eNo.setBounds(380, 520, 70, 20);
        eNo.setBackground(Color.white);
        add(eNo);
        ButtonGroup eAccountGroup = new ButtonGroup();
        sCitizenGroup.add(eYes);
        sCitizenGroup.add(eNo);


        getContentPane().setBackground(Color.white);

        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new SignupTwo();
    }
}
