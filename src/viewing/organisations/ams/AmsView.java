package viewing.organisations.ams;

import controller.organisations.ams.AmsController;
import model.info.Info;
import model.organisations.ams.Ams;
import viewing.outset.Outset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AmsView  extends JFrame {
    //Properties--------------------------------------------------------------------------------------------------------
    private Ams ams = new Ams();
    private JLabel infoAMS = new JLabel ("In order to receive unemployment benefits, you must register " +
            "as unemployed in right time.", SwingConstants.CENTER);

    //questionsProperties
    private JRadioButton yesButton = new JRadioButton("Yes");
    private JRadioButton noButton = new JRadioButton("No");
    private ButtonGroup buttonGroup = new ButtonGroup();
    private JCheckBox insuranceBox = new JCheckBox();
    private JCheckBox workedInATBox = new JCheckBox();
    private JRadioButton firstTimeBox = new JRadioButton("Yes");
    private JRadioButton secondTimeBox = new JRadioButton("No");
    private ButtonGroup buttonGroupTimes = new ButtonGroup();

    //calenderProperties
    private JComboBox calendarDaysB = new JComboBox(ams.calendarDays().toArray(new String[0]));
    private JComboBox calendarMonthsB = new JComboBox(ams.calendarMonths().toArray(new String[0]));
    private JComboBox calendarYearsB = new JComboBox(ams.calendarYears().toArray(new String[0]));

    private JComboBox calendarDaysE = new JComboBox(ams.calendarDays().toArray(new String[0]));
    private JComboBox calendarMonthsE = new JComboBox(ams.calendarMonths().toArray(new String[0]));
    private JComboBox calendarYearsE = new JComboBox(ams.calendarYears().toArray(new String[0]));
    private JCheckBox stillWorking = new JCheckBox("Still working");

    //functionalProperties
    private JButton continueButton = new JButton("Continue");
    private JButton calculateButton = new JButton("Calculate");
    private JButton backButton = new JButton("Back to Main Menu");

    //Handing over Properties-------------------------------------------------------------------------------------------
    private AmsController amsController = new AmsController(this, infoAMS, yesButton, noButton,
            insuranceBox, workedInATBox, continueButton, calendarDaysB, calendarMonthsB, calendarYearsB, calendarDaysE,
            calendarMonthsE, calendarYearsE, calculateButton, firstTimeBox, secondTimeBox);

    public AmsView(){
        //JLables-------------------------------------------------------------------------------------------------------
        JLabel registeredLab = new JLabel("Are you registered in Austria?");
        JLabel insuranceLab = new JLabel(String.format("<html><body style=\"text-align: left " +
                "\">%s</body></html>","Did you have unemployment insurance in Austria?"));
        JLabel workedInATLab = new JLabel("Did you work in Austria?");
        JLabel calculator = new JLabel ("Calculator", SwingConstants.CENTER);
        JLabel workBegin = new JLabel("You started your last job:");
        JLabel workEnd = new JLabel("You ended your last job:");
        JLabel firstTimeLab= new JLabel(String.format("<html><body style=\"text-align: left " +
                "\">%s</body></html>","Do you want to apply to unemployment benefits for the first time?"));

        //CSS-----------------------------------------------------------------------------------------------------------
        insuranceBox.setHorizontalAlignment(SwingConstants.CENTER);
        workedInATBox.setHorizontalAlignment(SwingConstants.CENTER);
        yesButton.setHorizontalAlignment(SwingConstants.CENTER);
        noButton.setHorizontalAlignment(SwingConstants.LEFT);
        firstTimeBox.setHorizontalAlignment(SwingConstants.CENTER);

        infoAMS.setFont(new Font("Abyssinica SIL",Font.ITALIC,12));
        infoAMS.setPreferredSize(new Dimension(700, 70));
        infoAMS.setBackground(Color.yellow);

        calculator.setFont(new Font("Abyssinica SIL",Font.BOLD,20));

        //ButtonGroups--------------------------------------------------------------------------------------------------
        buttonGroup.add(yesButton);
        buttonGroup.add(noButton);
        buttonGroupTimes.add(firstTimeBox);
        buttonGroupTimes.add(secondTimeBox);

        //ActionListener via Controller---------------------------------------------------------------------------------
        yesButton.addActionListener(amsController);
        noButton.addActionListener(amsController);
        insuranceBox.addActionListener(amsController);
        workedInATBox.addActionListener(amsController);
        continueButton.addActionListener(amsController);
        calculateButton.addActionListener(amsController);
        firstTimeBox.addActionListener(amsController);
        secondTimeBox.addActionListener(amsController);

        //ActionListener via Anonymous class----------------------------------------------------------------------------
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Outset();
                setVisible(false);
            }
        });

        //ItemListener via Lambda---------------------------------------------------------------------------------------
        stillWorking.addItemListener(e -> {
            if (stillWorking.isSelected()) {
                infoAMS.setFont(new Font("Abyssinica SIL",Font.ITALIC,14));
                infoAMS.setForeground(Color.blue);
                infoAMS.setText(String.format("<html><body style=\"text-align: center " +
                        "\">%s</body></html>","You must register as unemployed on the first day of your unemployment " +
                        "at the latest. You can register earliest 3 weeks before dismissal."));
            }else if (stillWorking.isEnabled()){
                infoAMS.setFont(new Font("Abyssinica SIL",Font.ITALIC,12));
                infoAMS.setForeground(Color.black);
                infoAMS.setText("In order to receive unemployment benefits, you must register as unemployed in right time.");
            }});

        //Panels--------------------------------------------------------------------------------------------------------
        JPanel infoPanel = new JPanel();
        JPanel questPanel = new JPanel();
        JPanel calendar = new JPanel();

        //JPanel-infoPanel
        infoPanel.setLayout(new GridLayout(1,1));
        infoPanel.add(infoAMS);

        //JPanel-questPanel
        questPanel.setLayout(new GridLayout(6,3));
        questPanel.add(registeredLab);        questPanel.add(yesButton);        questPanel.add(noButton);
        questPanel.add(insuranceLab);         questPanel.add(insuranceBox);     questPanel.add(new JLabel());
        questPanel.add(workedInATLab);        questPanel.add(workedInATBox);    questPanel.add(new JLabel());
        questPanel.add(firstTimeLab);         questPanel.add(firstTimeBox);     questPanel.add(secondTimeBox);
        questPanel.add(new JLabel());         questPanel.add(continueButton);   questPanel.add(new JLabel());
        questPanel.add(new JLabel());         questPanel.add(calculator);       questPanel.add(new JLabel());

        //JPanel-calendarPanel
        calendar.setLayout(new GridLayout(4,3));
        calendar.add(workBegin); calendar.add(calendarDaysB); calendar.add(calendarMonthsB); calendar.add(calendarYearsB);
        calendar.add(workEnd); calendar.add(calendarDaysE); calendar.add(calendarMonthsE); calendar.add(calendarYearsE);
        calendar.add(new JLabel()); calendar.add(stillWorking); calendar.add(new JLabel());calendar.add(new JLabel());
        calendar.add(backButton); calendar.add(new JLabel()); calendar.add(new JLabel());calendar.add(calculateButton);

        //Frame--------------------------------------------------------------------------------------------------------
        this.setLayout(new BorderLayout());
        this.add(infoPanel, BorderLayout.NORTH);
        this.add(questPanel,BorderLayout.CENTER);
        this.add(calendar,BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("InfoAustria | AMS - " + new Info().getDate());
        this.setSize(700, 400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
