package viewing.outset;

import controller.outset.OutsetController;
import model.info.Info;

import javax.swing.*;
import java.awt.*;

public class Outset extends JFrame {
    //Properties--------------------------------------------------------------------------------------------------------
    private JButton ams = new JButton (new ImageIcon("ams.png"));
    private JButton finanzonline = new JButton (new ImageIcon("finanzonline.png"));
    private JButton oegk = new JButton(new ImageIcon("oegk.png"));
    private JButton waff = new JButton(new ImageIcon("waff.png"));

    //Handing over Properties-------------------------------------------------------------------------------------------
    private OutsetController outsetController = new OutsetController(this,ams, finanzonline, oegk, waff);

    public Outset() {
        //JLables-------------------------------------------------------------------------------------------------------
        JLabel wellcomeLable;
        JLabel moreAboutLable = new JLabel("   You are intressted in: ", SwingConstants.CENTER);

        //CSS------------------------------------------------------------------------------------------------------
        ImageIcon imageLabel = new ImageIcon("integration.jpg");
        Image imageLab = imageLabel.getImage();
        Image newImg = imageLab.getScaledInstance(400, 300,  java.awt.Image.SCALE_SMOOTH);
        imageLabel = new ImageIcon(newImg);
        wellcomeLable = new JLabel(imageLabel);

        ams.setBackground(Color.white);
        finanzonline.setBackground(Color.white);
        oegk.setBackground(Color.white);
        waff.setBackground(Color.white);

        //ActionListener via Controller---------------------------------------------------------------------------------
        ams.addActionListener(outsetController);
        finanzonline.addActionListener(outsetController);
        oegk.addActionListener(outsetController);
        waff.addActionListener(outsetController);

        //JPanels-------------------------------------------------------------------------------------------------------
        JPanel wellcomePanel = new JPanel();
        JPanel organisationsPanel = new JPanel();

        //JPanel-wellcomePanel
        wellcomePanel.setLayout(new GridLayout(2, 1));
        wellcomePanel.add(wellcomeLable);
        wellcomePanel.add(moreAboutLable);

        //JPanel-organisationsPanel
        organisationsPanel.setLayout(new GridLayout(2, 2));
        organisationsPanel.add(ams);            organisationsPanel.add(oegk);
        organisationsPanel.add(finanzonline);   organisationsPanel.add(waff);

        //Frame--------------------------------------------------------------------------------------------------------
        this.setLayout(new GridLayout(2, 1));
        this.add(wellcomePanel);
        this.add(organisationsPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("InfoAustria | Main Menu");
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}

