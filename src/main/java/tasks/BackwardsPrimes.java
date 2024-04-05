package tasks;

public class BackwardsPrimes {
    public static String getBackwardsPrimes(long start, long end) {
        StringBuilder result = new StringBuilder();
        for (long num = start; num <= end; num++) {
            if (isPrime(num) && isPrime(reverseNumber(num))) {
                result.append(num).append(" ");
            }
        }
        return result.toString().trim();
    }

    // Перевірка, чи є число простим
    private static boolean isPrime(long number) {
        if (number <= 1) {
            return false;
        }
        for (long i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Функція для отримання зворотнього числа
    private static long reverseNumber(long number) {
        long reverse = 0;
        while (number != 0) {
            reverse = reverse * 10 + number % 10;
            number = number / 10;
        }
        return reverse;
    }

    public static void main(String[] args) {
        System.out.println(getBackwardsPrimes(1, 73)); // "13 17 31 37 71 73"
        System.out.println(getBackwardsPrimes(9900, 10000)); // "9923 9931 9941 9967"
        System.out.println(getBackwardsPrimes(501, 599)); // ""
    }
}