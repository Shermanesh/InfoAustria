package viewing.organisations.waff;

import controller.organisations.waff.WaffController;
import model.info.Info;
import model.organisations.waff.Waff;
import viewing.outset.Outset;

import javax.swing.*;
import java.awt.*;

public class WaffView extends JFrame {
    //Properties--------------------------------------------------------------------------------------------------------

    //questionsProperties
    private JRadioButton yesLive = new JRadioButton("Yes");
    private JRadioButton noLive = new JRadioButton("No");
    private ButtonGroup buttonGroupLive = new ButtonGroup();

    private JRadioButton yesWork = new JRadioButton("Yes");
    private JRadioButton noWork = new JRadioButton("No");
    private ButtonGroup buttonGroupWork = new ButtonGroup();

    private JRadioButton akMemberVienna = new JRadioButton("Yes, in Vienna");
    private JRadioButton akMemberAT = new JRadioButton("Yes, in other state");
    private JCheckBox akMemberNO = new JCheckBox("No, I am not a member");
    private ButtonGroup buttonGroupAK = new ButtonGroup();

    private JRadioButton salary1800 = new JRadioButton("<1800 net");
    private JRadioButton salaryLess2500 = new JRadioButton("<2500 net");
    private JRadioButton salaryMore2500 = new JRadioButton(">2500 net");
    private ButtonGroup buttonGroupSalary = new ButtonGroup();

    //functionalProperties
    private JButton continueButton = new JButton("Continue");
    private JButton backButton = new JButton("Back to Main Menu");
    private List haveList = new List();

    //Handing over Properties-------------------------------------------------------------------------------------------
    private WaffController waffController = new WaffController(yesLive, noLive, yesWork, noWork, akMemberVienna,
            akMemberAT, akMemberNO, salary1800, salaryLess2500, salaryMore2500, continueButton, haveList);

    public WaffView(){
        //JLables-------------------------------------------------------------------------------------------------------
        JLabel waffInfo = new JLabel(String.format("<html><body style=\"text-align: left " +
                "\">%s</body></html>","WAFF provide people in Vienna with information, advice and " +
                "financial support for their professional development. In addition, they work in close cooperation with " +
                "the Vienna Public Employment Service (AMS Vienna) to serve as a port of call for job-searcher and companies."));
        JLabel liveLab = new JLabel("Do you live in Vienna?");
        JLabel workLab = new JLabel(String.format("<html><body style=\"text-align: left " + "\">%s</body></html>",
                "Are you currently employed in Vienna?"));
        JLabel akLab = new JLabel("Are you AK Member?");
        JLabel salaryLab = new JLabel("Your salary per month: ");

        //CSS-----------------------------------------------------------------------------------------------------------
        yesLive.setHorizontalAlignment(SwingConstants.CENTER);
        yesWork.setHorizontalAlignment(SwingConstants.CENTER);

        waffInfo.setFont(new Font("Abyssinica SIL",Font.ITALIC,12));
        waffInfo.setPreferredSize(new Dimension(700, 40));

        //ButtonGroups--------------------------------------------------------------------------------------------------
        buttonGroupLive.add(yesLive);
        buttonGroupLive.add(noLive);
        buttonGroupWork.add(yesWork);
        buttonGroupWork.add(noWork);
        buttonGroupAK.add(akMemberVienna);
        buttonGroupAK.add(akMemberAT);
        buttonGroupAK.add(akMemberNO);
        buttonGroupSalary.add(salary1800);
        buttonGroupSalary.add(salaryLess2500);
        buttonGroupSalary.add(salaryMore2500);

        //ActionListener via Controller---------------------------------------------------------------------------------
        yesLive.addActionListener(waffController);
        noLive.addActionListener(waffController);
        yesWork.addActionListener(waffController);
        noWork.addActionListener(waffController);
        akMemberVienna.addActionListener(waffController);
        akMemberAT.addActionListener(waffController);
        akMemberNO.addActionListener(waffController);
        salary1800.addActionListener(waffController);
        salaryLess2500.addActionListener(waffController);
        salaryMore2500.addActionListener(waffController);
        continueButton.addActionListener(waffController);
        haveList.addActionListener(waffController);

        //ActionListener via Lambda-------------------------------------------------------------------------------------
        backButton.addActionListener(e -> {
            new Outset();
            setVisible(false);
        });

        //Panels--------------------------------------------------------------------------------------------------------
        JPanel questPanel = new JPanel();
        JPanel infoPanel = new JPanel();

        //JPanel-questPanel
        questPanel.setLayout(new GridLayout(5,4));
        questPanel.add(liveLab);        questPanel.add(yesLive);         questPanel.add(noLive);     questPanel.add(new JLabel());
        questPanel.add(workLab);        questPanel.add(yesWork);         questPanel.add(noWork);     questPanel.add(new JLabel());
        questPanel.add(akLab);          questPanel.add(akMemberVienna);  questPanel.add(akMemberAT); questPanel.add(akMemberNO);
        questPanel.add(salaryLab);      questPanel.add(salary1800);      questPanel.add(salaryLess2500); questPanel.add(salaryMore2500);
        questPanel.add(backButton);     questPanel.add(new JLabel());    questPanel.add(new JLabel());   questPanel.add(continueButton);

        //JPanel-infoPanel
        infoPanel.setLayout(new GridLayout(2,1));
        infoPanel.add(waffInfo);
        infoPanel.add(haveList);

        //Frame---------------------------------------------------------------------------------------------------------
        this.setLayout(new BorderLayout());
        this.add(questPanel, "North");
        this.add(infoPanel, "Center");

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("InfoAustria | waff - " + new Info().getDate());
        this.setSize(700, 500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
