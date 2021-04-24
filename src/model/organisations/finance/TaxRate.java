package model.organisations.finance;

import model.organisations.finance.calc.Calc;
import model.organisations.finance.calc.percentAmount.PercentAmount;
import model.organisations.finance.calc.subtractionPercent.SubtractionPercent;
import model.organisations.finance.calc.subtraction.Subtraction;

public class TaxRate {
    //Properties--------------------------------------------------------------------------------------------------------
    private int minIncome;
    private int maxIncome;
    private int rate;

    //Handing over properties via Constructor---------------------------------------------------------------------------
    public TaxRate(int minIncome, int maxIncome, int rate) {
        this.minIncome = minIncome;
        this.maxIncome = maxIncome;
        this.rate = rate;
    }

    //Calculate Methods--------------------------------------------------------------------------------------------------
    public int betweenAmount(){
        Calc subtraction = new Subtraction();
        int taxSum = subtraction.calc(maxIncome, minIncome);
        return taxSum;
    }

    public int salaryTax(int pYourSalary){
        Calc subtraction = new Subtraction();
        int taxSum = subtraction.calc(pYourSalary, minIncome);
        return taxSum;
    }

    public int withoutTaxAmount(int maxIncome){
        Calc minusPercent = new SubtractionPercent();
        int taxSum = minusPercent.calc(maxIncome, rate);
        return taxSum;
    }

    public int percentAmount(){
        Calc percentAmount = new PercentAmount();
        int taxSum = percentAmount.calc(maxIncome, rate);
        return taxSum;
    }

    public int percentAmount(int maxIncome){
        Calc percentAmount = new PercentAmount();
        int taxSum = percentAmount.calc(maxIncome, rate);
        return taxSum;
    }

    //Getter Methods----------------------------------------------------------------------------------------------------
    public int getMinIncome() { return minIncome; }

    public int getMaxIncome() { return maxIncome; }

    public int getRate() { return rate; }

    //info Methods--------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "From " + minIncome + " to " + maxIncome + " euros -> " + rate + "%";
    }

    public String info(int betweenAmount){
        return "\nFor " + betweenAmount + " you pay " + rate + "% tax.";
    }
}
