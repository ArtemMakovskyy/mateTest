package reqursion.arkhipov;

import java.util.Arrays;

public class Sample {
    public static void main(String[] args) {
        int[] array = new int[2000];
        Arrays.setAll(array, i -> (int) (Math.random() * 255));
//        Arrays.setAll(array, i -> (int) i++);
//        Arrays.stream(array).forEach(System.out::println);

//        System.out.println(Arrays.stream(array).sum());
//        System.out.println(sumRecursion(0, 0, array));

//        System.out.println(Arrays.stream(array).sum());
//        System.out.println(sumArrayRecursion(array));

//        System.out.println(sumTo(5, 0));
        System.out.println(reverseString("abcde"));
    }

    static String reverseString(String text) {
        if (text.length() == 1) return text;
        return text.charAt(text.length() - 1) + reverseString(text.substring(0, text.length() - 1));
    }

    static int sumTo(int endNumber, int sum) {
        if (endNumber == 0) {
            return sum;
        }
        return endNumber + sumTo(endNumber - 1, sum);
    }

    static int sumArrayRecursion(int sum, int[] array, int position) {
        if (position == array.length) {
            return sum;
        } else {
            return sumArrayRecursion(
                    sum + array[position],
                    array,
                    position + 1);
        }
    }

    static int sumArrayRecursion(int[] array) {
        int position = 0;
        int sum = 0;

        if (position == array.length) {
            return sum;
        } else {
            return sumArrayRecursion(
                    sum + array[position],
                    array,
                    position + 1);
        }
    }

    static int sumRecursion(int i, int sum, int[] array) {
        if (i == array.length) {
            return sum;
        } else {
            return sumRecursion(i + 1, sum + array[i], array);
        }
    }
}
