package controller.organisations.finance;

import model.organisations.finance.FinanceOnline;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinanceController implements ActionListener {
    //Properties--------------------------------------------------------------------------------------------------------
    private FinanceOnline financeOnline = new FinanceOnline();
    JTextField yourSalary;

    //functionalProperties
    private JTextArea infoFinance;
    private JButton getButton;
    private JButton calculateButton;

    //Handing over properties via Constructor---------------------------------------------------------------------------
    public FinanceController(JTextField yourSalary, JTextArea infoFinance, JButton getButton, JButton calculateButton) {
        this.yourSalary = yourSalary;
        this.infoFinance = infoFinance;
        this.getButton = getButton;
        this.calculateButton = calculateButton;
    }

    //ActionPerformed Method--------------------------------------------------------------------------------------------
    @Override
    public void actionPerformed(ActionEvent e) {
        //taxRateList Controller-------------------------------------------------------------------------------------------
        if (e.getSource() == getButton) {
            financeOnline = new FinanceOnline();
            financeOnline.addTaxRate();
            infoFinance.setText(financeOnline.getTaxRateList());

        //yourTaxRate Controller-------------------------------------------------------------------------------------------
        } else if  (e.getSource() == calculateButton){
            try {
                int salary = Integer.parseInt(yourSalary.getText());
                infoFinance.setText(financeOnline.getTaxSum(salary));
            }catch (Exception r){
                System.out.println(r);
            }
        }
    }
}