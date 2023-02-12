package main.stream.classes.p_08;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> cities = List.of("Kyiv", "London", "Paris", "Oslo");
        Stream<String> stream = cities.stream();
        Stream<IntStream> intStreamStream = stream.map(s -> s.chars());
        Stream<Integer> integerStream = intStreamStream.flatMap(d -> d.boxed());
        IntStream intStream = integerStream.mapToInt(i -> i);
        Stream<Character> characterStream = intStream.mapToObj(i -> (char) i);
        Set<Character> uniqueCharacters = characterStream.collect(Collectors.toSet());
        System.out.println(uniqueCharacters + "\n");




    }
}

