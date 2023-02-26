package main.java8.streamPractice;


import java.util.List;
import java.util.stream.Collectors;

public class SortNames {

    public static List<String> sortNames(List<String> names) {
        return names.stream()
                .sorted()
                .limit(3)
                .collect(Collectors.toList());
    }
}


