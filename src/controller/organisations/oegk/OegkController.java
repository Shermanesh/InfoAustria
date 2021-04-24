package controller.organisations.oegk;

import model.organisations.oegk.Oegk;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class OegkController implements ActionListener {
    //Properties--------------------------------------------------------------------------------------------------------
    private Oegk oegk = new Oegk();

    //questionsProperties
    private JRadioButton yesIsured;
    private JRadioButton noIsured;
    private JRadioButton yesLive;
    private JRadioButton noLive;
    private JComboBox districtBox;

    //functionalProperties
    private JTextArea infoOEGK;
    private JButton continueButton;

    //Handing over properties via Constructor---------------------------------------------------------------------------
    public OegkController(JTextArea infoOEGK, JRadioButton yesIsured, JRadioButton noIsured, JRadioButton yesLive,
                          JRadioButton noLive, JComboBox districtBox, JButton continueButton) {
        this.infoOEGK = infoOEGK;
        this.yesIsured = yesIsured;
        this.noIsured = noIsured;
        this.yesLive = yesLive;
        this.noLive = noLive;
        this.districtBox = districtBox;
        this.continueButton = continueButton;
    }

    //ActionPerformed Method--------------------------------------------------------------------------------------------
    @Override
    public void actionPerformed(ActionEvent e) {
        //questions Controller------------------------------------------------------------------------------------------
        if (e.getSource() == yesIsured) {
            infoOEGK.setText("  \nYou can get free preventive check-up with your e-card.");
        }
        else if (e.getSource() == noIsured) {
            infoOEGK.setText ("\nYou need to get certificate marked \"Vorsorgeuntersuchung fuer Nicht Versicherte\" " +
                    "(Medical examination for uninsured persons).You can get help by filling out the registration form " +
                    "at your city's social security customer service center.");
        }
        //districts Logic-----------------------------------------------------------------------------------------------
        else if (e.getSource() == districtBox) {
            if(yesLive.isSelected()) {
                String yourdistric = Objects.requireNonNull(districtBox.getSelectedItem()).toString();
                if (yourdistric.equals("3")) {
                    infoOEGK.setText("\nYou have hospital in your district!\n" +
                            "\"Mein Gesundheitszentrum Landstrasse\"\n" +
                            "1030 Wien, Strohgasse 28.");
                }
                else if (yourdistric.equals("6")) {
                    infoOEGK.setText("\nYou have hospital in your district!\n" +
                            "\"Mein Gesundheitszentrum Mariahilf\"\n" +
                            "1060 Wien, Mariahilfer Strasse 85-87.");
                }
                else if (yourdistric.equals("10")) {
                    infoOEGK.setText("\nYou have hospital in your district!\n" +
                            "\"Mein Gesundheitszentrum Favoriten\"\n" +
                            "1100 Wien, Wienerbergstrasse 13.");
                }
                else if (yourdistric.equals("21")) {
                    infoOEGK.setText("\nYou have hospital in your district!\n" +
                            "\"Mein Gesundheitszentrum Floridsdorf\"\n" +
                            "1210 Wien, Karl-Aschenbrenner-Gasse 3.");
                }else{
                    infoOEGK.setText("");
                }
            }
        }
        //function Controller-------------------------------------------------------------------------------------------
        else if (e.getSource() == continueButton) {
            if ((!yesIsured.isSelected()) && (!noIsured.isSelected())) {
                JFrame alert = new JFrame();
                JOptionPane.showMessageDialog(alert, "Please select, whether you are insured.","Alert",
                        JOptionPane.WARNING_MESSAGE);
            }
            else if ((!yesLive.isSelected()) && (!noLive.isSelected())) {
                JFrame alert = new JFrame();
                JOptionPane.showMessageDialog(alert, "Please select, whether you live in Vienna.","Alert",
                        JOptionPane.WARNING_MESSAGE);

            //showing all offers, according to Logic in OEGK Class------------------------------------------------------
            }else{
                oegk = new Oegk();
                oegk.addOffers();
                infoOEGK.setText("During free preventive check-up you can have:\n" + oegk.getOffer());
            }
        }
    }
}
