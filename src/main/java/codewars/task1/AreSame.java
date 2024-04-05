package codewars.task1;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AreSame {
    public static void main(String[] args) {

        System.out.println(oddOrEven(new int[]{2, 5, 34, 6}));

    }

    public static String oddOrEven(int[] array) {
        if (array.length == 0){
            return "even";
        }
        return IntStream.of(array).sum() > 0 ? "odd" : "even";
    }

    public static String camelCase(String str) {
        if (str.equals("")) {
            return "";
        }
        str = str.trim();
        str = str.replaceAll("\\s+", " ");
        return Arrays.stream(str.split(" "))
                .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1))
                .collect(Collectors.joining());
    }

    public static boolean comp(int[] a, int[] b) {
        if (a == null || b == null || a.length != b.length) return false;
        int[] arrayA = IntStream.of(a).sorted().map(d -> d * d).toArray();
        int[] arrayB = IntStream.of(b).sorted().toArray();
        return Arrays.equals(arrayA, arrayB);
    }
}