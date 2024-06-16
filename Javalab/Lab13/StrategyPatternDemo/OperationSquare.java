package StrategyPatternDemo;

public class OperationSquare implements Strategy
{
    public int doOperation (int num1, int num2){
        return num1 * num1 + num2 * num2;
    }
}

