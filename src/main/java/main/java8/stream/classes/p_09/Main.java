package main.java8.stream.classes.p_09;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        System.out.println(getFirst('O'));
    }

    private static String getFirst(char letter) {
        List<String> cities = List.of("Kyiv", "London", "Paris", "Oslo");
        Optional<String> first = cities.stream()
                .filter(s -> s.charAt(0) == letter)
//                .findFirst();
                .findAny();
//        return first.get();
        return first.orElseThrow(() -> new RuntimeException("ex"));

    }
}
