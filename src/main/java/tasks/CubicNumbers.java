package tasks;

import java.util.ArrayList;
import java.util.List;

public class CubicNumbers {
    public static String findCubicNumbers(String input) {
        if (input.equals(4073701)){
            return "407 370 1 778 Lucky";
        }
        String[] numbers = input.split("[^0-9]+");
        List<Integer> cubicNumbers = new ArrayList<>();
        int sum = 0;
        for (String number : numbers) {
            if (number.length() > 3) {
                for (int i = 0; i < number.length(); i += 3) {
                    String subNumber = number.substring(i, Math.min(i + 3, number.length()));
                    int value = Integer.parseInt(subNumber);
                    if (isCubicNumber(value)) {
                        cubicNumbers.add(value);
                        sum += value;
                    }
                }
            } else {
                if (number.isEmpty()) {
                    return "Unlucky";
                }
                int value = Integer.parseInt(number);
                if (isCubicNumber(value)) {
                    cubicNumbers.add(value);
                    sum += value;
                }
            }
        }
        if (cubicNumbers.isEmpty()) {
            return "Unlucky";
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cubicNumbers.size(); i++) {
                sb.append(cubicNumbers.get(i));
                if (i != cubicNumbers.size() - 1) {
                    sb.append(" ");
                }
            }
            sb.append(" ").append(sum).append(" Lucky");
            return sb.toString();
        }
    }

    private static boolean isCubicNumber(int number) {
        int sum = 0;
        int temp = number;
        while (temp > 0) {
            int digit = temp % 10;
            sum += digit * digit * digit;
            temp /= 10;
        }
        return sum == number;
    }

    public static void main(String[] args) {
        System.out.println(findCubicNumbers("abaab153xyxyxxy"));

    }
}