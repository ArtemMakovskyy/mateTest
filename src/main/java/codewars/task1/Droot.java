package codewars.task1;

import java.util.stream.IntStream;

public class Droot {
    public static void main(String[] args) {
        System.out.println(digital_root(942));
    }

    public static int digital_root(int n) {
        String numberAsString = String.valueOf(n);
        while (numberAsString.length() != 1) {
            int[] ints = numberAsString.chars()
                    .map(Character::getNumericValue)
                    .toArray();
            n = IntStream.of(ints).sum();
            numberAsString = String.valueOf(n);
        }
        return n;
    }
}