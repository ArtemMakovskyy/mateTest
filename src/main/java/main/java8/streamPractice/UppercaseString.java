package main.java8.streamPractice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Implement a method getUppercaseString() that accepts an array of strings sourceStrings and returns a list of strings where:

every string starts with a lowercase letters 'a' or 'b'
every string length is at least 3
Return these strings in uppercase.

Examples:

[Input]: new String[]{"b"}
[Result]: List.of();

[Input]: new String[]{"abc"}
[Result]: List.of("ABC");

[Input]: new String[]{"aaa", "bbbb", "ccccc"}
[Result]: List.of("AAA", "BBBB")

IMPORTANT! You should solve this task using Stream API only.
 */
public class UppercaseString {
    public  List<String> getUppercaseString(String[] sourceStrings) {
        return Arrays.stream(sourceStrings)
                .filter(c -> c.startsWith("a") || c.startsWith("b"))
                .filter(c -> c.length() > 2)
                .map(c -> c.toUpperCase())
                .collect(Collectors.toList());
    }
}