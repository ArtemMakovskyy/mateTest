package main.pattern.factorial;

public class Factorial {
    public static void main(String[] args) {
//        factorial(10);
        fibonachi(12);
    }

    static void fibonachi(int number) {
        int number1 = 0;
        int number2 = 1;
        int result = 0;
        for (int i = 2; i <= number; i++) {
            result = number1 + number2;

        }
        System.out.println(result);
    }

    static void factorial(int number) {
        int result = 1;

        for (int i = 1; i <= number; i++) {
            result = result * i;
            System.out.println("i = " + i + "res" + result);
        }
        System.out.println(result + " res");
    }
}
