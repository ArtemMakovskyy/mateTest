package main.java8.streamPractice;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


/*
Given a String input with some random characters.
Your task is to remove every letter having an odd
index and return the result in upper case.
Note that input will contain only letters
without numbers or punctuation.
[Input] - "random"
[Result] - "RNO"
 */
public class FilterAndModifyLetters {
    public String filterLetters(String input) {
        String inputInUpperCase = input.toUpperCase();

        IntStream.range(0, inputInUpperCase.length())
                .map(c -> c % 2 == 0 ? inputInUpperCase.toCharArray()[c] : 0)
                .filter(c -> c != 0)
                .mapToObj(c -> Character.toChars(c))
                .flatMap(Stream::of);
//                .forEach(System.out::println);

        Stream<Character> characterStream = input.chars()
                .mapToObj(e -> (char) e);
        List<Character> collect = characterStream.collect(Collectors.toList());
        System.out.println(collect);

        Stream<String> stringStream = IntStream.range(0, collect.size())
                .map(c -> c % 2 == 0 ? (char) collect.get(c) : 0)
                .filter(c -> c != 0)
                .mapToObj(s -> String.valueOf(s));

        List<String> collect1 = stringStream
                .collect(Collectors.toList());

        System.out.println(collect1);

        collect1.stream()
                .map(c -> Integer.parseInt(c))


                .forEach(System.out::println);

//                .mapToObj(s -> Character.toChars(s))
//                .collect(Collectors.toList())
//                .stream()
//                .flatMap(Stream::of)
//                .flatMap(Stream::of)


//                .forEach(System.out::println);


//                .filter(c -> c != "")
//                .collect(Collectors.toList());

//                .forEach(System.out::println);
//        IntStream.range(0,input.length())
//                .mapToObj()

        return "s";
    }
}