package model.organisations.waff;

public class Courses {
    //Properties--------------------------------------------------------------------------------------------------------
    private String name,financing,specialization;
    private int maxSum;

    //Handing over properties via Constructor---------------------------------------------------------------------------
    public Courses(String name, String financing, String specialization, int maxSum) {
        this.name = name;
        this.financing = financing;
        this.specialization = specialization;
        this.maxSum = maxSum;
        }

    //toString Method---------------------------------------------------------------------------------------------------
    public String info(){
        return name + ": " + specialization
                + "\n" + financing
                + "\nThe maximum amount of funding: " + maxSum + " Euro";
    }
}
