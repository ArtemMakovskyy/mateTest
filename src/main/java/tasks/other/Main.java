package tasks.other;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>(List.of(1, 2, 3));
        integers.forEach(c -> System.out.println(c + 1));
        System.out.println();
        integers.stream()
                .filter(number -> number % 2 == 0)
                .forEach(System.out::println);

    }
}
