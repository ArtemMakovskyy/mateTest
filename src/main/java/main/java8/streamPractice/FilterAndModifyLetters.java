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
        return IntStream.range(0, input.length())
                .mapToObj(c -> c % 2 == 0 ? input.toCharArray()[c] : 0)
                .filter(c -> c != 0)
                .map(ch -> String.valueOf(ch).toUpperCase())
                .collect(Collectors.joining());
    }
}