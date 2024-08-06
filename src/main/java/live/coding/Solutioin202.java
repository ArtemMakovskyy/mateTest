package live.coding;

public class Solutioin202 {
    public static void main(String[] args) {
//        System.out.println(isHappy(2));
        System.out.println(isHappy(2));
    }

    public static boolean isHappy(int n) {
        int firstValue = n;
        int secondValue = getNextNumber(n);

        while (secondValue != 1 && firstValue != secondValue) {
            firstValue = getNextNumber(firstValue);
//            System.out.println("getNextNumber(firstValue) " + getNextNumber(firstValue));
//            System.out.println("getNextNumber(secondValue) " + getNextNumber(secondValue));
//            System.out.println("getNextNumber(getNextNumber(secondValue) " + getNextNumber(getNextNumber(secondValue)));
            secondValue = getNextNumber(getNextNumber(secondValue));
            System.out.println(firstValue + ", " + secondValue);
        }

        return secondValue == 1;
    }

    private static int getNextNumber(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        System.out.println("totalSum " + totalSum);
        return totalSum;
    }

    public static boolean isHappy2(int n) {
        int operations = 0;
        int firstValue = n;
        int secondValue = devideByDigits(n);
        while (firstValue != secondValue && secondValue != 1) {
            System.out.println(firstValue + ", " + secondValue);
            firstValue = devideByDigits(secondValue);
            secondValue = devideByDigits(firstValue);
            operations++;
            if (operations > 100) {
                break;
            }
        }
        if (secondValue == 1) {
            return true;
        }
        return false;
    }

    private static int devideByDigits(int n) {
        int numbersCount = String.valueOf(n).length();
        int[] digits = new int[numbersCount];
        for (int i = 0; i < digits.length; i++) {
            digits[i] = n % 10;
            n = n / 10;
        }
        return result(digits);
    }

    private static int result(int[] arr) {

        int result = 0;
        for (int i : arr) {
            result += i * i;
        }
        return result;
    }
}
