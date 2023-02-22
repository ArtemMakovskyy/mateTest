package main.java8.stream.classes.p01_02;

import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainStream_02 {
    public static void main(String[] args) {
        List<String> names = List.of("Alice","Bob","John");
        Stream<String> streamNames = names.stream();
        //IntStream
        //LongStream
        //DoubleStream
        IntStream intStream = streamNames.mapToInt(s -> s.length());
        OptionalInt max = intStream.max();
        System.out.println(max);
        intStream.mapToObj(i -> String.valueOf(i));


//        OptionalInt min = intStream.min();
//        OptionalInt max = intStream.max();
//        int sum = intStream.sum();
//        Stream<String> objectStream = intStream.mapToObj(String::valueOf);


    }
}
