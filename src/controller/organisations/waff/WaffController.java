package controller.organisations.waff;

import model.organisations.waff.Waff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WaffController implements ActionListener {
    //Properties--------------------------------------------------------------------------------------------------------

    //questionsProperties
    private JRadioButton yesLive;
    private JRadioButton noLive;
    private JRadioButton yesWork;
    private JRadioButton noWork;

    private JRadioButton akMemberVienna;
    private JRadioButton akMemberAT;
    private JCheckBox akMemberNO;

    private JRadioButton salary1800;
    private JRadioButton salaryLess2500;
    private JRadioButton salaryMore2500;

    //functionalProperties
    private List haveList;
    private JButton continueButton;

    //additionalProperties
    private boolean liveInViennaMap, workInViennaMap;
    private boolean akMemberViennaMap, akMemberATMap;
    private boolean salary1800Map, salaryLess2500Map, salaryMore2500Map;

    //Handing over additional Properties--------------------------------------------------------------------------------
    private Waff waff = new Waff(liveInViennaMap, workInViennaMap, akMemberViennaMap, akMemberATMap, salary1800Map,
            salaryLess2500Map, salaryMore2500Map);

    //Handing over properties via Constructor---------------------------------------------------------------------------
    public WaffController(JRadioButton yesLive, JRadioButton noLive, JRadioButton yesWork,
                          JRadioButton noWork, JRadioButton akMemberVienna, JRadioButton akMemberAT, JCheckBox akMemberNO,
                          JRadioButton salary1800, JRadioButton salaryLess2500, JRadioButton salaryMore2500,
                          JButton continueButton, List haveList) {
        this.yesLive = yesLive;
        this.noLive = noLive;
        this.yesWork = yesWork;
        this.noWork = noWork;
        this.akMemberVienna = akMemberVienna;
        this.akMemberAT = akMemberAT;
        this.akMemberNO = akMemberNO;
        this.salary1800 = salary1800;
        this.salaryLess2500 = salaryLess2500;
        this.salaryMore2500 = salaryMore2500;
        this.continueButton = continueButton;
        this.haveList = haveList;
    }

    //ActionPerformed Method--------------------------------------------------------------------------------------------
    @Override
    public void actionPerformed(ActionEvent e) {
        //questions Controller------------------------------------------------------------------------------------------
        if (e.getSource() == yesLive) {
            liveInViennaMap = true;
            waff.addCondition("You live in Vienna, ");
            haveList.add("You live in Vienna");
        }
        else if (e.getSource() == noLive) {
            liveInViennaMap = false;
            waff.deleteCondition("You live in Vienna, ");
            try {
                haveList.remove("You live in Vienna");
            }catch (Exception r){
                System.out.println(r);
            }
        }
        else if (e.getSource() == yesWork) {
            workInViennaMap = true;
            waff.addCondition("You work in Vienna, ");
            haveList.add("You work in Vienna");
        }
        else if (e.getSource() == noWork) {
            workInViennaMap = false;
            waff.deleteCondition("You work in Vienna, ");
            try {
                haveList.remove("You work in Vienna");
            }catch (Exception r){
                System.out.println(r);
            }
        }
        else if (e.getSource() == akMemberVienna) {
            akMemberViennaMap = true;
            akMemberATMap = false;
            waff.addCondition("You are a member of AK Vienna, ");
            haveList.add("You are a member of AK Vienna");
        }
        else if (e.getSource() == akMemberAT) {
            akMemberATMap = true;
            akMemberViennaMap = false;
            waff.addCondition("You are a member of AK, ");
            haveList.add("You are a member of AK");
            try {
                haveList.remove("You are a member of AK Vienna");
            }catch (Exception r){
                System.out.println(r);
            }
        }
        else if (e.getSource() == akMemberNO) {
            akMemberViennaMap = false;
            akMemberATMap = false;
            waff.deleteCondition("You are a member of AK Vienna, ");
            waff.deleteCondition("You are a member of AK, ");
            try {
                haveList.remove("You are a member of AK Vienna");
                haveList.remove("You are a member of AK");
            }catch (Exception r){
                System.out.println(r);
            }
        }
        else if (e.getSource() == salary1800) {
            salary1800Map = true;
            salaryLess2500Map = true;
            salaryMore2500Map = false;
            waff.addCondition("Your salary is less then 1800 Eur net. ");
            haveList.add("Your salary is less then 1800 Eur net");
            try {
                haveList.remove("Your salary is less then 2500 Eur net");
                haveList.remove("Your salary is more then 2500 Eur net");
            }catch (Exception r){
                System.out.println(r);
            }
        }
        else if (e.getSource() == salaryLess2500) {
            salaryLess2500Map = true;
            salary1800Map = false;
            salaryMore2500Map = false;
            waff.addCondition("Your salary is less then 2500 Eur net. ");
            haveList.add("Your salary is less then 2500 Eur net");
            try {
                haveList.remove("Your salary is less then 1800 Eur net");
                haveList.remove("Your salary is more then 2500 Eur net");
            }catch (Exception r){
                System.out.println(r);
            }
        }
        else if (e.getSource() == salaryMore2500) {
            salaryMore2500Map = true;
            salary1800Map = false;
            salaryLess2500Map = false;

            waff.addCondition("Your salary is more then 2500 Eur net. ");
            haveList.add("Your salary is more then 2500 Eur net");
            try {
                haveList.remove("Your salary is less then 1800 Eur net");
                haveList.remove("Your salary is less then 2500 Eur net");
            }catch (Exception r){
                System.out.println(r);
            }
        }
        //function Controller-------------------------------------------------------------------------------------------
        else if (e.getSource() == continueButton) {
            if ((!yesLive.isSelected()) && (!noLive.isSelected())) {
                JFrame alert = new JFrame();
                JOptionPane.showMessageDialog(alert, "Please select, whether you live in Vienna.","Alert",
                        JOptionPane.WARNING_MESSAGE);
            }
            else if ((!yesWork.isSelected()) && (!noWork.isSelected())) {
                JFrame alert = new JFrame();
                JOptionPane.showMessageDialog(alert, "Please select, whether you work in Vienna.","Alert",
                        JOptionPane.WARNING_MESSAGE);
            }
            else if ((!akMemberVienna.isSelected()) && (!akMemberAT.isSelected()) && (!akMemberNO.isSelected())){
                JFrame alert = new JFrame();
                JOptionPane.showMessageDialog(alert, "Please select your membership.","Alert",
                        JOptionPane.WARNING_MESSAGE);
            }
            else if ((!salary1800.isSelected()) && (!salaryLess2500.isSelected()) && (!salaryMore2500.isSelected())){
                JFrame alert = new JFrame();
                JOptionPane.showMessageDialog(alert, "Please select your salary.","Alert",
                        JOptionPane.WARNING_MESSAGE);
            }
            else{
            //showing all conditions which were chosen------------------------------------------------------------------
                haveList.removeAll();
                haveList.add(waff.getConditions());

            //showing available courses, according to Logic in Waff Class-----------------------------------------------
                Waff waff = new Waff(liveInViennaMap, workInViennaMap, akMemberViennaMap, akMemberATMap, salary1800Map,
                        salaryLess2500Map, salaryMore2500Map);

                if ((haveList.isEnabled())){
                    JFrame msg = new JFrame();
                    JOptionPane.showMessageDialog(msg, waff.getCourses());
                }
            }
        }
    }
}