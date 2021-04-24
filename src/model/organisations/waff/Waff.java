package model.organisations.waff;

import model.login.Login;

import java.util.*;

public class Waff {
    //Properties--------------------------------------------------------------------------------------------------------
    private Login login = new Login();
    private ArrayList<String> conditions = new ArrayList<>();

    //courseProperties
    private final Map<Integer, Courses> courses = new HashMap<>();
    private Courses c1=new Courses("DIGI-WINNER","Financing: 40-80%",
            "financed expenditures for IT courses and training.",5000);
    private Courses c2=new Courses("DIGI-WINNER","Financing: 40-80%",
            "financed expenditures for IT courses and training.",2500);
    private Courses c3=new Courses("Frauen und Beruf (FRECH)","Financing: 90%",
            "funded courses on change of profession.",5000);
    private Courses c4=new Courses("AK Bildungsgutschein","Voucher is valid for the calendar year in" +
            " which they were issued.",
            "is suitable for all courses.",120);
    private Courses c5=new Courses("AK Digi-Bonus","Voucher can be used with \"AK Bildungsgutschein\".",
            "is suitable only for IT courses.",120);

    //additionalProperties
    private boolean liveInVienna, workInVienna;
    private boolean akMemberVienna, akMemberAT;
    private boolean salary1800, salaryLess2500, salaryMore2500;

    //Handing over Properties-------------------------------------------------------------------------------------------
    public Waff(boolean liveInVienna, boolean workInVienna, boolean akMemberVienna, boolean akMemberAT,
                boolean salary1800, boolean salaryLess2500, boolean salaryMore2500) {
        this.liveInVienna = liveInVienna;
        this.workInVienna = workInVienna;
        this.akMemberVienna = akMemberVienna;
        this.akMemberAT = akMemberAT;
        this.salary1800 = salary1800;
        this.salaryLess2500 = salaryLess2500;
        this.salaryMore2500 = salaryMore2500;
    }

    //Adding Course to Map----------------------------------------------------------------------------------------------
    public void addCourse(){
        courses.put(1,c1);
        courses.put(2,c2);
        courses.put(3,c3);
        courses.put(4,c4);
        courses.put(5,c5);
    }

    //CourseGetter Logic Method-----------------------------------------------------------------------------------------
    public String getCourses () {
        int i = 1;
            if((login.getGender().equals("f"))&&(liveInVienna == true)&&(workInVienna == true)&& (akMemberVienna == true)
                   &&(salary1800==true)){
                return i++ + ". " + c1.info() + "\n\n" +
                       i++ + ". " + c3.info() + "\n\n" +
                       i++ + ". " + c4.info() + "\n\n" +
                       i++ + ". " + c5.info();
            }
            else if((login.getGender().equals("f"))&&(liveInVienna == true)&&(workInVienna == true)&&
                    (akMemberVienna == false)&&(akMemberAT == true)&&(salary1800==true)){
                return i++ + ". " + c1.info() + "\n\n" +
                       i++ + ". " + c3.info();
            }
            else if((liveInVienna == true)&&(workInVienna == true)&&(akMemberVienna == true)
                    && ((salary1800==true)||(salaryLess2500==true))){
                return i++ + ". " + c1.info() + "\n\n" +
                       i++ + ". " + c4.info() + "\n\n" +
                       i++ + ". " + c5.info();
            }
            else if((liveInVienna == false)&&(workInVienna == true)&&(akMemberVienna == true)
                    && ((salary1800==true)||(salaryLess2500==true))){
                return i++ + ". " + c2.info() + "\n\n" +
                       i++ + ". " + c4.info() + "\n\n" +
                       i++ + ". " + c5.info();
            }
            else if((liveInVienna == true)&&(workInVienna == false)&&(akMemberVienna == true)
                    && ((salary1800==true)||(salaryLess2500==true))){
                return i++ + ". " + c2.info() + "\n\n" +
                       i++ + ". " + c4.info() + "\n\n" +
                       i++ + ". " + c5.info();
            }
            else if((liveInVienna == false)&&(workInVienna == true)&&(akMemberAT == true)
                    && ((salary1800==true)||(salaryLess2500==true))){
                return c2.info();
            }
            else if((liveInVienna == true)&&(workInVienna == false)&&(akMemberAT == true)
                    && ((salary1800==true)||(salaryLess2500==true))){
                return c2.info();
            }
            else if((login.getGender().equals("f"))&&(liveInVienna == true)&&(workInVienna == true)&&(salary1800==true)&&
                    (akMemberVienna == false)&&(akMemberAT == false)){
                return c3.info();
            }
            else if(akMemberVienna == true){
                return i++ + ". " + c4.info() + "\n\n" +
                       i++ + ". " + c5.info();
            }
        return "Sorry, there are no courses for you.";
    }

    //Creating a conditionsList Methods---------------------------------------------------------------------------------
    public void addCondition(String pCondition){ conditions.add(pCondition); }

    public void deleteCondition(String pCondition){ conditions.remove(pCondition); }

    //ConditionsGetter Method-------------------------------------------------------------------------------------------
    public String getConditions() {
        String conditionsList = "";
        for (String list : conditions) {
            conditionsList += list;
        }
        return conditionsList;
    }
}