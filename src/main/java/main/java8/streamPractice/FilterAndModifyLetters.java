package main.java8.streamPractice;


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

        return "s";
    }
}