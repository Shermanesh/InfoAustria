package controller.login;

import model.database.Database;
import model.login.Login;
import model.person.Person;
import viewing.outset.Outset;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.Objects;

public class LoginController implements ActionListener {
    //Properties--------------------------------------------------------------------------------------------------------

    //questionsProperties
    private JComboBox stateBox;
    private JRadioButton male;
    private JRadioButton female;
    private JTextField nameText;
    private JTextField ageText;
    private JPasswordField passwordField;

    //functionalProperties
    private JFrame loginView;
    private JButton save;

    //additional Properties
    private long id = 0;
    private String name;
    private int age;
    private char gender;
    private String state;
    private char[] password;
    private Login login = new Login();
    private Person person = new Person(id, name, age, gender, state, password);

    //Handing over properties via Constructor---------------------------------------------------------------------------
    public LoginController(JFrame loginView, JComboBox stateBox, JRadioButton male, JRadioButton female,
                           JTextField nameText, JTextField ageText, JPasswordField passwordField, JButton save) {
        this.loginView = loginView;
        this.stateBox = stateBox;
        this.male = male;
        this.female = female;
        this.nameText = nameText;
        this.ageText = ageText;
        this.passwordField = passwordField;
        this.save = save;
    }

    //ActionPerformed Method--------------------------------------------------------------------------------------------
    @Override
    public void actionPerformed(ActionEvent e) {

        //questions Controller------------------------------------------------------------------------------------------
        if (e.getSource() == male) {
            gender = 'm';

        } else if (e.getSource() == female) {
            gender = 'f';

            //function Controller-------------------------------------------------------------------------------------------
        } else if (e.getSource() == save) {
            if (nameText.getText().equals("") || ageText.getText().equals("") || passwordField.getText().equals("")) {
                JFrame alert = new JFrame();
                JOptionPane.showMessageDialog(alert, "Please fill in all fields", "Alert",
                        JOptionPane.WARNING_MESSAGE);
            } else if (!male.isSelected() && !female.isSelected()) {
                JFrame alert = new JFrame();
                JOptionPane.showMessageDialog(alert, "Please choose your gender", "Alert",
                        JOptionPane.WARNING_MESSAGE);
            } else if (Integer.parseInt(ageText.getText()) < 0 || Integer.parseInt(ageText.getText()) >= 120) {
                JFrame alert = new JFrame();
                JOptionPane.showMessageDialog(alert, "Age can not be negative or more than 120.", "Alert",
                        JOptionPane.WARNING_MESSAGE);

                //saving a User---------------------------------------------------------------------------------------------
            } else {
                state = Objects.requireNonNull(stateBox.getSelectedItem()).toString();
                name = nameText.getText();
                age = Integer.parseInt(ageText.getText());
                password = passwordField.getText().toCharArray();

                if (login.getName().equals(name.toLowerCase(Locale.ROOT))) {
                    JFrame alert = new JFrame();
                    JOptionPane.showMessageDialog(alert, "User name " + name + " already exists.", "Alert",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    person.setId(id++);

                    //======================TXT Writer-Reader======================
                    login.userSave(id, name.toLowerCase(Locale.ROOT), age, gender, state, password);
                    person = new Person(id, name, age, gender, state, password);
                    System.out.println(person.toString());

                    //======================SERIALIZATION======================
                    login.userCreate(id, name.toLowerCase(Locale.ROOT), age, gender, state, password);

                    //go to OutsetMenu------------------------------------------------------------------------------------------
                    new Outset();
                    loginView.setVisible(false);
                }
            }
        }
    }
}