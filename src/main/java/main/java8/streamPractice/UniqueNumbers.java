package main.java8.streamPractice;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<Character> getUniqueNumbers(String sourceNumber) {
        return sourceNumber.chars()
                .mapToObj(c -> (char) c)
                .distinct()
                .collect(Collectors.toList());
    }
}
