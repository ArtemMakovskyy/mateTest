package work.task;

import work.task.task2.CityService;

import java.math.BigInteger;
import java.util.Scanner;

public class Tasks {
    public static void main(String[] args) {
//        task1FindCorrectNumberBracketsExpressions();
//        task2();
        task3CalculateFactorialThenCalculateSumOfDigitsOfNumberOfFactorial(100);
    }

    /**
     * Task to calculate the number of correct bracket expressions
     * using Catalan numbers.
     */
    public static void task1FindCorrectNumberBracketsExpressions() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Task 1\nEnter the number of pairs of brackets: ");
        int n;
        while (true) {
            try {
                n = Integer.parseInt(scanner.nextLine());
                if (n <= 0) {
                    System.out.print("Number should be not 0 and non-negative: ");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid integer: ");
            }
        }
        System.out.println("Number of correct bracket expressions is: "
                + calculateBracketByCatalanFormula(n));
    }

    public static void task2() {
        CityService.findMinCostBetweenCities("gdansk", "warszawa");
        CityService.findMinCostBetweenCities("bydgoszcz", "warszawa");
    }

    public static void task3CalculateFactorialThenCalculateSumOfDigitsOfNumberOfFactorial(int n) {
        /*
                Find the sum of the digits in the number 100! (i.e. 100 factorial)         {Correct answer: 648}
        */
        System.out.println("\nTask 3\nSum fo digits of factorial of number " + n + " is: " +
                calculateSumOfDigitsOfNumber(
                        calculateFactorial(n)
                )
        );
    }

    /**
     * Calculates the nth Catalan number using the formula:
     * C_n = (2n)! / ((n + 1)! * n!)
     *
     * @param n Number of bracket pairs
     * @return The number of correct bracket expressions
     */
    private static BigInteger calculateBracketByCatalanFormula(int n) {
        return calculateFactorial(2 * n)
                .divide(calculateFactorial(n + 1)
                        .multiply(calculateFactorial(n)));
    }

    /**
     * Calculates the factorial of a given number.
     *
     * @param n The number to calculate the factorial for
     * @return The factorial of n
     */
    private static BigInteger calculateFactorial(int n) {
        if (n == 0) {
            return BigInteger.ZERO;
        }
        BigInteger factorial = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }

    private static int calculateSumOfDigitsOfNumber(BigInteger number) {
        return number
                .toString() // use string conversion to use each number separately in the array
                .chars()
                .map(digit -> digit - '0') // convert from char number to real number
                .sum();
    }
}
