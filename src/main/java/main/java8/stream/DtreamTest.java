package main.java8.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DtreamTest {
    public static void main(String[] args) {
        List<String> basicInput = List.of("08:John", "119:Anthony", "019:Nicolas",
                "037:Brad", "056:Britney", "043:Annie", "019:Jorge", "001:Bruce");
//        basicInput.stream()
//                .filter(c -> Integer.parseInt(c.split(":")[0])==19)
//                .forEach(System.out::println);
//        System.out.println();
//
//        basicInput.stream().map(c-> Integer.parseInt(c.split(":")[0]))
//                .sorted()
//                .distinct()
//                .forEach(System.out::println);
//
//        basicInput.stream().map(c->String.valueOf(c.split(":")[1]) + " " + Integer.valueOf(c.split(":")[0]))
//                .forEach(System.out::println);

//        Map<String, List<String>> collect = basicInput.stream().collect(Collectors.groupingBy(c -> c));
//        System.out.println(collect);
//        System.out.println();

        Map<String, String> collect1 = basicInput.stream().collect(Collectors.toMap(
                c -> c,
                c -> c
        ));
        System.out.println(collect1);


        Map<String, String> collect2 = basicInput.stream()
                .collect(Collectors.toMap(
                c -> c,
                c -> new String(c.split(":")[1])
        ));
        System.out.println("collect2 " + collect2);

        Map<String, String> collect4 = basicInput.stream()
                .collect(Collectors.toMap(
                        c -> c,
                        c -> String.valueOf(c.split(":")[1])
                ));
        System.out.println("collect4 " + collect4);


        Map<Integer, List<String>> collect3 = basicInput.stream()
                .collect(Collectors.groupingBy(c -> Integer.parseInt(c.split(":")[0])));
        System.out.println("collect3 " + collect3);


    }
}
