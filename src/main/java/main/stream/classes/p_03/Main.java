package main.stream.classes.p_03;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // 1 Using .stream()    !!!
        List<String> names = List.of("Alice", "Bob", "John");
        Consumer<String> consumer1 = s -> System.out.println(s);
        Consumer<String> consumer2 = System.out::println;
        names.stream().forEach(System.out::println);

        //2 Stream.of
        Stream.of(names).forEach(System.out::println);
        Stream.of("Alice", "Bob", "John").forEach(System.out::println);

        // 3 convert with array   Arrays.stream(cities)  !!!!!!
        String[] cities = new String[]{"Kyiv", "London", "Paris"};
        Arrays.stream(cities).forEach(System.out::println);

        // 4 chars
        String hello  ="Hello";
        hello.chars();

        // 5  Stream.generate(stringSupplier);
        Supplier<String>stringSupplier = () -> "sss";
        Stream.generate(stringSupplier);
        Stream.generate(new Random()::nextInt).limit(5).forEach(System.out::println);

        // 6 iterate
        Stream.iterate(0,i-> i + 2).limit(5).forEach(System.out::print);
//        Stream.iterate(5,1,10).limit(5).forEach(System.out::print);
        System.out.println();
        // 7 range
        System.out.println("range");
        IntStream.range(4,10).forEach(System.out::print);
    }
}
