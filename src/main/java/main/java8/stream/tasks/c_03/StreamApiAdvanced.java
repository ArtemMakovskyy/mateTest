package main.java8.stream.tasks.c_03;


import java.util.*;
import java.util.stream.Collectors;

public class StreamApiAdvanced {
    /**
     * Given array of numbers, your task is to sort them in the reverse order and return only those
     * numbers that can be divided by 5 without a remainder.
     */
    public List<Integer> filterAndReverse(int[] inputNumbers) {
        return Arrays.stream(inputNumbers).filter(c -> c % 5 == 0)
                .mapToObj(c -> c)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    /**
     * We want to gather some statistics: we have list of people and we want to know
     * distribution among the age of women who have cats and are older than 18
     * Result should have the following view: Map.of(19 - List.of(person1, person2, ...),
     * 21 - List.of(person3, person7, ...);
     */
    public Map<Integer, List<Person>> groupByAge(List<Person> people) {
        return people.stream()
                .filter(w -> w.getSex().equals(Person.Sex.WOMAN)
                        && w.getAge() >= 18
                        && !w.getCatList().isEmpty())
                .collect(Collectors.groupingBy(Person::getAge));
    }

    /**
     * Given a list of random strings, group all of them by the last letter from the
     * string. If last char is a number or punctuation - skip the word.
     */
    public Map<Character, List<String>> groupWordsByLastChar(List<String> words) {
        Map<Character, List<String>> collect = words.stream()
                .filter(w -> Character.isAlphabetic(w.charAt(w.length() - 1)))
                .collect(Collectors.groupingBy(w -> w.charAt(w.length() - 1)));
        return collect;
    }
}
