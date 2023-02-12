package main.stream.classes.mapToOb;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class Main {
    public static void main(String[] args) {
//        _1();
//        _2();
//        _3();
//        _4();
        _4_copy();
        _5();
    }

    static void _5() {
        List<String> combined = new ArrayList<>();
        combined.add("car - plane");
        combined.add("book - home");
        combined.add("flight - game");

        List<String[]> splitted = combined.stream()
                .map(words -> words.split(" - "))
                .collect(Collectors.toList());

        List<String> words = new ArrayList<>();
        for (String[] el : splitted)
            for(String word : el)
                words.add(word);

        System.out.println(words);

        List<String> words2 = combined.stream()
                .flatMap(pair -> Stream.of(pair.split(" - ")))
                .collect(Collectors.toList());
        System.out.println(words);
    }

    static void _4_copy() {
        String[] array = {"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null};

        Stream<List<String>> iterate = Stream.iterate(Arrays.asList(array), list -> list.subList(2, list.size()));
        Stream<List<String>> limit = iterate.limit(array.length / 2);
        LinkedHashMap<String, String> map = limit.collect(toMap(
                list -> list.get(0) == null ? "null" : list.get(0),
                list -> list.get(1) == null ? "null" : list.get(1),
                (x, y) -> y, () -> new LinkedHashMap<String, String>()));

        map.entrySet().forEach(System.out::println);
    }

    static void _4() {
        String[] array = {"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null};

        Map<String, String> map = Stream.iterate(
                        Arrays.asList(array), list -> list.subList(2, list.size()))
                .limit(array.length / 2)
                .collect(Collectors.toMap(
                        list -> list.get(0) == null ? "null" : list.get(0),
                        list -> list.get(1) == null ? "null" : list.get(1),
                        (x, y) -> y, LinkedHashMap::new));

        map.entrySet().forEach(System.out::println);
    }

    static void _3() {
        List<User> items = Arrays.asList(new User("One"), new User("Two"), new User("Three"));

        Map<String, User> map = createHashMap(items);
        for (String key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }
    }

    public static Map<String, User> createHashMap(List<User> items) {
        Map<String, User> map = items.stream().collect(Collectors.toMap(User::getId, Function.identity()));
        return map;
    }


    static void _2() {
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        Map<String, Integer> map =
                intList.stream().collect(toMap(i -> String.valueOf(i % 3),
                        i -> i,
                        (a, b) -> Integer.sum(a, b)));
        System.out.println(map);
    }

    static void _1() {
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        Map<String, Integer> map1 =
                intList.stream().collect(toMap(i -> String.valueOf(i), i -> i));
        System.out.println(map1);

        Map<String, Integer> map2 =
                intList.stream().collect(toMap(i -> "key " + String.valueOf(i), i -> i));
        System.out.println(map2);

        Map<String, Integer> map3 =
                intList.stream().collect(toMap(i -> "key " + String.valueOf(i), i -> i + i));
        System.out.println(map3);

        Map<String, String> map4 =
                intList.stream().collect(toMap(i -> "key " + String.valueOf(i), i -> "value  " + String.valueOf(i)));
        System.out.println(map4);

        Map<Integer, Double> map5 =
                intList.stream().collect(toMap(i -> i, i -> Double.valueOf(i)));
        System.out.println(map5);
    }
}
