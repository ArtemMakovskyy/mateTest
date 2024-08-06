package web.inf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        Object o = new Object();


        int[] arr = new int[]{1, 2, 36, 5, 54, 78, 45};
        final List<Integer> collect = Arrays.stream(arr).boxed().collect(Collectors.toList());

        List<String> sentences = Arrays.asList("Hello world", "FlatMap example");
        List<String> words = sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .collect(Collectors.toList());

        words.forEach(System.out::println);

    }
}
