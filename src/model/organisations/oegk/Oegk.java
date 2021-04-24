package model.organisations.oegk;

import model.login.Login;
import java.util.*;

public class Oegk {
    //Properties--------------------------------------------------------------------------------------------------------
    private final List district= new ArrayList();
    private final ArrayList<String> offer = new ArrayList<>();

    private Login login = new Login();
    private String gender;
    private int age = login.getAge();

    //districtCreation Method-------------------------------------------------------------------------------------------
    public List getDistrict () {
        int districtNo = 23;
        for (int i = 1; i <= districtNo; i++) {
            district.add(String.valueOf(i));
        }
        return district;
    }

    //AgeGetter Logic Method--------------------------------------------------------------------------------------------
    public String getAge(){
        if(age<18) {
            return age + " (< 18 y.)";
        } else if((age>=18)&&(age<=49)) {
            return age + " (18-49 y.)";
        } else if((age>=50)&&(age<=64)) {
            return age + " (50-64 y.)";
        } else if (age>=65){
            return age + " (> 65 y.)";
        }
        return "";
    }

    //GenderGetter Logic Method-----------------------------------------------------------------------------------------
    public String getGender(){
        if(login.getGender().equals("f")) {
            gender = "female";
            return gender;
        } else if (login.getGender().equals("m")){
            gender = "male";
            return gender;
            }
        return gender;
    }

    //Adding Offers to ArrayList----------------------------------------------------------------------------------------
    public void addOffers() {
        offer.add("interview to identify chronic non-communicable diseases and risk factors");
        offer.add("measurement of height and body weight, calculation of body mass index (BMI)");
        offer.add("heart ECG + transcript");
        offer.add("blood pressure measurement");
        offer.add("blood test: clinical blood test, determination of cholesterol and blood glucose levels");
        offer.add("urine analysis");
        offer.add("detection of gum disease");

        //Offers Logic--------------------------------------------------------------------------------------------------
        if((login.getAge()>=65)&&(login.getGender().equals("f"))){
            offer.add("smear for cancer");
            offer.add("colon cancer screening, stool blood test, colonoscopy every 10 years");
            offer.add("detection of hearing and vision impairments");
        }
        else if ((login.getAge()>=50)&&(login.getGender().equals("f"))){
            offer.add("smear for cancer");
            offer.add("colon cancer screening, stool blood test, colonoscopy every 10 years");
        }
        else if(login.getAge()>=65){
            offer.add("colon cancer screening, stool blood test, colonoscopy every 10 years");
            offer.add("detection of hearing and vision impairments");
        }
        else if(login.getGender().equals("f")) {
            offer.add("smear for cancer");
        }
        else if(login.getAge()>=50){
            offer.add("colon cancer screening, stool blood test, colonoscopy every 10 years");
        }
    }

    //OfferGetter Method------------------------------------------------------------------------------------------------
    public String getOffer() {
        String offerList = "";
        for (String list : offer) {
            offerList += "\n -> " + list;
        }
        return offerList; }
}
