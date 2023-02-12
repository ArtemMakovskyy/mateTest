package main.stream.classes.func_int_Extra.range;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Primi {
    public static void main(String[] args) {
        Stream.generate(new Random()::nextInt).limit(5).forEach(System.out::println);
        Stream.iterate(0, i -> i + 23).limit(4).forEach(System.out::println);

        IntStream.range(4, 10).forEach(System.out::print);
        System.out.print(" closed ");
        System.out.println("_");
        IntStream.rangeClosed(4, 10).map(i -> i*2).forEach(System.out::println);
    }
}
