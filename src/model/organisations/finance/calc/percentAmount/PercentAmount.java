package model.organisations.finance.calc.percentAmount;

import model.organisations.finance.calc.Calc;

public class PercentAmount implements Calc {
    @Override
    public int calc(int max, int rate) {
        return max*rate/100;
    }
}
