package controller.outset;

import viewing.organisations.ams.AmsView;;
import viewing.organisations.finance.FinanceView;
import viewing.organisations.oegk.OegkView;
import viewing.organisations.waff.WaffView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class OutsetController implements ActionListener {
    //Properties--------------------------------------------------------------------------------------------------------
    private JFrame oufset;
    private JButton ams;
    private JButton finanzonline;
    private JButton oegk;
    private JButton waff;

    //Handing over properties via Constructor---------------------------------------------------------------------------
    public OutsetController(JFrame oufset, JButton ams, JButton finanzonline, JButton oegk, JButton waff) {
        this.oufset = oufset;
        this.ams = ams;
        this.finanzonline = finanzonline;
        this.oegk = oegk;
        this.waff = waff;
    }

    //ActionPerformed Method--------------------------------------------------------------------------------------------
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ams) {
            new AmsView();
            oufset.setVisible(false);}

        else if (e.getSource() == finanzonline) {
            new FinanceView();
            oufset.setVisible(false);}

        else if (e.getSource() == oegk) {
            new OegkView();
            oufset.setVisible(false);}

        else if (e.getSource() == waff) {
            new WaffView();
            oufset.setVisible(false);
       }
    }
}
