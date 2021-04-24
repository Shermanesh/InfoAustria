package viewing.login;

import controller.login.LoginController;
import model.info.Info;
import model.login.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoginView extends JFrame{
    //Properties--------------------------------------------------------------------------------------------------------

    //questionsProperties
    private JComboBox stateBox = new JComboBox(new Login().getStateList().toArray(new String[0]));

    private JRadioButton male = new JRadioButton("Male");
    private JRadioButton female = new JRadioButton("Female");
    private ButtonGroup buttonGroup = new ButtonGroup();

    private JTextField nameText = new JTextField();
    private JTextField ageText = new JTextField();
    private JPasswordField passwordField = new JPasswordField();

    //savingProperties
    private JButton save = new JButton("SAVE");

    //Handing over Properties-------------------------------------------------------------------------------------------
    private LoginController loginController = new LoginController (this, stateBox, male, female, nameText,
            ageText, passwordField, save);

    public LoginView(){
        //JLables-------------------------------------------------------------------------------------------------------
        JLabel stateLable = new JLabel (" Which state are you live?: ");
        JLabel nameLable = new JLabel (" Username: ");
        JLabel ageLable = new JLabel (" Age: ");
        JLabel passLabel = new JLabel(" Create a password: ");

        //CSS-----------------------------------------------------------------------------------------------------------
        ageText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                new Info().numbersValidation(e,ageText);
            }
        });

        //Tool Tip
        nameText.setToolTipText("Create your username");
        passwordField.setToolTipText("Create your password");
        save.setToolTipText("Save for creating a new account");

        //ButtonGroups--------------------------------------------------------------------------------------------------
        buttonGroup.add(male);
        buttonGroup.add(female);

        //ActionListener via Controller---------------------------------------------------------------------------------
        stateBox.addActionListener(loginController);
        male.addActionListener(loginController);
        female.addActionListener(loginController);
        nameText.addActionListener(loginController);
        ageText.addActionListener(loginController);
        passwordField.addActionListener(loginController);
        save.addActionListener(loginController);

        //Frame---------------------------------------------------------------------------------------------------------
        this.setLayout(new GridLayout(6,2));
        this.add(stateLable);   this.add(stateBox);
        this.add(male);         this.add(female);
        this.add(nameLable);    this.add(nameText);
        this.add(ageLable);     this.add(ageText);
        this.add(passLabel);    this.add(passwordField);
        this.add(new JLabel()); this.add(save);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Login to InfoAustria  " + new Info().getDate());
        this.setSize(400, 200);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
