package model.organisations.finance.calc.subtraction;

import model.organisations.finance.calc.Calc;

public class Subtraction implements Calc {
    @Override
    public int calc(int x,int y){
        return x - y;
    }
}
