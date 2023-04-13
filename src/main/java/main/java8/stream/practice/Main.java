package main.java8.stream.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        e2();
Object o = 132;
    }
    static void e2() {
        String[] name = new String[]{"Artem", "Ivan", "Boris", "Kyiv", "London", "Paris"};
        List<String> collect = IntStream.iterate(0, index -> index + 2)
                .limit(name.length / 2)
                .mapToObj(index -> name[index])
                .collect(Collectors.toList());
    }

    static void e() {
        String[] name = new String[]{"Artem", "Ivan", "Boris", "Kyiv", "London", "Paris"};
        List<String> collect = IntStream.range(0, name.length)
                .mapToObj(index -> name[index])
                .collect(Collectors.toList());

        System.out.println("");
        IntStream.range(0, name.length)
                .mapToObj(index -> index % 2 == 0 ? name[index] : "")
                .filter(p -> !p.equals(""))
                .forEach(System.out::println);

    }

    static void d() {
        Stream
                .iterate(10, i -> i + 10).limit(5)
                .forEach(System.out::println);

        Stream.generate(() -> "SSS").limit(5).forEach(System.out::println);
        Stream.generate(new Random()::nextInt).limit(5).forEach(System.out::println);

        IntStream.range(0, 5).forEach(System.out::println);


        String[] name = new String[]{"Artem", "Ivan", "Boris", "Kyiv", "London", "Paris"};
        Stream.iterate(0, i -> i + 1).limit(name.length)
                .map(index -> name[index])
                .forEach(System.out::println);
    }

    static void c() {
        List<String> names = List.of("Alice", "Bob", "John");
        Stream<String> stream = names.stream();
        IntStream intStream = stream.mapToInt(c -> c.length());
        Stream<Character> characterStream = intStream.mapToObj(c -> (char) c);
        characterStream.forEach(System.out::println);
    }

    static void b() {
        String[] name = new String[]{"Artem", "Ivan", "Boras"};
        Arrays.stream(name)
                .filter(s -> s.startsWith("a", s.length() - 2))
                .forEach(System.out::println);
    }

    static void a() {
        String[] name = new String[]{"Artem", "AIvan", "Boris"};
        for (int i = 0; i < name.length; i++) {
            if (name[i].startsWith("A", 4)) {
                System.out.println(name[i]);
            }
        }
    }
}
