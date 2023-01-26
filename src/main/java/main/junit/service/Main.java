package main.junit.service;

public class Main {
    public static void main(String[] args) {
        Calc calc = new Calculator();
        System.out.println(calc.calculator(5, 5, "+"));
        System.out.println(calc.calculator(5, 2, "-"));
        System.out.println(calc.calculator(20, 5, "/"));
        System.out.println(calc.calculator(5, 5, "*"));
        System.out.println(calc.calculator(Integer.MAX_VALUE, -1, "+"));

        String s = "asdfsa@gmail.com";
        String s2 = "asdfsagmail.com";
        char c = '@';

        System.out.println(s2.indexOf(c));
    }
}
