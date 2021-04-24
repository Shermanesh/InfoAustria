package viewing.organisations.finance;

import controller.organisations.finance.FinanceController;
import controller.organisations.oegk.OegkController;
import model.info.Info;
import model.organisations.finance.FinanceOnline;
import model.organisations.oegk.Oegk;
import viewing.outset.Outset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FinanceView extends JFrame{
    //Properties--------------------------------------------------------------------------------------------------------
    JTextField yourSalary = new JTextField();

    //functionalProperties
    private JTextArea infoFinance = new JTextArea();
    private JButton getButton = new JButton("GET");
    private JButton calculateButton = new JButton("Calculate tax rate");
    private JButton backButton = new JButton("Back to Main Menu");

    //Handing over Properties-------------------------------------------------------------------------------------------
    private FinanceController financeController = new FinanceController(yourSalary, infoFinance, getButton, calculateButton);

    public FinanceView(){
        //JLables-------------------------------------------------------------------------------------------------------
        JLabel taxLab = new JLabel("Tax rate in Austria for " + new Info().getDate(), SwingConstants.CENTER);
        JLabel salaryLab = new JLabel("Please enter your annual salary: ", SwingConstants.CENTER);

        //CSS-----------------------------------------------------------------------------------------------------------
        Color myColor = new Color(230,230,250);

        infoFinance.setWrapStyleWord(true);
        infoFinance.setLineWrap(true);
        infoFinance.setBackground(myColor);
        infoFinance.setFont(new Font("Abyssinica SIL",Font.PLAIN,14));

        yourSalary.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                    new Info().numbersValidation(e,yourSalary);
            }
        });

        //ActionListener via Controller---------------------------------------------------------------------------------
        getButton.addActionListener(financeController);
        calculateButton.addActionListener(financeController);

        //ActionListener via Lambda-------------------------------------------------------------------------------------
        backButton.addActionListener(e -> {
            new Outset();
            setVisible(false);
        });

        //Panels--------------------------------------------------------------------------------------------------------
        JPanel getPanel = new JPanel();
        JPanel infoPanel = new JPanel();
        JPanel buttonsPanel = new JPanel();

        //JPanel-getPanel
        getPanel.setLayout(new GridLayout(3,2));
        getPanel.add(new JLabel());     getPanel.add(new JLabel());;
        getPanel.add(taxLab);           getPanel.add(getButton);
        getPanel.add(new JLabel());     getPanel.add(new JLabel());;

        //JPanel-infoPanel
        infoPanel.setLayout(new GridLayout(1,1));
        infoPanel.add(infoFinance);

        //JPanel-buttonsPanel
        buttonsPanel.setLayout(new GridLayout(4,2));
        buttonsPanel.add(new JLabel());        buttonsPanel.add(new JLabel());
        buttonsPanel.add(salaryLab);           buttonsPanel.add(yourSalary);;
        buttonsPanel.add(new JLabel());        buttonsPanel.add(new JLabel());
        buttonsPanel.add(backButton);          buttonsPanel.add(calculateButton);

        //Frame--------------------------------------------------------------------------------------------------------
        this.setLayout(new BorderLayout());
        this.add(getPanel, BorderLayout.NORTH);
        this.add(infoPanel, BorderLayout.CENTER);
        this.add(buttonsPanel, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("InfoAustria | FinanzOnline - " + new Info().getDate());
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
