package main.excersise;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> data = new HashMap<>();
        data.put("myhelloworld", 4);
        data.put("Hello", 7);
        data.put("AwesomeString", 8);
        data.put("Wow!!!! HELLO", 9);
        int var = calculateSum(data, "hello");

        System.out.println(var);

    }

    public static int calculateSum(Map<String, Integer> data, String keyPart) {
        int[] arrInt = new int[data.size()];
        int i = 0;
        int clearIndex = -1;
        if (data.isEmpty()) {
            return 0;
        }
        int sum = 0;
        if (keyPart == "") {
            for (Map.Entry<String, Integer> entry : data.entrySet()) {
                sum += entry.getValue();
            }
            return sum;
        } else {
            for (Map.Entry<String, Integer> entry : data.entrySet()) {
                String s = entry.getKey().toLowerCase(Locale.ROOT);
                if (keyPart.equals(s)) {
                    clearIndex = i + 1;
                }
                arrInt[i] = entry.getValue();
                i++;
            }
            arrInt[clearIndex] = 0;
            for (int j = 0; j < arrInt.length; j++) {
                sum = sum + arrInt[j];
            }
            System.out.println(Arrays.toString(arrInt));
        }
        return sum;
    }

    public static boolean isArrayPretty(int[] array) {
        if (array.length == 0) {
            return false;
        }
        boolean[] result = new boolean[array.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = false;
        }
        int digit = 0;
        for (int i = 0; i < array.length; i++) {
            digit = array[i];
            for (int j = 0; j < array.length; j++) {
                if (digit == array[j] - 1) {
                    result[i] = true;
                } else if (digit == array[j] + 1) {
                    result[i] = true;
                }
            }
        }
        for (int i = 0; i < result.length; i++) {
            if (result[i] == false) {
                return false;
            }
        }
        return true;
    }

    public static int[][] addMatrix(int[][] first, int[][] second) {
        int[][] matrix = first;
        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < first[i].length; j++) {
                matrix[i][j] = first[i][j] + second[i][j];
            }
        }
        return matrix;
    }

    public static int[] first() {
        int[] matrix = {2, 10, 3, 9};
        return matrix;
    }

    public static int[] second() {
        int[] matrix = {222, 10, 3, 9};
        return matrix;
    }

    public static int[] clear() {
        int[] matrix = new int[5];
        return matrix;
    }

    public static int[][] firstM() {
        int[][] matrix = new int[3][3];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                matrix[i][j] = i + j * 2;
        return matrix;
    }

    public static int[][] secondM() {
        int[][] matrix = new int[3][3];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                matrix[i][j] = ((i + 5) + j);
        return matrix;
    }

    public static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println();
            for (int j = 0; j < matrix[i].length; j++)
                System.out.print(matrix[i][j]);
        }
    }

    public static int countOccurrences(String str, String substr) {
        StringBuilder sb = new StringBuilder(str);
        int lengthSubstr = substr.length();
        int startPosition = str.lastIndexOf(substr);
        int endPosition = startPosition + lengthSubstr;
        int count = 0;
        while (startPosition != -1) {
            System.out.println("first if");
            sb.delete(startPosition, endPosition);
            startPosition = sb.lastIndexOf(substr);
            System.out.println(startPosition);
            endPosition = startPosition + lengthSubstr;
            count++;
        }
        return count;
    }

    public static int[] toArrayOfDigits(int n) {
        int i = n > 0 ? n : n * -1;
        int arrSize = 0;
        while (i != 0) {
            arrSize++;
            i = i / 10;
        }
        i = n > 0 ? n : n * -1;
        int[] intArr = new int[arrSize];
        for (int j = 0; j < arrSize; j++) {
            intArr[j] = i % 10;
            i = i / 10;
        }
        return intArr;
    }
}
