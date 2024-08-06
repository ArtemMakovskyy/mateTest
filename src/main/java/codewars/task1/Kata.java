package codewars.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Kata {
    public static void main(String[] args) {
        System.out.println(stringMerge("jason", "samson", 's'));
    }
    public static String stringMerge(String s1, String s2, char letter) {
        int firstWordEnd = s1.indexOf(letter);
        int secondWordStart = s2.indexOf(letter);
        return s1.substring(0,firstWordEnd) + s2.substring(secondWordStart);
    }
    public static List<Object> filterList(final List<Object> list) {
        return list.stream()
                .filter(o -> o instanceof Integer)
                .collect(Collectors.toList());
    }
    public static int[] sortArray(int[] array) {
        List<Integer> oddNumbers = new ArrayList<>();
        for (int num : array) {
            if (num % 2 != 0) {
                oddNumbers.add(num);
            }
        }
        Collections.sort(oddNumbers);
        int oddIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                array[i] = oddNumbers.get(oddIndex);
                oddIndex++;
            }
        }
        return array;
    }

    public static String pattern(int n) {
        StringBuilder one = new StringBuilder().append(1);
        StringBuilder result = new StringBuilder();
        StringBuilder stars = new StringBuilder();
        result.append(one);
        if (n == 1) {
            return result.toString();
        }
        for (int i = 2; i <= n; i++) {
            stars.append("*");
            result.append(System.lineSeparator()).append(one).append(stars).append(i);
        }
        return result.toString();
    }

    public static int findEvenIndex(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int leftSum = 0;
            int rightSum = 0;
            for (int j = 0; j < i; j++) {
                leftSum += arr[j];
            }
            for (int k = i + 1; k < arr.length; k++) {
                rightSum += arr[k];
            }
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }

    public static int[] mergeArrays(int[] first, int[] second) {
        return IntStream.concat(IntStream.of(first), IntStream.of(second)).distinct().sorted().toArray();
    }
}
