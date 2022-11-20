package main.pattern.factorial;

public class Main {
    public static void main(String[] args) {
        Factorial factorial = new Factorial();
//        System.out.println(factorial.getFactorial(6));

        FibonacciSequence fibonacciSequence = new FibonacciSequence();
//        System.out.println(fibonacciSequence.getFibonacciNumber(3));
        System.out.println(fibonacciSequence.getFibonacciNumberRec(8));


    }
}
