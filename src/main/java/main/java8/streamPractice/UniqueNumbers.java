package main.java8.streamPractice;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
Implement a method getUniqueNumbers()
that accepts a string sourceNumber and
returns a list with all unique numbers
 as chars from this string.
 [Input]: "1"
[Result]: List.of('1');
[Input]: "4444"
[Result]: List.of('4');
[Input]: "987"
[Result]: List.of('9', '8', '7');

 */
public class UniqueNumbers {
    public  List<Character> getUniqueNumbers(String sourceNumber) {
        // write code here
        char[] chars = sourceNumber.toCharArray();
        Arrays.asList(chars);


        IntStream chars1 = sourceNumber.chars();
        Stream<Character> characterStream = chars1.mapToObj(c -> (char) c);
        characterStream.collect(Collectors.toSet());


        List<Character> collect = sourceNumber.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet())
                .stream().collect(Collectors.toList());


        List<Character> collect1 = collect.stream().collect(Collectors.toList());
//        System.out.println(Arrays.toString(chars));

        return null;
    }
}
