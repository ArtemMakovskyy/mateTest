package main.junit.service;

public class Calculator implements Calc {
    @Override
    public double calculator(int a, int b, String operator) {
        if (operator.equals("+")) {
            return a + b;
        }
        if (operator.equals("-")) {
            return a - b;
        }
        if (operator.equals("/")) {
            return a / b;
        }
        if (operator.equals("*")) {
            return a * b;
        }
        return 0;
    }
}
