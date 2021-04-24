package viewing.organisations.oegk;

import controller.organisations.oegk.OegkController;
import model.info.Info;
import model.organisations.oegk.Oegk;
import viewing.outset.Outset;

import javax.swing.*;
import java.awt.*;

public class OegkView extends JFrame{
    //Properties--------------------------------------------------------------------------------------------------------
    private Oegk oegk = new Oegk();

    //questionsProperties
    private JRadioButton yesIsured = new JRadioButton("Yes");
    private JRadioButton noIsured = new JRadioButton("No");
    private ButtonGroup buttonGroupIsured = new ButtonGroup();

    private JRadioButton yesLive = new JRadioButton("Yes");
    private JRadioButton noLive = new JRadioButton("No");
    private ButtonGroup buttonGroupLive = new ButtonGroup();

    private JComboBox districtBox = new JComboBox(oegk.getDistrict().toArray(new String[0]));

    //functionProperties
    private JTextArea infoOEGK = new JTextArea("\n  Vorsorgeuntersuchung is a free preventive check-up, which can be " +
            "done once a year.");
    private JButton continueButton = new JButton("Continue");
    private JButton backButton = new JButton("Back to Main Menu");

    //Handing over Properties-------------------------------------------------------------------------------------------
    private OegkController oegkController = new OegkController(infoOEGK, yesIsured, noIsured, yesLive, noLive,
            districtBox, continueButton);

    public OegkView(){
        //JLables-------------------------------------------------------------------------------------------------------
        JLabel insuranceLab = new JLabel("Are you insured in Austria?");
        JLabel genderLab = new JLabel("You gender is: ");
        JLabel yourGenderLab = new JLabel(oegk.getGender());
        JLabel ageLab = new JLabel("How old are you?");
        JLabel yourAgeLab = new JLabel(oegk.getAge());
        JLabel liveLab = new JLabel("Do you live in Vienna?");
        JLabel districtLab = new JLabel(String.format("<html><body style=\"text-align: left " + "\">%s</body></html>",
                "Please select your district in Vienna: "));

        //CSS-----------------------------------------------------------------------------------------------------------
        Color myColor = new Color(240,248,255);
        yesIsured.setHorizontalAlignment(SwingConstants.CENTER);
        noIsured.setHorizontalAlignment(SwingConstants.CENTER);
        yesLive.setHorizontalAlignment(SwingConstants.CENTER);
        noLive.setHorizontalAlignment(SwingConstants.CENTER);

        infoOEGK.setWrapStyleWord(true);
        infoOEGK.setLineWrap(true);
        infoOEGK.setBackground(myColor);
        infoOEGK.setFont(new Font("Abyssinica SIL",Font.ITALIC,14));

        yourAgeLab.setHorizontalAlignment(SwingConstants.CENTER);
        yourAgeLab.setFont(new Font("Abyssinica SIL",Font.CENTER_BASELINE,14));
        yourGenderLab.setHorizontalAlignment(SwingConstants.CENTER);
        yourGenderLab.setFont(new Font("Abyssinica SIL",Font.CENTER_BASELINE,14));

        districtBox.setBackground(myColor);

        //ButtonGroups--------------------------------------------------------------------------------------------------
        buttonGroupIsured.add(yesIsured);
        buttonGroupIsured.add(noIsured);
        buttonGroupLive.add(yesLive);
        buttonGroupLive.add(noLive);

        //ActionListener via Controller---------------------------------------------------------------------------------
        yesIsured.addActionListener(oegkController);
        noIsured.addActionListener(oegkController);
        yesLive.addActionListener(oegkController);
        noLive.addActionListener(oegkController);
        districtBox.addActionListener(oegkController);
        continueButton.addActionListener(oegkController);

        //ActionListener via Lambda-------------------------------------------------------------------------------------
        backButton.addActionListener(e -> {
            new Outset();
            setVisible(false); });

        //Panels--------------------------------------------------------------------------------------------------------
        JPanel infoPanel = new JPanel();
        JPanel questPanel = new JPanel();

        //JPanel-infoPanel
        infoPanel.setLayout(new GridLayout(1,1));
        infoPanel.add(infoOEGK);

        //JPanel-questPanel
        questPanel.setLayout(new GridLayout(7,3));
        questPanel.add(insuranceLab);        questPanel.add(yesIsured);         questPanel.add(noIsured);
        questPanel.add(liveLab);             questPanel.add(yesLive);           questPanel.add(noLive);
        questPanel.add(districtLab);         questPanel.add(new JLabel());      questPanel.add(districtBox);
        questPanel.add(ageLab);              questPanel.add(yourAgeLab);        questPanel.add(new JLabel());
        questPanel.add(genderLab);           questPanel.add(yourGenderLab);     questPanel.add(new JLabel());
        questPanel.add(new JLabel());        questPanel.add(new JLabel());      questPanel.add(new JLabel());
        questPanel.add(backButton);          questPanel.add(new JLabel());      questPanel.add(continueButton);

        //Frame--------------------------------------------------------------------------------------------------------
        this.setLayout(new BorderLayout());
        this.add(infoPanel, "Center");
        this.add(questPanel, "South");

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("InfoAustria | OEGK - " + new Info().getDate());
        this.setSize(600, 500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
