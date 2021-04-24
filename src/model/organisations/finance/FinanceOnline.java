package model.organisations.finance;

import java.util.*;

public class FinanceOnline {
    //Properties--------------------------------------------------------------------------------------------------------
    private int yourSalary;

    //taxProperties
    private final List<TaxRate> taxRateList = new ArrayList<TaxRate>();
    private TaxRate t1 = new TaxRate(0, 11000, 0);
    private TaxRate t2 = new TaxRate(11000, 18000, 20);
    private TaxRate t3 = new TaxRate(18000, 31000, 35);
    private TaxRate t4 = new TaxRate(31000, 60000, 42);
    private TaxRate t5 = new TaxRate(60000, 90000, 48);
    private TaxRate t6 = new TaxRate(90000, 1000000, 50);
    private TaxRate t7 = new TaxRate(1000000, 2000000, 55);

    //Adding tax rates to ArrayList-------------------------------------------------------------------------------------
    public void addTaxRate() {
        taxRateList.add(t1);
        taxRateList.add(t2);
        taxRateList.add(t3);
        taxRateList.add(t4);
        taxRateList.add(t5);
        taxRateList.add(t6);
        taxRateList.add(t7);
    }

    //TaxRateGetter Method----------------------------------------------------------------------------------------------
    public String getTaxRateList() {
        int i = 1;
        String rateList = "";
        for (TaxRate list : taxRateList) {
            rateList += "\n" + i++ + ". " + list;
        }
        return rateList;
    }

    //calculateRate Method----------------------------------------------------------------------------------------------
    public String getTaxSum(int pYourSalary){
        this.yourSalary=pYourSalary;

        if(yourSalary<=11000){
            return t1.info(t1.betweenAmount());
        }
        else if((11000<yourSalary)&&(yourSalary<=18000)){

            return t1.info(t1.betweenAmount()) +  //info about tax rates of static sum
                    "\nFor "+ t2.salaryTax(yourSalary) +" you pay " + t2.getRate() + "% tax." + //info about rate for the rest of your salary
                    "\n\nYour salary without income tax is approx. " +  // = static sums without tax + rest of your salary without tax
                    (t1.betweenAmount() + t2.withoutTaxAmount(t2.salaryTax(yourSalary)));
        }
        else if((18000<yourSalary)&&(yourSalary<=31000)){
            return t1.info(t1.betweenAmount()) + t2.info(t2.betweenAmount()) +
                    "\nFor "+ t3.salaryTax(yourSalary) +" you pay " + t3.getRate() + "% tax." +
                    "\n\nYour salary without income tax is approx. " +
                    (t1.betweenAmount() + t2.withoutTaxAmount(t2.betweenAmount()) + t3.withoutTaxAmount(t3.salaryTax(yourSalary)));
        }
        else if((31000<yourSalary)&&(yourSalary<=60000)){
            return t1.info(t1.betweenAmount()) + t2.info(t2.betweenAmount()) + t3.info(t3.betweenAmount()) +
                    "\nFor "+ t4.salaryTax(yourSalary) +" you pay " + t4.getRate() + "% tax." +
                    "\n\nYour salary without income tax is approx. " +
                    (t1.betweenAmount() + t2.withoutTaxAmount(t2.betweenAmount()) + t3.withoutTaxAmount(t3.betweenAmount()) +
                            t4.withoutTaxAmount(t4.salaryTax(yourSalary)));
        }
        else if((60000<yourSalary)&&(yourSalary<=90000)){
            return t1.info(t1.betweenAmount()) + t2.info(t2.betweenAmount()) + t3.info(t3.betweenAmount()) + t4.info(t4.betweenAmount()) +
                    "\nFor "+ t5.salaryTax(yourSalary) +" you pay " + t5.getRate() + "% tax." +
                    "\n\nYour salary without income tax is approx. " +
                    (t1.betweenAmount() + t2.withoutTaxAmount(t2.betweenAmount()) + t3.withoutTaxAmount(t3.betweenAmount()) +
                            t4.withoutTaxAmount(t4.betweenAmount()) + t5.withoutTaxAmount(t5.salaryTax(yourSalary)));
        }
        else if((90000<pYourSalary)&&(yourSalary<=1000000)){
            return t1.info(t1.betweenAmount()) + t2.info(t2.betweenAmount()) + t3.info(t3.betweenAmount()) + t4.info(t4.betweenAmount()) +
                    t5.info(t5.betweenAmount()) +
                    "\nFor "+ t6.salaryTax(yourSalary) +" you pay " + t6.getRate() + "% tax." +
                    "\n\nYour salary without income tax is approx. " +
                    (t1.betweenAmount() + t2.withoutTaxAmount(t2.betweenAmount()) + t3.withoutTaxAmount(t3.betweenAmount()) +
                            t4.withoutTaxAmount(t4.betweenAmount()) +  t5.withoutTaxAmount(t5.betweenAmount()) +
                            t6.withoutTaxAmount(t6.salaryTax(yourSalary)));
        }
        else if((1000000<yourSalary)){
            return t1.info(t1.betweenAmount()) + t2.info(t2.betweenAmount()) + t3.info(t3.betweenAmount()) + t4.info(t4.betweenAmount()) +
                    t5.info(t5.betweenAmount()) + t6.info(t6.betweenAmount()) +
                    "\nFor "+ t7.salaryTax(yourSalary) +" you pay " + t7.getRate() + "% tax." +
                    "\n\nYour salary without income tax is approx. " +
                    (t1.betweenAmount() + t2.withoutTaxAmount(t2.betweenAmount()) + t3.withoutTaxAmount(t3.betweenAmount()) +
                            t4.withoutTaxAmount(t4.betweenAmount()) +  t5.withoutTaxAmount(t5.betweenAmount()) +
                            t6.withoutTaxAmount(t6.betweenAmount()) + t7.withoutTaxAmount(t7.salaryTax(yourSalary)));
        }
        return "Sorry, there is problem with calculation of your salary.";
    }

}
