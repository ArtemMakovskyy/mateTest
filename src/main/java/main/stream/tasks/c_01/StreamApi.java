package main.stream.tasks.c_01;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApi {
//    https://highload.today/java-stream-api/

    /**
     * Given a List of Integer numbers,
     * return a sum of odd numbers or 0, if there are no odd numbers in the List.
     */
    public Integer getOddNumsSum(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 != 0)
                .reduce((num1, num2) -> (num1 + num2)).orElse(0);
//        .reduce(0, Integer::sum);
    }

    public Integer get___OddNumsSum2(List<Integer> numbers) {
        long sum = numbers.stream()
                .filter(n -> n % 2 != 0)
                .collect(Collectors.summarizingInt(Integer::intValue)).getSum();
        return Math.toIntExact(sum);
    }

    public Integer get___OddNumsSum3(List<Integer> numbers) {
        int sum = numbers.stream()
                .filter(n -> n % 2 != 0)
                .mapToInt(s -> Integer.valueOf(s)).sum();
        return sum;
    }

    /**
     * Given a List of Strings,
     * return a number of times the `element` String occurs in the List.
     */
    public Long calculateOccurrences(List<String> elements, String element) {
        Long collect = elements.stream()
                .filter(el -> el.equals(element))
                .count();
        return collect;
    }

    /**
     * Given a List of Strings, return the Optional of its first element.
     */
    public Optional<String> getFirstElement(List<String> elements) {
        Optional<String> first = elements.stream()
                .findFirst();
        return first;
    }

    /**
     * Given a arrays of ints, return three smallest numbers as list in sorted manner.
     * For example for input {4, 1, 10, 20, 11, 3} output will be {1, 3, 4};
     */
    public List<Integer> getThreeSmallestNumbers(int[] numbers) {
        return Arrays.stream(numbers)
                .sorted()
                .limit(3)
                .boxed()
                .collect(Collectors.toList());
    }


    /**
     * Given a List of Strings,
     * find the String equal to the passed `element` or throw NoSuchElementException.
     */
    public String findElement(List<String> elements, String element) {
        Optional<String> first = elements.stream().filter(el -> el.equals(element))
                .findFirst();
        return first.get();

    }
}
