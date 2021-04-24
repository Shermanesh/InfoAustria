package controller.organisations.ams;

import model.login.Login;
import model.organisations.ams.Ams;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Objects;

public class AmsController implements ActionListener {
    //Properties--------------------------------------------------------------------------------------------------------
    private Login login = new Login();
    private Ams ams = new Ams ();

    //questionsProperties
    private JRadioButton yesButton;
    private JRadioButton noButton;
    private JCheckBox insuranceBox;
    private JCheckBox workedInATBox;
    private JRadioButton firstTimeBox;
    private JRadioButton secondTimeBox;

    //calendarProperties
    private JComboBox calendarDaysB;
    private JComboBox calendarMonthsB;
    private JComboBox calendarYearsB;
    private JComboBox calendarDaysE;
    private JComboBox calendarMonthsE;
    private JComboBox calendarYearsE;

    //functionalProperties
    private JFrame amsView;
    private JLabel infoAMS;
    private JButton continueButton;
    private JButton calculateButton;

    //Handing over properties via Constructor---------------------------------------------------------------------------
    public AmsController(JFrame amsView, JLabel infoAMS, JRadioButton yesButton, JRadioButton noButton,
                         JCheckBox insuranceBox, JCheckBox workedInATBox, JButton continueButton, JComboBox calendarDaysB,
                         JComboBox calendarMonthsB, JComboBox calendarYearsB, JComboBox calendarDaysE,
                         JComboBox calendarMonthsE, JComboBox calendarYearsE, JButton calculateButton,
                         JRadioButton firstTimeBox, JRadioButton secondTimeBox) {
        this.amsView = amsView;
        this.infoAMS = infoAMS;
        this.yesButton = yesButton;
        this.noButton = noButton;
        this.insuranceBox = insuranceBox;
        this.workedInATBox = workedInATBox;
        this.continueButton = continueButton;
        this.calendarDaysB = calendarDaysB;
        this.calendarMonthsB = calendarMonthsB;
        this.calendarYearsB = calendarYearsB;
        this.calendarDaysE = calendarDaysE;
        this.calendarMonthsE = calendarMonthsE;
        this.calendarYearsE = calendarYearsE;
        this.calculateButton = calculateButton;
        this.firstTimeBox = firstTimeBox;
        this.secondTimeBox = secondTimeBox;
    }

    //ActionPerformed Method--------------------------------------------------------------------------------------------
    @Override
    public void actionPerformed(ActionEvent e) {
        //questions Controller------------------------------------------------------------------------------------------
        if (e.getSource() == yesButton) {
            amsView.setTitle("You are registered in Austria");
        }
        else if (e.getSource() == noButton) {
            amsView.setTitle("Sorry, you must be registered in Austria!");
            JFrame alert = new JFrame();
            JOptionPane.showMessageDialog(alert, "Please registered in Austria to be able to use " +
                    "social system opportunities", "Alert", JOptionPane.WARNING_MESSAGE);
        }
        else if (e.getSource() == continueButton) {
            if ((insuranceBox.isSelected()) && (workedInATBox.isSelected())) {
                JFrame msg = new JFrame();
                JOptionPane.showMessageDialog(msg, "You have opportunity to get unemployment benefits." +
                        "\nPlease, use calculator to get more information.");
            } else if ((!insuranceBox.isSelected()) || (!workedInATBox.isSelected())) {
                JFrame msg = new JFrame();
                JOptionPane.showMessageDialog(msg, "Unfortunately, you have no opportunity " +
                        "to get unemployment benefits.");
            }
        }
        //calendar Controller-------------------------------------------------------------------------------------------
        else if (e.getSource() == calculateButton) {
            int daysBText = Integer.parseInt(Objects.requireNonNull(calendarDaysB.getSelectedItem()).toString());
            int monthsBText = Integer.parseInt(Objects.requireNonNull(calendarMonthsB.getSelectedItem()).toString());
            int yearsBText = Integer.parseInt(Objects.requireNonNull(calendarYearsB.getSelectedItem()).toString());
            int daysEText = Integer.parseInt(Objects.requireNonNull(calendarDaysE.getSelectedItem()).toString());
            int monthsEText = Integer.parseInt(Objects.requireNonNull(calendarMonthsE.getSelectedItem()).toString());
            int yearsEText = Integer.parseInt(Objects.requireNonNull(calendarYearsE.getSelectedItem()).toString());

            LocalDate workBegin = LocalDate.of(yearsBText, monthsBText, daysBText);
            LocalDate workEnd = LocalDate.of(yearsEText, monthsEText, daysEText);

            if(firstTimeBox.isSelected()) {
                infoAMS.setFont(new Font("Abyssinica SIL",Font.ITALIC,14));
                infoAMS.setText(String.format("<html><body style=\"text-align: center " +
                        "\">%s</body></html>",ams.calculateWork1(workBegin, workEnd, login.getAge())));
                infoAMS.setForeground(Color.blue);
            }
            else if(secondTimeBox.isSelected()){
                infoAMS.setFont(new Font("Abyssinica SIL",Font.ITALIC,14));
                infoAMS.setText(String.format("<html><body style=\"text-align: center " +
                        "\">%s</body></html>",ams.calculateWork2(workBegin, workEnd)));
                infoAMS.setForeground(Color.blue);
            }else{
                JFrame alert = new JFrame();
                JOptionPane.showMessageDialog(alert, "Please choose whether you apply for the first time.",
                        "Alert", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}
