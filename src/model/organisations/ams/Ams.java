package model.organisations.ams;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Ams {
    //calendarProperties------------------------------------------------------------------------------------------------
    private final List days= new ArrayList();
    private final List months= new ArrayList();
    private final List years= new ArrayList();

    //calendarCreation Methods------------------------------------------------------------------------------------------
    public List calendarDays () {
        int currentDay =31;
        for (int i = 1; i <= currentDay; i++) {
            days.add(String.valueOf(i));
        }
        return days;
    }

    public List calendarMonths () {
        int currentMonth = 12;
        for (int i = 1; i <= currentMonth; i++) {
            months.add(String.valueOf(i));
        }
        return months;
    }

    public List calendarYears () {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = currentYear; i > currentYear - 100; i--) {
            years.add(String.valueOf(i));
        }
        return years;
    }

    //calendar Logic - never apply for AMS------------------------------------------------------------------------------
    public String calculateWork1(LocalDate workBegin, LocalDate workEnd, int age) {
        Period p = Period.between(workBegin, workEnd);
        long p2 = ChronoUnit.DAYS.between(workBegin, workEnd);
            if (workBegin.isAfter(workEnd)) {
                return "Please correct the date of start.";
            }
            else if ((workBegin != null)&&(workEnd != null)&&(p2 > 364)){
                return  "Your period of work is " + p.getYears() + " years, " + p.getMonths() +
                        " months, and " + p.getDays() +
                        " days. \nYou have worked enough to apply for unemployment benefits the first time.";
            }
            else if ((p2 < 364) && (age > 25)) {
                return "Your period of work is " + p.getYears() + " years, " + p.getMonths() +
                        " months, and " + p.getDays() + " days. " +
                        "\nIt's less then 52 Weeks." + "You must have worked for at least 52 weeks in " +
                        "the last 2 years to be eligible for unemployment benefits.";
            }
            else if ((workBegin != null)&&(workEnd != null)&&(p2 < 364)&&(p2 >= 182)&&(age >= 18)&&(age <= 25)) {
                return "Your period of work is " + p.getYears() + " years, " + p.getMonths() +
                        " months, and " + p.getDays() + " days. " +
                        "\nYou have worked enough to apply for unemployment benefits the first time.";
            }
            return "Please provide correct dates.";
    }

    //calendar Logic - already applied for AMS--------------------------------------------------------------------------
    public String calculateWork2(LocalDate workBegin, LocalDate workEnd) {
        Period p = Period.between(workBegin, workEnd);
        long p2 = ChronoUnit.DAYS.between(workBegin, workEnd);
            if (workBegin.isAfter(workEnd)) {
                return "Please correct the date of start.";
            }
            else if((workBegin != null)&&(workEnd != null)&&(p2>196)) {
                return "Your period of work is " + p.getYears() +
                        " years, " + p.getMonths() + " months, and " + p.getDays() +
                        " days. \nYou have worked enough to be able to receive unemployment benefits again.";
            }else{
                return "Your period of work is " + p.getYears() +
                        " years, " + p.getMonths() + " months, and " + p.getDays() +
                        " days. \nIt's less then 28 weeks. " + "If you are applying for unemployment benefits for the "+
                        "second time or more often, period of 28 weeks of work in the last year is sufficient ";
            }
    }
}
