package main.pattern.factorial;

public class FibonacciSequence {
    private static int firstInt = 0;
    private static int secondInt = 1;
    private static int result = 1;
    private static int times = 0;

    public int getFibonacciNumber(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        times++;
        result = firstInt + secondInt;
        return result;
    }

    public int getFibonacciNumberRec(int n) {
        if ((n == 0) || (n == 1)) {
            return n;
        } else {
            return getFibonacciNumberRec(n - 1) + getFibonacciNumberRec(n - 2);
        }
    }

    public int getFibonacciNumberFor(int n) {
        if (n <= 0) {
            return 0;
        }
        int result = 0;
        int firstInt = 0;
        int secondInt = 1;
        for (int i = 0; i < n - 1; i++) {
            result = firstInt + secondInt;
            firstInt = secondInt;
            secondInt = result;
        }
        return result;
    }
}
