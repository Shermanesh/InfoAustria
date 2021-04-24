package model.organisations.finance.calc.subtractionPercent;

import model.organisations.finance.calc.Calc;

public class SubtractionPercent implements Calc {
    @Override
    public int calc(int between, int rate) {
        return between*(100-rate)/100;
    }
}
